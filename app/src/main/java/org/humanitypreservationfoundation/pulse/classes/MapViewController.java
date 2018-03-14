package org.humanitypreservationfoundation.pulse.classes;

import android.content.Context;

import org.humanitypreservationfoundation.pulse.enums.DensitiesEnum;

import org.humanitypreservationfoundation.pulse.utils.Utils;

/**
 * Created by ETASpare on 3/14/2018.
 */

public class MapViewController {

    public static int getTimeZoneLabelTextSize(DensitiesEnum dpi) {
        switch (dpi) {
            default:
            case LDPI:
                return 8;
            case MDPI:
                return 10;
            case HDPI:
                return 17;
            case XHDPI:
                return 27;
            case XXHDPI:
                return 40;
            case XXXHDPI:
                return 60;
        }
    }
    public static int getTimeZoneLabelTextStroke(DensitiesEnum dpi) {
        switch (dpi) {
            default:
            case LDPI:
                return 4;
            case MDPI:
                return 4;
            case HDPI:
                return 5;
            case XHDPI:
                return 7;
            case XXHDPI:
                return 8;
            case XXXHDPI:
                return 11;
        }
    }

    /**
     * Calculates the y position to draw the time zone labels.
     */
    public static float calculateTop(Context context, DensitiesEnum dpi, TimeZone timeZone){
        float topDp = Utils.pxToDp(context, timeZone.getRegion().getBounds().top);
        float bottomDp = Utils.pxToDp(context, timeZone.getRegion().getBounds().bottom);
        float finalDp = (topDp + bottomDp) / 2; //this is the average dp

        switch (timeZone.getEnum()) {
            default:
            case PST:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 320; // move up
                        break;
                    case MDPI:
                        finalDp -= 220; // move up
                        break;
                    case HDPI:
                        finalDp -= 125; // move up
                        break;
                    case XHDPI:
                        finalDp -= 55; // move up
                        break;
                    case XXHDPI:
                        finalDp += 18; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 45; // move down
                        break;
                }
                break;
            case MT:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 270; // move up
                        break;
                    case MDPI:
                        finalDp -= 190; // move up
                        break;
                    case HDPI:
                        finalDp -= 125; // move up
                        break;
                    case XHDPI:
                        finalDp -= 50; // move up
                        break;
                    case XXHDPI:
                        finalDp += 18; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 35; // move down
                        break;
                }
                break;
            case WNC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 220; // move up
                        break;
                    case MDPI:
                        finalDp -= 150; // move up
                        break;
                    case HDPI:
                        finalDp -= 85; // move up
                        break;
                    case XHDPI:
                        finalDp -= 50; // move up
                        break;
                    case XXHDPI:
                        finalDp += 18; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 45; // move down
                        break;
                }
                break;
            case WSC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 475; // move up
                        break;
                    case MDPI:
                        finalDp -= 335; // move up
                        break;
                    case HDPI:
                        finalDp -= 190; // move up
                        break;
                    case XHDPI:
                        finalDp -= 80; // move up
                        break;
                    case XXHDPI:
                        finalDp += 18; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 55; // move down
                        break;
                }
                break;
            case ENC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 210; // move up
                        break;
                    case MDPI:
                        finalDp -= 150; // move up
                        break;
                    case HDPI:
                        finalDp -= 90; // move up
                        break;
                    case XHDPI:
                        finalDp -= 45; // move up
                        break;
                    case XXHDPI:
                        finalDp += 18; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 45; // move down
                        break;
                }
                break;
            case ESC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 375; // move up
                        break;
                    case MDPI:
                        finalDp -= 260; // move up
                        break;
                    case HDPI:
                        finalDp -= 145; // move up
                        break;
                    case XHDPI:
                        finalDp -= 50; // move up
                        break;
                    case XXHDPI:
                        finalDp += 30; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 65; // move down
                        break;
                }
                break;
            case MA:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 195; // move up
                        break;
                    case MDPI:
                        finalDp -= 140; // move up
                        break;
                    case HDPI:
                        finalDp -= 85; // move up
                        break;
                    case XHDPI:
                        finalDp -= 45; // move up
                        break;
                    case XXHDPI:
                        finalDp += 12; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 15; // move down
                        break;
                }
                break;
            case SA:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 420; // move up
                        break;
                    case MDPI:
                        finalDp -= 290; // move up
                        break;
                    case HDPI:
                        finalDp -= 160; // move up
                        break;
                    case XHDPI:
                        finalDp -= 70; // move up
                        break;
                    case XXHDPI:
                        finalDp += 18; // move down
                        break;
                    case XXXHDPI:
                        finalDp += 45; // move down
                        break;
                }
                break;
            case NE:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 115; // move up
                        break;
                    case MDPI:
                        finalDp -= 80; // move up
                        break;
                    case HDPI:
                        finalDp -= 55; // move up
                        break;
                    case XHDPI:
                        finalDp -= 35; // move up
                        break;
                    case XXHDPI:
                        finalDp += 0; // don't move
                        break;
                    case XXXHDPI:
                        finalDp += 5; // move down
                        break;
                }
                break;
        }
        return Utils.dpToPx(context, finalDp);
    }

    /**
     * Calculates the x position to draw the time zone labels.
     */
    public static float calculateLeft(Context context, DensitiesEnum dpi, TimeZone timeZone){
        float leftDp = Utils.pxToDp(context, timeZone.getRegion().getBounds().left);
        float rightDp = Utils.pxToDp(context, timeZone.getRegion().getBounds().right);
        float finalDp = (leftDp + rightDp) / 2; //this is the average dp
        switch (timeZone.getEnum()) {
            default:
            case PST:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 250; // move to left
                        break;
                    case MDPI:
                        finalDp -= 160; // move to left
                        break;
                    case HDPI:
                        finalDp -= 90; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 60; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 25; // move to left
                        break;
                    case XXXHDPI:
                        finalDp -= 5; // move to left
                        break;
                }
                break;
            case MT:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 380; // move to left
                        break;
                    case MDPI:
                        finalDp -= 255; //move to left
                        break;
                    case HDPI:
                        finalDp -= 130; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 80; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 25; // move to left
                        break;
                    case XXXHDPI:
                        finalDp += 5; // move to left
                        break;
                }
                break;
            case WNC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 620; // move to left
                        break;
                    case MDPI:
                        finalDp -= 420; //move to left
                        break;
                    case HDPI:
                        finalDp -= 230; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 110; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 17; // move to left
                        break;
                    case XXXHDPI:
                        finalDp += 40; // move to right
                        break;
                }
                break;
            case WSC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 595; // move to left
                        break;
                    case MDPI:
                        finalDp -= 405; //move to left
                        break;
                    case HDPI:
                        finalDp -= 220; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 100; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 5; // move to left
                        break;
                    case XXXHDPI:
                        finalDp += 45; // move to right
                        break;
                }
                break;
            case ENC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 760; // move to left
                        break;
                    case MDPI:
                        finalDp -= 520; //move to left
                        break;
                    case HDPI:
                        finalDp -= 280; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 125; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 5; // move to left
                        break;
                    case XXXHDPI:
                        finalDp += 65; // move to right
                        break;
                }
                break;
            case ESC:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 790; // move to left
                        break;
                    case MDPI:
                        finalDp -= 540; //move to left
                        break;
                    case HDPI:
                        finalDp -= 295; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 130; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 5; // move to left
                        break;
                    case XXXHDPI:
                        finalDp += 55; // move to right
                        break;
                }
                break;
            case MA:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 955; // move to left
                        break;
                    case MDPI:
                        finalDp -= 660; //move to left
                        break;
                    case HDPI:
                        finalDp -= 355; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 160; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 25; // move to left
                        break;
                    case XXXHDPI:
                        finalDp += 50; // move to right
                        break;
                }
                break;
            case SA:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 850; // move to left
                        break;
                    case MDPI:
                        finalDp -= 580; //move to left
                        break;
                    case HDPI:
                        finalDp -= 300; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 110; // move to left
                        break;
                    case XXHDPI:
                        finalDp += 25; // move to right
                        break;
                    case XXXHDPI:
                        finalDp += 100; // move to right
                        break;
                }
                break;
            case NE:
                switch (dpi) {
                    default:
                    case LDPI:
                        finalDp -= 980; // move to left
                        break;
                    case MDPI:
                        finalDp -= 665; //move to left
                        break;
                    case HDPI:
                        finalDp -= 350; // move to left
                        break;
                    case XHDPI:
                        finalDp -= 160; // move to left
                        break;
                    case XXHDPI:
                        finalDp -= 25; // move to Left
                        break;
                    case XXXHDPI:
                        finalDp += 70; // move to right
                        break;
                }
        }
        return Utils.dpToPx(context, finalDp);
    }
}
