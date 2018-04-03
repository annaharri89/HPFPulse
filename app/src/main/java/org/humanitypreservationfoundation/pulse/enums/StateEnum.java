package org.humanitypreservationfoundation.pulse.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ETASpare on 3/7/2018.
 */

public enum StateEnum {
    //PST States
    ALASKA ("AK", "Alaska"),
    CALIFORNIA ("CA", "California"),
    HAWAII ("HI", "Hawaii"),
    OREGON ("OR", "Oregon"),
    WASHINGTON ("WA", "Washington"),

    //MT States
    ARIZONA ("AZ", "Arizona"),
    COLORADO ("CO", "Colorado"),
    IDAHO ("ID", "Idaho"),
    MONTANA ("MT", "Montana"),
    NEVADA ("NV", "Nevada"),
    NEW_MEXICO ("NM", "New Mexico"),
    UTAH ("UT", "Utah"),
    WYOMING ("WY", "Wyoming"),

    //WNC States
    IOWA ("IA", "Iowa"),
    KANSAS ("KS", "Kansas"),
    MINNESOTA ("MN", "Minnesota"),
    MISSOURI ("MO", "Missouri"),
    NEBRASKA ("NE", "Nebraska"),
    NORTH_DAKOTA ("ND", "North Dakota"),
    SOUTH_DAKOTA ("SD", "South Dakota"),

    //WSC States
    ARKANSAS ("AR", "Arkansas"),
    LOUISIANA ("LA", "Louisiana"),
    OKLAHOMA ("OK", "Oklahoma"),
    TEXAS ("TX", "Texas"),

    //ENC States
    ILLINOIS ("IL", "Illinois"),
    INDIANA ("IN", "Indiana"),
    MICHIGAN ("MI", "Michigan"),
    OHIO ("OH", "Ohio"),
    WISCONSIN ("WI", "Wisconsin"),

    //ESC States
    ALABAMA ("AL", "Alabama"),
    KENTUCKY ("KY", "Kentucky"),
    MISSISSIPPI ("MS", "Mississippi"),
    TENNESSEE ("TN", "Tennessee"),

    //MA States
    NEW_JERSEY ("NJ", "New Jersey"),
    NEW_YORK ("NY", "New York"),
    PENNSYLVANIA ("PA", "Pennsylvania"),

    //SA States
    DELAWARE ("DE", "Delaware"),
    FLORIDA ("FL", "Florida"),
    GEORGIA ("GA", "Georgia"),
    MARYLAND ("MD", "Maryland"),
    NORTH_CAROLINA ("NC", "North Carolina"),
    SOUTH_CAROLINA ("SC", "South Carolina"),
    VIRGINIA ("VA", "Virginia"),
    WEST_VIRGINIA ("WV", "West Virginia"),

    //NE States
    CONNECTICUT ("CT", "Connecticut"),
    MAINE ("ME", "Maine"),
    MASSACHUSETTS ("MA", "Massachusetts"),
    NEW_HAMPSHIRE ("NH", "New Hampshire"),
    RHODE_ISLAND ("RI", "Rhode Island"),
    VERMONT ("VT", "Vermont");

    String mCode;
    String mName;

    StateEnum(String code, String name) {
        this.mCode = code;
        this.mName = name;
    }

    public String toStringCode() {
        return this.mCode;
    }

    public String toStringName() {
        return this.mName;
    }

    static public List<StateEnum> getTimeZoneStateCodes(TimeZoneEnum timeZoneEnum) {
        List<StateEnum> ALLStates = Arrays.asList(
                ALABAMA,
                ALASKA,
                ARIZONA,
                ARKANSAS,
                CALIFORNIA,
                COLORADO,
                CONNECTICUT,
                DELAWARE,
                FLORIDA,
                GEORGIA,
                HAWAII,
                IDAHO,
                ILLINOIS,
                INDIANA,
                IOWA,
                KANSAS,
                KENTUCKY,
                LOUISIANA,
                MAINE,
                MARYLAND,
                MASSACHUSETTS,
                MICHIGAN,
                MINNESOTA,
                MISSISSIPPI,
                MISSOURI,
                MONTANA,
                NEBRASKA,
                NEVADA,
                NEW_HAMPSHIRE,
                NEW_JERSEY,
                NEW_MEXICO,
                NEW_YORK,
                NORTH_CAROLINA,
                NORTH_DAKOTA,
                OHIO,
                OKLAHOMA,
                OREGON,
                PENNSYLVANIA,
                RHODE_ISLAND,
                SOUTH_CAROLINA,
                SOUTH_DAKOTA,
                TENNESSEE,
                TEXAS,
                UTAH,
                VERMONT,
                VIRGINIA,
                WASHINGTON,
                WEST_VIRGINIA,
                WISCONSIN,
                WYOMING
        );

        List<StateEnum> PSTStates = Arrays.asList(
                ALASKA,
                CALIFORNIA,
                HAWAII,
                OREGON,
                WASHINGTON
        );

        List<StateEnum> MTStates = Arrays.asList(
                ARIZONA,
                COLORADO,
                IDAHO,
                MONTANA,
                NEVADA,
                NEW_MEXICO,
                UTAH,
                WYOMING
        );

        List<StateEnum> WNCStates = Arrays.asList(
                IOWA,
                KANSAS,
                MINNESOTA,
                MISSOURI,
                NEBRASKA,
                NORTH_DAKOTA,
                SOUTH_DAKOTA
        );
        List<StateEnum> WSCStates = Arrays.asList(
                ARKANSAS,
                LOUISIANA,
                OKLAHOMA,
                TEXAS
        );

        List<StateEnum> ENCStates = Arrays.asList(
                ILLINOIS,
                INDIANA,
                MICHIGAN,
                OHIO,
                WISCONSIN
        );

        List<StateEnum> ESCStates = Arrays.asList(
                ALABAMA,
                KENTUCKY,
                MISSISSIPPI,
                TENNESSEE
        );

        List<StateEnum> MAStates = Arrays.asList(
                NEW_JERSEY,
                NEW_YORK,
                PENNSYLVANIA
        );

        List<StateEnum> SAStates = Arrays.asList(
                DELAWARE,
                FLORIDA,
                GEORGIA,
                MARYLAND,
                NORTH_CAROLINA,
                SOUTH_CAROLINA,
                VIRGINIA,
                WEST_VIRGINIA
        );

        List<StateEnum> NEStates = Arrays.asList(
                CONNECTICUT,
                MAINE,
                MASSACHUSETTS,
                NEW_HAMPSHIRE,
                RHODE_ISLAND,
                VERMONT
        );

        switch (timeZoneEnum) {
            default:
            case ALL:
                return ALLStates;
            case PST:
                return PSTStates;
            case MT:
                return MTStates;
            case WNC:
                return WNCStates;
            case WSC:
                return WSCStates;
            case ENC:
                return ENCStates;
            case ESC:
                return ESCStates;
            case MA:
                return MAStates;
            case SA:
                return SAStates;
            case NE:
                return NEStates;
        }
    }
}

