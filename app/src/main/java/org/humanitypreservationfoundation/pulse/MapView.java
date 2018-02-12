package org.humanitypreservationfoundation.pulse;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ETASpare on 1/18/2018.
 */

class MapView extends View {
    static Map<String, List<String>> timeZoneTitlesAndStates = new HashMap<String, List<String>>();
    List<TimeZone> timeZones = new ArrayList<TimeZone>();
    Context context;
    VectorMasterDrawable USMap;
    Paint paintBlack = new Paint();
    Paint paintWhite = new Paint();

    /**
     *MapView Constructor
     */
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.setupTimeZoneTitlesAndStates();
        this.USMap = new VectorMasterDrawable(this.context.getApplicationContext(), R.drawable.ic_us_map_vector);
        for (Map.Entry<String, List<String>> entry : MapView.timeZoneTitlesAndStates.entrySet()) {
            TimeZone tz = new TimeZone(this.context, entry.getKey(), entry.getValue(), USMap);
            this.timeZones.add(tz);
        }
    }

    /**
     * For each time zone, adds the time zone code as the key and adds a list of time zone state
     * codes as the value to MapView.timeZoneTitlesAndStates.
     */
    private void setupTimeZoneTitlesAndStates() {
        MapView.timeZoneTitlesAndStates.put("PST", Arrays.asList(getResources().getStringArray(R.array.PST_state_codes)));
        MapView.timeZoneTitlesAndStates.put("MT", Arrays.asList(getResources().getStringArray(R.array.MT_state_codes)));
        MapView.timeZoneTitlesAndStates.put("WNC", Arrays.asList(getResources().getStringArray(R.array.WNC_state_codes)));
        MapView.timeZoneTitlesAndStates.put("WSC", Arrays.asList(getResources().getStringArray(R.array.WSC_state_codes)));
        MapView.timeZoneTitlesAndStates.put("ENC", Arrays.asList(getResources().getStringArray(R.array.ENC_state_codes)));
        MapView.timeZoneTitlesAndStates.put("ESC", Arrays.asList(getResources().getStringArray(R.array.ESC_state_codes)));
        MapView.timeZoneTitlesAndStates.put("MA", Arrays.asList(getResources().getStringArray(R.array.MA_state_codes)));
        MapView.timeZoneTitlesAndStates.put("SA", Arrays.asList(getResources().getStringArray(R.array.SA_state_codes)));
        MapView.timeZoneTitlesAndStates.put("NE", Arrays.asList(getResources().getStringArray(R.array.NE_state_codes)));
    }

    public void changeFillColor(String qualifier) {
        for (TimeZone timeZone : this.timeZones) {
            timeZone.changeFillColor(qualifier);
        }
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
        this.paintBlack.setColor(Color.BLACK);
        this.paintBlack.setTextSize(40);
        this.paintBlack.setStyle(Paint.Style.STROKE);
        this.paintBlack.setStrokeWidth(8);

        this.paintWhite.setColor(Color.WHITE);
        this.paintWhite.setTextSize(40); //TODO figure out how to have multiple text sizes and top left ints for multiple screen sizes

        // Code to draw time zone names as text on map
        for (TimeZone timeZone : this.timeZones) {
            //TODO create switch case: cases being timezone names which set top and left ints so that each label is placed appropriately
            int top = (timeZone.getRegion().getBounds().top + timeZone.getRegion().getBounds().bottom) / 2 + 50; //todo implement calculateTop
            int left = (timeZone.getRegion().getBounds().left + timeZone.getRegion().getBounds().right) / 2 - 50; //todo implement calculateLeft
            for (String line: timeZone.getName().split(" ")) {// makes words appear underneath each other
                canvas.drawText(line, left, top, paintBlack);
                canvas.drawText(line, left, top, paintWhite);
                top += this.paintWhite.descent() - this.paintWhite.ascent();
            }
        }
        //(int) Math.floor(height*0.589) TODO remove
    }

    private int calculateTop(TimeZone timeZone){
        switch (timeZone.getCode()) {
            case "PST":
                return (timeZone.getRegion().getBounds().top + timeZone.getRegion().getBounds().bottom) / 2 + 50;
                //TODO finish implementing switch case
        }
        return 0;
    }

    private int calculateLeft(TimeZone timeZone){
        switch (timeZone.getCode()) {
            case "PST":
                return (timeZone.getRegion().getBounds().left + timeZone.getRegion().getBounds().right) / 2 - 50;
                //TODO finish implementing switch case
        }
        return 0;
    }
}