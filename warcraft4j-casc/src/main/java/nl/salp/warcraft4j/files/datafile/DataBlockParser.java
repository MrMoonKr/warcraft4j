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

package nl.salp.warcraft4j.files.datafile;

import nl.salp.warcraft4j.io.DataParser;
import nl.salp.warcraft4j.io.DataReader;

import java.io.IOException;

/**
 * {@link DataParser} implementation for {@link DataBlock}.
 *
 * @author Barre Dijkstra
 */
class DataBlockParser implements DataParser<DataBlock> {
    @Override
    public DataBlock next(DataReader reader) throws IOException {
        DataHeader header = reader.readNext(new DataHeaderParser());
        byte[] data = reader.readNextBytes(header.getDataSize());
        return new DataBlock(header, data);
    }
}