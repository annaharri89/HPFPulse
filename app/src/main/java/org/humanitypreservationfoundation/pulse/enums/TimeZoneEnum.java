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
