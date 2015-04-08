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
@DbcMapping(file = "ItemToMountSpell.db2")
public class ItemToMountSpellEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.ITEM_TO_MOUNT_SPELL;
    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int itemId;
    @DbcField(order = 2, dataType = DbcDataType.UINT32)
    private int spellId;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getSpellId() {
        return spellId;
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
