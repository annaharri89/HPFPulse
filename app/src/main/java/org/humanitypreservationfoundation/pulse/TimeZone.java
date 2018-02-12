package org.humanitypreservationfoundation.pulse;

import android.content.Context;
import android.graphics.Region;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import java.util.ArrayList;
import java.util.List;

public class TimeZone implements ITimeZone {
    private Context context;
    private List<State> states = new ArrayList<State>();
    private String name;
    private String description;
    private String code;
    private Region region;
    private String color;

    public TimeZone (Context context, String timeZoneCode, List<String> timeZoneStates, VectorMasterDrawable USMap) {
        this.context = context;
        this.code = timeZoneCode;
        for (String stateCode : timeZoneStates) {
            State state = new State(this.context, stateCode, USMap);
            this.states.add(state);
        }
        this.name = this.getStrResource("_name");
        this.description = this.getStrResource("_description"); //TODO figure out how to display in textview onHover
        this.color = this.getClrResource("_default");
        this.setRegion();
        this.setFillColor();
    }

    public List<State> getStates() {
        return this.states;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
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

    private String getStrResource(String qualifier) {
        int resourceId = this.context.getResources().getIdentifier(this.code + qualifier, "string", this.context.getPackageName());
        return this.context.getString(resourceId);
    }

    private String getClrResource(String qualifier) {
        int resourceId = this.context.getResources().getIdentifier(this.code + qualifier, "color", this.context.getPackageName());
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
