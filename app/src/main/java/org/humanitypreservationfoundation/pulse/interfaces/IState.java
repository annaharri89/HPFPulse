package org.humanitypreservationfoundation.pulse.interfaces;

import android.graphics.Path;
import android.graphics.Region;

import com.sdsmdg.harjot.vectormaster.models.PathModel;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;

import java.util.List;

/**
 * Created by ETASpare on 1/23/2018.
 */

public interface IState {
    String getCode();
    String getName();
    StateEnum getEnum();
    Path getPath();
    PathModel getPathModel();
    void setFillColor(String color);
    void setResources(List<Resource> resourceList);
    List<Resource> getChildAbuseResources();
    List<Resource> getBullyingResources();
    List<Resource> getDomesticViolenceResources();
    List<Resource> getAllResources();
}
