package org.humanitypreservationfoundation.pulse.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by ETASpare on 3/9/2018.
 */

public class Utils {

    public static float pxToDp(Context context, float px){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float dpToPx(Context context, float dp){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
