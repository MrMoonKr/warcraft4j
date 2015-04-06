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

package nl.salp.warcraft4j.service;

import nl.salp.warcraft4j.Language;
import nl.salp.warcraft4j.Region;
import nl.salp.warcraft4j.model.character.PlayerCharacter;
import nl.salp.warcraft4j.model.data.Realm;

/**
 * Service for character information.
 *
 * @author Barre Dijkstra
 */
public interface PlayerCharacterService {
    /**
     * Find a player character.
     *
     * @param region   The region the character is on.
     * @param realm    The realm of the character.
     * @param name     The name of the character.
     * @param language The language to get the result texts in.
     *
     * @return The character.
     *
     * @throws NotFoundException When no character matching the given information could be found.
     * @throws ServiceException  When there was a problem finding the character.
     */
    PlayerCharacter find(Region region, Realm realm, String name, Language language) throws NotFoundException, ServiceException;
}