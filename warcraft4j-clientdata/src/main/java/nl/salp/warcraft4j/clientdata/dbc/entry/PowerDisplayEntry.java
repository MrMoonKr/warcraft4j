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
import nl.salp.warcraft4j.clientdata.dbc.DbcDataType;
import nl.salp.warcraft4j.clientdata.dbc.DbcField;
import nl.salp.warcraft4j.clientdata.dbc.DbcMapping;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO Document.
 * <p/>
 * Note: the colors are saved as an unsigned byte in the files (0..255) but stored as a standard byte in Java (-128..127).
 *
 * @author Barre Dijkstra
 */
@DbcMapping(file = "PowerDisplay.dbc")
public class PowerDisplayEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.POWER_DISPLAY;

    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcField(order = 2, dataType = DbcDataType.UINT32, knownMeaning = false)
    private int actualType;
    @DbcField(order = 3, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String globalStringBaseTag;
    @DbcField(order = 4, dataType = DbcDataType.BYTE)
    private byte red;
    @DbcField(order = 5, dataType = DbcDataType.BYTE)
    private byte green;
    @DbcField(order = 6, dataType = DbcDataType.BYTE)
    private byte blue;
    @DbcField(order = 7, dataType = DbcDataType.BYTE, padding = true)
    private transient byte padding;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getActualType() {
        return actualType;
    }

    public String getGlobalStringBaseTag() {
        return globalStringBaseTag;
    }

    public byte getRed() {
        return red;
    }

    public byte getGreen() {
        return green;
    }

    public byte getBlue() {
        return blue;
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
