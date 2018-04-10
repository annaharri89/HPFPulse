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
package org.humanitypreservationfoundation.pulse;

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
