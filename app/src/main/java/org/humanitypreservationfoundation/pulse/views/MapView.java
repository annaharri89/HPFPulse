package org.humanitypreservationfoundation.pulse.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.classes.DummyData;
import org.humanitypreservationfoundation.pulse.classes.MapViewController;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.State;
import org.humanitypreservationfoundation.pulse.classes.TimeZone;
import org.humanitypreservationfoundation.pulse.enums.DensitiesEnum;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.humanitypreservationfoundation.pulse.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ETASpare on 1/18/2018.
 */

public class MapView extends View {
    static Map<TimeZoneEnum, List<StateEnum>> mTimeZoneTitlesAndStates = new HashMap<TimeZoneEnum, List<StateEnum>>();
    private List<TimeZone> mTimeZones = new ArrayList<TimeZone>(); // todo turn into hashmap with timezoneEnum as key, timezone as value
    private TimeZoneEnum mHighlightedTimeZone;
    private Context mContext;
    private VectorMasterDrawable mUSMap;
    private Paint mPaintGrey = new Paint();
    private Paint mPaintWhite = new Paint();
    private DensitiesEnum mDPI;

    private int mTextSize;
    private int mStrokeWidth;

    /**
     *MapView Constructor
     */
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mDPI = Utils.getScreenDensity(this.mContext);
        this.setupTimeZoneTitlesAndStates();
        this.mUSMap = new VectorMasterDrawable(this.mContext.getApplicationContext(), R.drawable.ic_us_map_vector);
        for (Map.Entry<TimeZoneEnum, List<StateEnum>> entry : MapView.mTimeZoneTitlesAndStates.entrySet()) {
            TimeZone tz;
            switch (entry.getKey()) {
                default:
                case ALL:
                    tz = new TimeZone(this.mContext, "0", entry.getKey(), entry.getValue(), mUSMap);
                    break;
                case PST:
                    tz = new TimeZone(this.mContext, "1", entry.getKey(), entry.getValue(), mUSMap);
                    break;
                case MT:
                case ENC:
                    tz = new TimeZone(this.mContext, "2", entry.getKey(), entry.getValue(), mUSMap);
                    break;
                case WSC:
                case MA:
                    tz = new TimeZone(this.mContext, "3", entry.getKey(), entry.getValue(), mUSMap);
                    break;
                case ESC:
                case NE:
                    tz = new TimeZone(this.mContext, "4", entry.getKey(), entry.getValue(), mUSMap);
                    break;
                case SA:
                case WNC:
                    tz = new TimeZone(this.mContext, "5", entry.getKey(), entry.getValue(), mUSMap);
                    break;
            }
            this.mTimeZones.add(tz);
        }
        this.setDummyResources(); //todo remove once db is fully set up and hooked up to real data
    }

    /**
     * For each time zone, adds the time zone code as the key and adds a list of time zone state
     * codes as the value to MapView.mTimeZoneTitlesAndStates.
     */
    private void setupTimeZoneTitlesAndStates() {
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.PST, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.PST));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.MT, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.MT));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.WNC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.WNC));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.WSC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.WSC));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.ENC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.ENC));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.ESC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.ESC));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.MA, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.MA));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.SA, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.SA));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.NE, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.NE));
        MapView.mTimeZoneTitlesAndStates.put(TimeZoneEnum.ALL, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.ALL)); //TODO Is ALL timezone needed? doesn't it double the amount of data?
    }

    //todo set real data using AsyncTask in class named ResourceLoader -->see youKNOWwhat for  --> call resourceLoader asynctask from MapView
    //todo remove once db is fully set up and hooked up to real data
    private void setDummyResources() {
        Map<StateEnum, List<Resource>> resourceMap = new HashMap<StateEnum, List<Resource>>();
        for (TimeZone tz : this.mTimeZones) {
            if (tz.getEnum().equals(TimeZoneEnum.PST)) {
                for (State state : tz.getStates()) {
                    StateEnum stateEnum = state.getEnum();
                    List<Resource> resourceList = DummyData.getResources(stateEnum);
                    resourceMap.put(stateEnum, resourceList);
                }
            }
            tz.setDummyResources(resourceMap);
        }
    }

    /**
     * Uses the passed in <code>timeZoneCode</code> to get the appropriate time zone, timeZone,
     * from this.timezones. Changes timeZone's fill color to the highlight color. If a timeZone has
     * already been highlighted, changes that time zone's color back to it's original color.
     * Finally, sets this.highlightedTimeZone to timeZone to keep track of which state is currently
     * highlighted
     * @param timeZoneEnum instance of TimeZoneEnum
     */
    public void changeHighlightedTimeZone(TimeZoneEnum timeZoneEnum) {

        if (this.mHighlightedTimeZone != null) {
            resetHighlightedTimeZone();
        }
        setHighlightedTimeZone(timeZoneEnum);

        this.mHighlightedTimeZone = timeZoneEnum;
    }

    /**
     * Highlight regions
     */
    private void setHighlightedTimeZone(TimeZoneEnum timeZoneEnum) {
        TimeZone timeZone = this.getTimeZone(timeZoneEnum);
        this.changeTimeZoneFillColor(timeZone, "highlight");
    }

    /**
     * Unhighlight regions
     */
    private void resetHighlightedTimeZone() {
        if (this.mHighlightedTimeZone.equals(TimeZoneEnum.ALL)) { //needed so that each time zone gets their original color
            for (TimeZone tz: this.mTimeZones) {
                if (!tz.getEnum().equals(TimeZoneEnum.ALL)) { // needed to fix leak causing a couple of the timezones to highlight to the ALL timezone color
                    this.changeTimeZoneFillColor(tz, tz.getColorCode());
                }
            }
        } else {
            this.changeTimeZoneFillColor(this.getTimeZone(this.mHighlightedTimeZone), this.getTimeZone(this.mHighlightedTimeZone).getColorCode());
        }
    }

    public TimeZone getTimeZone(TimeZoneEnum timeZoneEnum) {
        for (TimeZone timeZone: this.mTimeZones) {
            if (timeZone.getEnum().equals(timeZoneEnum)) {
                return timeZone;
            }
        }
        return null;
    }

    /**
     * Changes the timezones fill color and calls <code>invalidate()</code> to redraw the map.
     * @param qualifier string used to get appropriate color resource
     *                  options: "highlight", "1", "2", "3", "4", "5"
     */
    private void changeTimeZoneFillColor(TimeZone timeZone, String qualifier) {
        timeZone.changeFillColor(qualifier);
        invalidate(); //TODO is this the appropriate place to call this
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*
        for (TimeZone timezone : this.timeZones) {
            if (timezone.checkStatesForTap((int) event.getX(), (int) event.getY())) {
                performClick();
                invalidate();
                return true;
           }
        }
        */
        //TODO: remove when confirmed unnecessary
        invalidate();
        return true;
    }

    @Override
    public boolean performClick() {
        //TODO: remove when confirmed unnecessary
        super.performClick();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Code to draw map on canvas
        super.onDraw(canvas);
        this.drawUSMap(canvas);
        this.drawTimeZoneLabels(canvas);

    }

    /**
     * Draws the svg map of United States
     */
    private void drawUSMap(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        this.mUSMap.setBounds(0, 0, width, height);
        this.mUSMap.draw(canvas);
    }



    /**
     * Draws time zone labels
     */
    private void drawTimeZoneLabels(Canvas canvas) {
        this.mTextSize = MapViewController.getTimeZoneLabelTextSize(this.mDPI);
        this.mStrokeWidth = MapViewController.getTimeZoneLabelTextStroke(this.mDPI);
        //TODO: find more attractive font for timezone names
        this.mPaintGrey.setColor(Color.DKGRAY);
        this.mPaintGrey.setTextSize(this.mTextSize);
        this.mPaintGrey.setStyle(Paint.Style.STROKE);
        this.mPaintGrey.setStrokeWidth(this.mStrokeWidth);

        this.mPaintWhite.setColor(Color.WHITE);
        this.mPaintWhite.setTextSize(this.mTextSize);

        // Code to draw time zone names as text on map
        for (TimeZone timeZone : this.mTimeZones) {
            if (!timeZone.getEnum().equals(TimeZoneEnum.ALL)) {
                float top = MapViewController.calculateTop(this.mContext, this.mDPI, timeZone);
                float left = MapViewController.calculateLeft(this.mContext, this.mDPI, timeZone);
                for (String line: timeZone.getName().split(" ")) {// makes words appear underneath each other
                    canvas.drawText(line, left, top, mPaintGrey);
                    canvas.drawText(line, left, top, mPaintWhite);
                    top += this.mPaintWhite.descent() - this.mPaintWhite.ascent();
                }
            }
        }
        //(int) Math.floor(height*0.589) TODO remove
    }


}