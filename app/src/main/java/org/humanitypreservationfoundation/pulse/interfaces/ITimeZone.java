package org.humanitypreservationfoundation.pulse.interfaces;

import android.graphics.Region;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.State;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by ETASpare on 1/27/2018.
 */

public interface ITimeZone {
    List<State> getStates();
    String getName();
    String getCode();
    String getColorCode();
    TimeZoneEnum getEnum();
    String getDescription();
    void changeFillColor(String qualifier);
    void setResources(Map<StateEnum, List<Resource>> resourceMap);
    List<Resource> getStateChildAbuseResources(String stateCode);
    List<Resource> getStateBullyingResources(String stateCode);
    List<Resource> getStateDomesticViolenceResources(String stateCode);
    List<Resource> getAllStateResources(String stateCode);
}
