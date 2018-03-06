package org.humanitypreservationfoundation.pulse;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

/**
 * Created by ETASpare on 1/23/2018.
 */

public class State implements IState {

    private Context context;
    private String code;
    private VectorMasterDrawable vector; //todo remove
    private Path path;
    private PathModel pathModel;
    private Region region;

    public State(Context context, String stateCode, VectorMasterDrawable USMap) {
        this.context = context;
        this.code = stateCode;
        this.pathModel = USMap.getPathModelByName(this.code);
        this.path = this.pathModel.getPath();
        this.setRegion();
    }

    public String getCode() {
        return this.code;
    }

    public Path getPath() {
        return this.path;
    }

    public PathModel getPathModel() { //TODO: call this
        return this.pathModel;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setFillColor(String color) {
        this.pathModel.setFillColor(Color.parseColor(color));
    }

    public void setDefaultFillColor() {
        this.pathModel.setFillColor(Color.parseColor("#f9f9f9"));
    } //TODO Remove when confirmed unnecessary

    public Boolean checkForTap(int x, int y) {
        return this.region.contains(x, y);
    } //TODO remove when confirmed unnecessary

    private void setRegion() {
        RectF bounds = new RectF();
        this.path.computeBounds(bounds, true);
        this.region = new Region();
        this.region.setPath(this.path, new Region((int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom));
    }
}
