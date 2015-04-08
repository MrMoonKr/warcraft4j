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
@DbcMapping(file = "AnimKit.dbc")
public class AnimationKitEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.ANIMATION_KIT;
    // TODO Implement me!
    @DbcField(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcField(order = 2, dataType = DbcDataType.UINT32)
    private int oneShotDuration;
    @DbcField(order = 3, dataType = DbcDataType.UINT32)
    private int oneShotStopAnimationKitId;
    @DbcField(order = 4, dataType = DbcDataType.UINT32)
    private int lowDefinitionAnimationKitId;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getOneShotDuration() {
        return oneShotDuration;
    }

    public int getOneShotStopAnimationKitId() {
        return oneShotStopAnimationKitId;
    }

    public int getLowDefinitionAnimationKitId() {
        return lowDefinitionAnimationKitId;
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
