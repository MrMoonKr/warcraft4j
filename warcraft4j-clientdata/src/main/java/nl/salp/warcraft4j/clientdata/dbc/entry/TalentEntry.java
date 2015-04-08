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
@DbcMapping(file = "Talent.dbc")
public class TalentEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.TALENT;
    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcField(order = 2, dataType = DbcDataType.UINT32)
    private int specId;
    @DbcField(order = 3, dataType = DbcDataType.UINT32)
    private int tierId;
    @DbcField(order = 4, dataType = DbcDataType.UINT32)
    private int columnIndex;
    @DbcField(order = 5, dataType = DbcDataType.UINT32)
    private int spellId;
    @DbcField(order = 6, dataType = DbcDataType.UINT32)
    private int flags;
    @DbcField(order = 7, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] categoryMask; // 2
    @DbcField(order = 8, dataType = DbcDataType.UINT32)
    private int classId;
    @DbcField(order = 9, dataType = DbcDataType.UINT32)
    private int overridesSpellId;
    @DbcField(order = 10, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String description;

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
