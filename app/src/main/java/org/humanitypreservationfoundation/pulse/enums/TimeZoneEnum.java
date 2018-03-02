package org.humanitypreservationfoundation.pulse.enums;

/**
 * Created by ETASpare on 3/1/2018.
 */

public enum TimeZoneEnum {
    ALL ("All Regions"),
    PST ("Pacific"),
    MT ("Mountain"),
    WNC ("West North Central"),
    WSC ("West South Central"),
    ENC ("East North Central"),
    ESC ("East South Central"),
    MA ("Mid Atlantic"),
    SA ("South Atlantic"),
    NE ("New England");

    String name;

    TimeZoneEnum(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
