package org.humanitypreservationfoundation.pulse;

import android.graphics.Path;
import android.graphics.Region;

import com.sdsmdg.harjot.vectormaster.models.PathModel;

/**
 * Created by ETASpare on 1/23/2018.
 */

public interface IState {
    String getCode();
    Path getPath();
    PathModel getPathModel();
    Region getRegion();
    void setFillColor(String color);
}
