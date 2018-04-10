/*
        Copyright 2018 The Humanity Preservation Foundation

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.humanitypreservationfoundation.pulse.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

import org.humanitypreservationfoundation.pulse.enums.DensitiesEnum;

/**
 * Created by ETASpare on 3/9/2018.
 */

public class Utils {

    public static boolean isConnectedToInternet (Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

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
