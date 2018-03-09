package org.humanitypreservationfoundation.pulse.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.classes.DummyData;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.State;
import org.humanitypreservationfoundation.pulse.classes.TimeZone;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ETASpare on 1/18/2018.
 */

public class MapView extends View {
    static Map<TimeZoneEnum, List<StateEnum>> timeZoneTitlesAndStates = new HashMap<TimeZoneEnum, List<StateEnum>>();
    private List<TimeZone> timeZones = new ArrayList<TimeZone>(); // todo turn into hashmap with timezoneEnum as key, timezone as value
    private TimeZoneEnum highlightedTimeZone;
    private Context context;
    private VectorMasterDrawable USMap;
    private Paint paintGrey = new Paint();
    private Paint paintWhite = new Paint();

    /**
     *MapView Constructor
     */
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.setupTimeZoneTitlesAndStates();
        this.USMap = new VectorMasterDrawable(this.context.getApplicationContext(), R.drawable.ic_us_map_vector);
        for (Map.Entry<TimeZoneEnum, List<StateEnum>> entry : MapView.timeZoneTitlesAndStates.entrySet()) {
            TimeZone tz;
            switch (entry.getKey()) {
                default:
                case ALL:
                    tz = new TimeZone(this.context, "0", entry.getKey(), entry.getValue(), USMap);
                    break;
                case PST:
                    tz = new TimeZone(this.context, "1", entry.getKey(), entry.getValue(), USMap);
                    break;
                case MT:
                case ENC:
                    tz = new TimeZone(this.context, "2", entry.getKey(), entry.getValue(), USMap);
                    break;
                case WSC:
                case MA:
                    tz = new TimeZone(this.context, "3", entry.getKey(), entry.getValue(), USMap);
                    break;
                case ESC:
                case NE:
                    tz = new TimeZone(this.context, "4", entry.getKey(), entry.getValue(), USMap);
                    break;
                case SA:
                case WNC:
                    tz = new TimeZone(this.context, "5", entry.getKey(), entry.getValue(), USMap);
                    break;
            }
            this.timeZones.add(tz);
        }
        this.setDummyResources(); //todo remove once db is fully set up and hooked up to real data
    }

    /**
     * For each time zone, adds the time zone code as the key and adds a list of time zone state
     * codes as the value to MapView.timeZoneTitlesAndStates.
     */
    private void setupTimeZoneTitlesAndStates() {
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.PST, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.PST));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.MT, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.MT));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.WNC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.WNC));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.WSC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.WSC));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.ENC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.ENC));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.ESC, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.ESC));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.MA, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.MA));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.SA, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.SA));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.NE, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.NE));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.ALL, StateEnum.getTimeZoneStateCodes(TimeZoneEnum.ALL)); //TODO Is ALL timezone needed? doesn't it double the amount of data?
    }

    //todo set real data using AsyncTask in class named ResourceLoader -->see youKNOWwhat for  --> call resourceLoader asynctask from MapView
    //todo remove once db is fully set up and hooked up to real data
    private void setDummyResources() {
        Map<StateEnum, List<Resource>> resourceMap = new HashMap<StateEnum, List<Resource>>();
        for (TimeZone tz : this.timeZones) {
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

        if (this.highlightedTimeZone != null) {
            resetHighlightedTimeZone();
        }
        setHighlightedTimeZone(timeZoneEnum);

        this.highlightedTimeZone = timeZoneEnum;
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
        if (this.highlightedTimeZone.equals(TimeZoneEnum.ALL)) { //needed so that each time zone gets their original color
            for (TimeZone tz: this.timeZones) {
                if (!tz.getEnum().equals(TimeZoneEnum.ALL)) { // needed to fix leak causing a couple of the timezones to highlight to the ALL timezone color
                    this.changeTimeZoneFillColor(tz, tz.getColorCode());
                }
            }
        } else {
            this.changeTimeZoneFillColor(this.getTimeZone(this.highlightedTimeZone), this.getTimeZone(this.highlightedTimeZone).getColorCode());
        }
    }

    public TimeZone getTimeZone(TimeZoneEnum timeZoneEnum) {
        for (TimeZone timeZone: this.timeZones) {
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
        this.USMap.setBounds(0, 0, width, height);
        this.USMap.draw(canvas);
    }

    /**
     * Draws time zone labels
     */
    private void drawTimeZoneLabels(Canvas canvas) {
        //TODO: find more attractive font for timezone names
        this.paintGrey.setColor(Color.DKGRAY);
        this.paintGrey.setTextSize(40);
        this.paintGrey.setStyle(Paint.Style.STROKE);
        this.paintGrey.setStrokeWidth(8);

        this.paintWhite.setColor(Color.WHITE);
        this.paintWhite.setTextSize(40); //TODO figure out how to have multiple text sizes and top / left ints for multiple screen sizes

        // Code to draw time zone names as text on map
        for (TimeZone timeZone : this.timeZones) {
            int top = calculateTop(timeZone);
            int left = calculateLeft(timeZone);
            for (String line: timeZone.getName().split(" ")) {// makes words appear underneath each other
                canvas.drawText(line, left, top, paintGrey);
                canvas.drawText(line, left, top, paintWhite);
                top += this.paintWhite.descent() - this.paintWhite.ascent();
            }
        }
        //(int) Math.floor(height*0.589) TODO remove
    }

    /**
     * Calculates the y position to draw the time zone labels.
     */
    private int calculateTop(TimeZone timeZone){ //todo get working for multiple screen sizes
        switch (timeZone.getEnum()) {
            default:
            case PST:
            case MT:
            case WNC:
            case WSC:
            case MA:
            case ENC:
            case SA:
                return (timeZone.getRegion().getBounds().top + timeZone.getRegion().getBounds().bottom) / 2 + 50; // move down
            case ESC:
                return (timeZone.getRegion().getBounds().top + timeZone.getRegion().getBounds().bottom) / 2 + 70; // move down
            case NE:
                return (timeZone.getRegion().getBounds().top + timeZone.getRegion().getBounds().bottom) / 2 + 10; // move down
        }
    }

    /**
     * Calculates the x position to draw the time zone labels.
     */
    private int calculateLeft(TimeZone timeZone){ //todo get working for multiple screen sizes
        switch (timeZone.getEnum()) {
            default:
            case PST:
            case MT:
            case WNC:
            case WSC:
            case MA:
            case ESC:
            case NE:
                return (timeZone.getRegion().getBounds().left + timeZone.getRegion().getBounds().right) / 2 - 50; //move to left
            case SA:
                return (timeZone.getRegion().getBounds().left + timeZone.getRegion().getBounds().right) / 2 + 75; // move to right
            case ENC:
                return (timeZone.getRegion().getBounds().left + timeZone.getRegion().getBounds().right) / 2 - 20; // move to left
        }
    }
}