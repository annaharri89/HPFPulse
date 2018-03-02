package org.humanitypreservationfoundation.pulse;

import android.content.Context;
import android.graphics.Region;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

import java.util.ArrayList;
import java.util.List;

public class TimeZone implements ITimeZone {
    private Context context;
    private List<State> states = new ArrayList<State>();
    private String name;
    private String description;
    private TimeZoneEnum code;
    private Region region;
    private String color;
    private String colorCode;

    private static final String COLOR_PREFIX = "map_";

    public TimeZone (Context context, String colorCode, TimeZoneEnum timeZoneEnum, List<String> timeZoneStates, VectorMasterDrawable USMap) {
        this.context = context;
        this.code = timeZoneEnum; //todo should this use TimeZoneEnum enum value?
        for (String stateCode : timeZoneStates) {
            State state = new State(this.context, stateCode, USMap);
            this.states.add(state);
        }
        this.name = timeZoneEnum.toString();
        //this.name = this.getStrResource("_name");
        //this.description = this.getStrResource("_description"); //TODO figure out how to display in textview onHover
        this.colorCode = colorCode;
        this.color = this.getClrResource(this.colorCode);
        this.setRegion();
        this.setFillColor();
    }

    public List<State> getStates() {
        return this.states;
    }

    public String getDescription() {
        return this.description;
    }

    public TimeZoneEnum getCode() {
        return this.code;
    }

    public String getColorCode() {
        return  this.colorCode;
    }

    public String getName() {
        return this.name;
    }

    public Region getRegion() {
        return this.region;
    }

    public void changeFillColor(String qualifier) {
        this.color = this.getClrResource(qualifier);
        setFillColor();
    }

    /*
    public Boolean checkStatesForTap(int x, int y) { //TODO: Remove when confirmed unnecessary
        /*for (State state : this.states) {
            if (state.checkForTap(x, y)) {
                this.setHighlightFillColor();
                return true;
            }
        }
        this.setDefaultFillColor();
        return false;
        */
    /*
        if (this.region.contains(x, y)) {
            this.setHighlightFillColor();
            return true;
        } else {
            this.setDefaultFillColor();
            return false;
        }
    }
    */

    /*
    private String getStrResource(String qualifier) {
        int resourceId = this.context.getResources().getIdentifier(this.code + qualifier, "string", this.context.getPackageName());
        return this.context.getString(resourceId);
    } */

    private String getClrResource(String qualifier) {
        int resourceId = this.context.getResources().getIdentifier(COLOR_PREFIX + qualifier, "color", this.context.getPackageName());
        return this.context.getString(resourceId);
    }

    private void setFillColor() {
        for (State state : this.states) {
            state.setFillColor(this.color);
        }
    }

    private void setRegion() {
        this.region = new Region();
        for (State state : this.states) {
            this.region.op(state.getRegion(), Region.Op.UNION);
        }
    }
}
