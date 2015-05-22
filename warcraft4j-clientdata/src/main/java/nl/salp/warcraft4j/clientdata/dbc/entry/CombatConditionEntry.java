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
import nl.salp.warcraft4j.clientdata.dbc.parser.DbcDataType;
import nl.salp.warcraft4j.clientdata.dbc.parser.DbcField;
import nl.salp.warcraft4j.clientdata.dbc.parser.DbcMapping;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO Document class.
 *
 * @author Barre Dijkstra
 */
@DbcMapping(file = "CombatCondition.dbc")
public class CombatConditionEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.COMBAT_CONDITION;
    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcField(order = 2, dataType = DbcDataType.UINT32)
    private int worldStateExpressionId;
    @DbcField(order = 3, dataType = DbcDataType.UINT32)
    private int selfConditionId;
    @DbcField(order = 4, dataType = DbcDataType.UINT32)
    private int targetConditionId;
    @DbcField(order = 5, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] friendConditionId; // 2
    @DbcField(order = 6, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] friendConditionOp; // 2
    @DbcField(order = 7, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] friendConditionCount; // 2
    @DbcField(order = 8, dataType = DbcDataType.UINT32)
    private int friendConditionLogic;
    @DbcField(order = 9, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] enemyConditionId; // 2
    @DbcField(order = 10, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] enemyConditionOp; // 2
    @DbcField(order = 11, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] enemyConditionCount; // 2
    @DbcField(order = 12, dataType = DbcDataType.UINT32)
    private int enemyConditionLogic;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getWorldStateExpressionId() {
        return worldStateExpressionId;
    }

    public int getSelfConditionId() {
        return selfConditionId;
    }

    public int getTargetConditionId() {
        return targetConditionId;
    }

    public int[] getFriendConditionId() {
        return friendConditionId;
    }

    public int[] getFriendConditionOp() {
        return friendConditionOp;
    }

    public int[] getFriendConditionCount() {
        return friendConditionCount;
    }

    public int getFriendConditionLogic() {
        return friendConditionLogic;
    }

    public int[] getEnemyConditionId() {
        return enemyConditionId;
    }

    public int[] getEnemyConditionOp() {
        return enemyConditionOp;
    }

    public int[] getEnemyConditionCount() {
        return enemyConditionCount;
    }

    public int getEnemyConditionLogic() {
        return enemyConditionLogic;
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
