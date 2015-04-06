package nl.salp.warcraft4j.clientdatabase.entry;

import nl.salp.warcraft4j.clientdatabase.ClientDatabaseEntry;
import nl.salp.warcraft4j.clientdatabase.ClientDatabaseEntryType;
import nl.salp.warcraft4j.clientdatabase.parser.DbcDataType;
import nl.salp.warcraft4j.clientdatabase.parser.DbcField;
import nl.salp.warcraft4j.clientdatabase.parser.DbcFile;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO Document class.
 *
 * @author Barre Dijkstra
 */
@DbcFile(file = "Cfg_Categories.db2")
public class ConfigCategoryEntry implements ClientDatabaseEntry {
    private static final ClientDatabaseEntryType ENTRY_TYPE = ClientDatabaseEntryType.CONFIG_CATEGORY;

    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcField(order = 2, dataType = DbcDataType.UINT32)
    private int localeMask; // 205: EU, 256: Russia, 0: rest.
    @DbcField(order = 3, dataType = DbcDataType.UINT32)
    private int createCharsetMask; // 0: Development, 1: US and EU, 4: Russia, 10: Korea, 17: Taiwan & China
    @DbcField(order = 4, dataType = DbcDataType.UINT32)
    private int existingCharsetMask; // 0: Development, 1: US and EU, 4: Russia, 10: Korea, 17: Taiwan & China
    @DbcField(order = 5, dataType = DbcDataType.UINT32)
    private int flags; // 1: tournaments enabled on account
    @DbcField(order = 6, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String name;

    @Override
    public ClientDatabaseEntryType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getLocaleMask() {
        return localeMask;
    }

    public int getCreateCharsetMask() {
        return createCharsetMask;
    }

    public int getExistingCharsetMask() {
        return existingCharsetMask;
    }

    public int getFlags() {
        return flags;
    }

    public String getName() {
        return name;
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