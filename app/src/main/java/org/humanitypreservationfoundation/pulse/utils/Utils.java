package org.humanitypreservationfoundation.pulse.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import org.humanitypreservationfoundation.pulse.enums.DensitiesEnum;

/**
 * Created by ETASpare on 3/9/2018.
 */

public class Utils {

    public static DensitiesEnum getScreenDensity(Context context) {
        int dpi = context.getResources().getDisplayMetrics().densityDpi;

        if (dpi <= DisplayMetrics.DENSITY_LOW) {
            return DensitiesEnum.LDPI;
        } else if (dpi <= DisplayMetrics.DENSITY_MEDIUM) {
            return DensitiesEnum.MDPI;
        } else if (dpi <= DisplayMetrics.DENSITY_HIGH) {
            return DensitiesEnum.HDPI;
        } else if (dpi <= DisplayMetrics.DENSITY_XHIGH) {
            return DensitiesEnum.XHDPI;
        } else if (dpi <= DisplayMetrics.DENSITY_XXHIGH) {
            return DensitiesEnum.XXHDPI;
        } else if (dpi <= DisplayMetrics.DENSITY_XXXHIGH) {
            return DensitiesEnum.XXXHDPI;
        } else {
            return DensitiesEnum.UNKNOWN;
        }
    }

    public static float pxToDp(Context context, float px){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float dpToPx(Context context, float dp){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
