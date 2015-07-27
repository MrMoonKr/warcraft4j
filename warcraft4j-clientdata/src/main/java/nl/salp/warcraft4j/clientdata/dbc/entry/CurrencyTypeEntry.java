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
package nl.salp.warcraft4j.clientdata.dbc.entry;

import nl.salp.warcraft4j.clientdata.dbc.DbcEntry;
import nl.salp.warcraft4j.clientdata.dbc.DbcType;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcDataType;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcFieldMapping;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcMapping;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO Document class.
 *
 * @author Barre Dijkstra
 */
@DbcMapping(file = "CurrencyTypes.db2")
public class CurrencyTypeEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.CURRENCY_TYPE;

    @DbcFieldMapping(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcFieldMapping(order = 2, dataType = DbcDataType.UINT32)
    @DbcReference(type = DbcType.CURRENCY_CATEGORY)
    private int currencyCategoryId;
    @DbcFieldMapping(order = 3, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String name;
    @DbcFieldMapping(order = 4, dataType = DbcDataType.STRINGTABLE_REFERENCE, numberOfEntries = 2)
    private String[] inventoryIcon;
    @DbcFieldMapping(order = 5, dataType = DbcDataType.UINT32)
    private int spellWeight;
    @DbcFieldMapping(order = 6, dataType = DbcDataType.UINT32)
    private int spellCategory;
    @DbcFieldMapping(order = 7, dataType = DbcDataType.UINT32)
    private int maxQuantity;
    @DbcFieldMapping(order = 8, dataType = DbcDataType.UINT32)
    private int maxEarnablePerWeek;
    @DbcFieldMapping(order = 9, dataType = DbcDataType.UINT32)
    private int flags;
    @DbcFieldMapping(order = 10, dataType = DbcDataType.UINT32)
    private int quality;
    @DbcFieldMapping(order = 11, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String description;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getCurrencyCategoryId() {
        return currencyCategoryId;
    }

    public String getName() {
        return name;
    }

    public String[] getInventoryIcon() {
        return inventoryIcon;
    }

    public int getSpellWeight() {
        return spellWeight;
    }

    public int getSpellCategory() {
        return spellCategory;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getMaxEarnablePerWeek() {
        return maxEarnablePerWeek;
    }

    public int getFlags() {
        return flags;
    }

    public int getQuality() {
        return quality;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
