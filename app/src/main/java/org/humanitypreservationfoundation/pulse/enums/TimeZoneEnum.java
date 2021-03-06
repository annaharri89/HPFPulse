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
package org.humanitypreservationfoundation.pulse.enums;

/**
 * Created by ETASpare on 3/1/2018.
 */

public enum TimeZoneEnum {
    ALL ("ALL", "All Regions"),
    PST ("PST", "Pacific"),
    MT ("MT", "Mountain"),
    WNC ("WNC", "West North Central"),
    WSC ("WSC", "West South Central"),
    ENC ("ENC", "East North Central"),
    ESC ("ESC", "East South Central"),
    MA ("MA", "Mid Atlantic"),
    SA ("SA", "South Atlantic"),
    NE ("NE", "New England");

    String code;
    String name;

    TimeZoneEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String toStringCode() {
        return this.code;
    }

    public String toStringName() {
        return this.name;
    }
}
