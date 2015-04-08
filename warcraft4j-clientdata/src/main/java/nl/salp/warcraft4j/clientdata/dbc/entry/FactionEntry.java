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
 * TODO Document class.
 *
 * @author Barre Dijkstra
 */
@DbcMapping(file = "Faction.dbc")
public class FactionEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.FACTION;
    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcField(order = 2, dataType = DbcDataType.UINT32)
    private int reputationIndex;
    @DbcField(order = 3, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationRaceMask; // 4
    @DbcField(order = 4, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationClassMask; // 4
    @DbcField(order = 5, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationBase; // 4
    @DbcField(order = 6, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationFlags; // 4
    @DbcField(order = 7, dataType = DbcDataType.UINT32)
    private int parentFactionId;
    @DbcField(order = 8, dataType = DbcDataType.FLOAT, numberOfEntries = 2)
    private float[] parentFactionModifier; // 2
    @DbcField(order = 9, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] parentFactionCap; // 2
    @DbcField(order = 10, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String name;
    @DbcField(order = 11, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String description;
    @DbcField(order = 12, dataType = DbcDataType.UINT32)
    private int expansion;
    @DbcField(order = 13, dataType = DbcDataType.UINT32)
    private int flags;
    @DbcField(order = 14, dataType = DbcDataType.UINT32)
    private int friendshipReputationId;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
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
