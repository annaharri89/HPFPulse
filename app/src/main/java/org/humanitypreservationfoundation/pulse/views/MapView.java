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
import org.humanitypreservationfoundation.pulse.TimeZone;
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
    static Map<TimeZoneEnum, List<String>> timeZoneTitlesAndStates = new HashMap<TimeZoneEnum, List<String>>();
    private List<TimeZone> timeZones = new ArrayList<TimeZone>();
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
        for (Map.Entry<TimeZoneEnum, List<String>> entry : MapView.timeZoneTitlesAndStates.entrySet()) {
            TimeZone tz;
            switch (entry.getKey()) {
                default:
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
    }

    /**
     * For each time zone, adds the time zone code as the key and adds a list of time zone state
     * codes as the value to MapView.timeZoneTitlesAndStates.
     */
    private void setupTimeZoneTitlesAndStates() {
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.PST, Arrays.asList(getResources().getStringArray(R.array.PST_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.MT, Arrays.asList(getResources().getStringArray(R.array.MT_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.WNC, Arrays.asList(getResources().getStringArray(R.array.WNC_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.WSC, Arrays.asList(getResources().getStringArray(R.array.WSC_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.ENC, Arrays.asList(getResources().getStringArray(R.array.ENC_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.ESC, Arrays.asList(getResources().getStringArray(R.array.ESC_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.MA, Arrays.asList(getResources().getStringArray(R.array.MA_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.SA, Arrays.asList(getResources().getStringArray(R.array.SA_state_codes)));
        MapView.timeZoneTitlesAndStates.put(TimeZoneEnum.NE, Arrays.asList(getResources().getStringArray(R.array.NE_state_codes)));
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
     * @param timeZoneEnum
     */
    private void setHighlightedTimeZone(TimeZoneEnum timeZoneEnum) {

        TimeZone timeZone = this.getTimeZone(timeZoneEnum);
        if (timeZoneEnum.equals(TimeZoneEnum.ALL)) {
            for (TimeZone tz: this.timeZones) {
                this.changeTimeZoneFillColor(tz, "highlight");
            }
        } else {
            this.changeTimeZoneFillColor(timeZone, "highlight");
        }
    }

    /**
     * Unhighlight regions
     */
    private void resetHighlightedTimeZone() {
        if (this.highlightedTimeZone.equals(TimeZoneEnum.ALL)) {
            for (TimeZone tz: this.timeZones) {
                this.changeTimeZoneFillColor(tz, tz.getColorCode());
            }
        } else {
            this.changeTimeZoneFillColor(this.getTimeZone(this.highlightedTimeZone), this.getTimeZone(this.highlightedTimeZone).getColorCode());
        }
    }

    private TimeZone getTimeZone(TimeZoneEnum timeZoneCode) {
        for (TimeZone timeZone: this.timeZones) {
            if (timeZone.getEnum().equals(timeZoneCode)) {
                return timeZone;
            }
        }
        return null;
    }

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

    private void drawUSMap(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        this.USMap.setBounds(0, 0, width, height);
        this.USMap.draw(canvas);
    }

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