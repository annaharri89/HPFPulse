package org.humanitypreservationfoundation.pulse;

import android.graphics.Region;
import java.util.List;

/**
 * Created by ETASpare on 1/27/2018.
 */

public interface ITimeZone {
    List<State> getStates();
    String getName();
    String getCode();
    String getDescription();
    Region getRegion();
    void changeFillColor(String qualifier);
    //Boolean checkStatesForTap(int x, int y); TODO remove when confirmed unnecessary
}
