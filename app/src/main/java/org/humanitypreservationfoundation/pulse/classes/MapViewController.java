package org.humanitypreservationfoundation.pulse.classes;

import android.content.Context;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.utils.Utils;

/**
 * Created by ETASpare on 3/14/2018.
 */

public class MapViewController {

    private Context mContext;

    public MapViewController(Context context) {
        this.mContext = context;
    }

    public int getTimeZoneLabelTextSize() {
        return this.mContext.getResources().getInteger(R.integer.label_text_size);
    }

    public int getTimeZoneLabelStrokeSize() {
        return this.mContext.getResources().getInteger(R.integer.label_stroke_size);
    }

    /**
     * Calculates the y position to draw the time zone labels.
     */

    public float calculateTop(TimeZone timeZone){
        /*
        float topDp = Utils.pxToDp(this.mContext, timeZone.getRegion().getBounds().top);
        float bottomDp = Utils.pxToDp(this.mContext, timeZone.getRegion().getBounds().bottom);
        float finalDp = (topDp + bottomDp) / 2; //this is the average dp

        switch (timeZone.getEnum()) {
            default:
            case PST:
                finalDp += this.mContext.getResources().getInteger(R.integer.PST_top);
                break;
            case MT:
                finalDp += this.mContext.getResources().getInteger(R.integer.MT_top);
                break;
            case WNC:
                finalDp += this.mContext.getResources().getInteger(R.integer.WNC_top);
                break;
            case WSC:
                finalDp += this.mContext.getResources().getInteger(R.integer.WSC_top);
                break;
            case ENC:
                finalDp += this.mContext.getResources().getInteger(R.integer.ENC_top);
                break;
            case ESC:
                finalDp += this.mContext.getResources().getInteger(R.integer.ESC_top);
                break;
            case MA:
                finalDp += this.mContext.getResources().getInteger(R.integer.MA_top);
                break;
            case SA:
                finalDp += this.mContext.getResources().getInteger(R.integer.SA_top);
                break;
            case NE:
                finalDp += this.mContext.getResources().getInteger(R.integer.NE_top);
                break;
        }
        return Utils.dpToPx(this.mContext, finalDp);
        */
        return 0;
    }

    /**
     * Calculates the x position to draw the time zone labels.
     */
    public float calculateLeft(TimeZone timeZone){
        /*
        float leftDp = Utils.pxToDp(this.mContext, timeZone.getRegion().getBounds().left);
        float rightDp = Utils.pxToDp(this.mContext, timeZone.getRegion().getBounds().right);
        float finalDp = (leftDp + rightDp) / 2; //this is the average dp
        switch (timeZone.getEnum()) {
            default:
            case PST:
                finalDp += this.mContext.getResources().getInteger(R.integer.PST_left);
                break;
            case MT:
                finalDp += this.mContext.getResources().getInteger(R.integer.MT_left);
                break;
            case WNC:
                finalDp += this.mContext.getResources().getInteger(R.integer.WNC_left);
                break;
            case WSC:
                finalDp += this.mContext.getResources().getInteger(R.integer.WSC_left);
                break;
            case ENC:
                finalDp += this.mContext.getResources().getInteger(R.integer.ENC_left);
                break;
            case ESC:
                finalDp += this.mContext.getResources().getInteger(R.integer.ESC_left);
                break;
            case MA:
                finalDp += this.mContext.getResources().getInteger(R.integer.MA_left);
                break;
            case SA:
                finalDp += this.mContext.getResources().getInteger(R.integer.SA_left);
                break;
            case NE:
                finalDp += this.mContext.getResources().getInteger(R.integer.NE_left);
        }
        return Utils.dpToPx(this.mContext, finalDp);
        */
        return 0;
    }
}
