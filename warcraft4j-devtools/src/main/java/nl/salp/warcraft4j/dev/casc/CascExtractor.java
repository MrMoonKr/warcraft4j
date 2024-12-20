/*
 * Licensed to the Warcraft4J Project under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The Warcraft4J Project licenses
 * this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package nl.salp.warcraft4j.dev.casc;

import nl.salp.warcraft4j.casc.cdn.local.LocalCdnCascContext;
import nl.salp.warcraft4j.casc.cdn.util.CascFileExtractor;
import nl.salp.warcraft4j.dev.DevToolsConfig;
import nl.salp.warcraft4j.dev.casc.model.ListFile;

import java.nio.file.Paths;

/**
 * TODO Document class.
 *
 * @author Barre Dijkstra
 */
public class CascExtractor {

    private ListFile listFile;
    private LocalCdnCascContext context;
    private CascFileExtractor extractor;

    public CascExtractor( DevToolsConfig devToolsConfig, String path ) throws Exception 
    {
        context = new LocalCdnCascContext( devToolsConfig );

        listFile = ListFile.fromFile( devToolsConfig.getListFilePath() );
        listFile.getCascFiles().stream()
                .filter( file -> file.getFilename().isPresent() )
                .forEach( file -> context.resolve( file.getFilename().get(), file.getFilenameHash() ) );
                
        extractor = new CascFileExtractor( Paths.get( path ), context );
    }

    public void findAllDbcFiles() {

    }

    public void extractAllFiles() {
        extractor.extractAllFiles().forEach( System.out::println );
    }

    /**
     * 진입점 함수
     * @param args
     * @throws Exception
     */
    public static void main( String... args ) throws Exception 
    {
        CascExtractor extractor = new CascExtractor( DevToolsConfig.fromFile( "w4j_devtools.config" ),
                "C:\\w4j\\test\\extracted" );
    }
}
