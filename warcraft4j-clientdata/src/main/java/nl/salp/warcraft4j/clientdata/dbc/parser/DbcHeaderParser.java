package nl.salp.warcraft4j.clientdata.dbc.parser;

import nl.salp.warcraft4j.clientdata.io.*;

import java.io.IOException;

/**
 * {@link DataParser} implementation for reading and parsing an {@link DbcHeader} instance.
 *
 * @author Barre Dijkstra
 */
public class DbcHeaderParser extends RandomAccessDataParser<DbcHeader> {
    /** The magic String for a DBC file. */
    public static final String DBC_MAGICSTRING = "WDBC";
    /** The header size of a DBC file. */
    private static final int DBC_HEADER_SIZE = 20;
    /** The magic string for a DB2 file. */
    public static final String DB2_MAGICSTRING = "WDB2";
    /** The magic string for an ADB file. */
    public static final String ADB_MAGICSTRING = "WCH2";
    /** The default header size of a DB2. */
    private static final int DB2_HEADER_SIZE = 32;
    /** The version of the last build before the extended DB2 header was introduced. */
    public static final int DB2_LASTBUILD_BEFORE_EXTENSION = 12880;
    /** The base size for an extended DB2 header. */
    private static final int DB2_EXTENDED_HEADER_SIZE_BASE = 48;
    /** The length of the magic string. */
    private static final int MAGIC_STRING_LENGTH = 4;


    @Override
    public DbcHeader parse(DataReader reader) throws IOException, DataParsingException {
        DbcHeader.Builder builder = new DbcHeader.Builder();
        // DBC parsing
        String magicString = reader.readNextFixedLengthString(MAGIC_STRING_LENGTH);
        int headerSize = DBC_HEADER_SIZE;
        builder.withMagicString(magicString);
        builder.withEntryCount(reader.readNextInt32());
        builder.withEntryFieldCount(reader.readNextInt32());
        builder.withSingleEntrySize(reader.readNextInt32());
        builder.withStringTableBlockSize(reader.readNextInt32());
        // DB2 parsing.
        if (DB2_MAGICSTRING.equals(magicString) || ADB_MAGICSTRING.equals(magicString)) {
            headerSize = DB2_HEADER_SIZE;
            builder.withStringTableBlockHash(reader.readNextInt32());
            int buildNumber = reader.readNextInt32();
            builder.withBuildNumber(buildNumber);
            builder.withTimestampLastWritten(reader.readNextInt32());

            if (buildNumber > DB2_LASTBUILD_BEFORE_EXTENSION) {
                headerSize = DB2_EXTENDED_HEADER_SIZE_BASE;
                int minEntryId = reader.readNextInt32();
                builder.withMinEntryId(minEntryId);
                int maxEntryId = reader.readNextInt32();
                builder.withMaxEntryId(maxEntryId);
                builder.withLocaleId(reader.readNextInt32());
                builder.withUnknownDataBlock(reader.readNextBytes(4));
                if (maxEntryId > 0) {
                    int entryCount = maxEntryId - minEntryId + 1;
                    builder.withRowIndexes(reader.readNextInt32Array(entryCount));
                    builder.withRowStringLength(reader.readNextShortArray(entryCount));

                    headerSize += (entryCount * DataType.getInteger().getLength());
                    headerSize += (entryCount * DataType.getShort().getLength());
                }
            }
        }
        builder.withHeaderSize(headerSize);
        return builder.build();
    }

    @Override
    public int getInstanceDataSize() {
        return DBC_HEADER_SIZE;
    }
}
