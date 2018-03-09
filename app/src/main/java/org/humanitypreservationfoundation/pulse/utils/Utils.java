package org.humanitypreservationfoundation.pulse.utils;

import android.content.Context;

/**
 * Created by ETASpare on 3/9/2018.
 */

public class Utils {
    public static int dpToPx(Context context, int heightDP){
        float density = context.getResources().getDisplayMetrics().density;
        heightDP = (int) (heightDP * density + 0.5f);
        return heightDP;
    }
}
