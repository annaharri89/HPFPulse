package org.humanitypreservationfoundation.pulse;

import android.app.Activity;

import org.humanitypreservationfoundation.pulse.activities.MapActivity;

/**
 * Created by ETASpare on 3/5/2018.
 */

public class Config {
    public static final class categories {
        public static final String ALL_RESOURCES = "All Resources";
        public static final String CHILD_ABUSE ="Child Abuse";
        public static final String BULLYING = "Bullying";
        public static final String DOMESTIC_VIOLENCE = "Domestic Violence";
    }

    public static final class intents {
        public static final String ACTIVITY_EXTRA = "ActivityTitle";
        public static final String TIMEZONE_EXTRA = "TimeZone";
    }

    public static final class data {
        public static final String URL = "http://dev.humanitypreservationfoundation.org/wp-json/pulse/v1/states";
    }
}
