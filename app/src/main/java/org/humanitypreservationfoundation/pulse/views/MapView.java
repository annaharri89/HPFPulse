package org.humanitypreservationfoundation.pulse.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.classes.MapViewController;
import org.humanitypreservationfoundation.pulse.classes.RequestQueueSingleton;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.State;
import org.humanitypreservationfoundation.pulse.classes.TimeZone;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by ETASpare on 1/18/2018.
 */

public class MapView extends View {
    private static Map<TimeZoneEnum, List<StateEnum>> mTimeZoneTitlesAndStates = new HashMap<>();
    private Map<String, TimeZone> mTimeZones = new HashMap<>();
    private TimeZoneEnum mHighlightedTimeZone;
    private Context mContext;
    private VectorMasterDrawable mUSMap;
    private Paint mPaintGrey = new Paint();
    private Paint mPaintWhite = new Paint();
    private MapViewController mController;

    /**
     *MapView Constructor
     */
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mController = new MapViewController(this.mContext);
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
            this.mTimeZones.put(tz.getEnum().toStringCode(), tz);
        }
        this.volleyCacheRequest();
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

    public void volleyCacheRequest(){
        String url = Config.data.URL;

        Cache cache = RequestQueueSingleton.getInstance(this.mContext.getApplicationContext()).getRequestQueue().getCache();
        Cache.Entry reqEntry = cache.get(url);
        if(reqEntry != null){
            try {
                String data = new String(reqEntry.data, "UTF-8");
                volleyParseResponse(new JSONArray(data));
            } catch (UnsupportedEncodingException | JSONException e) {
                e.printStackTrace();
            }
        }
        else{
            this.volleyJsonArrayRequest(url);
        }
    }

    public void volleyJsonArrayRequest(String url){

        JsonArrayRequest jsonArrayReq = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        volleyParseResponse(response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error

            }
        }) {
            @Override
            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                try {
                    Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
                    if (cacheEntry == null) {
                        cacheEntry = new Cache.Entry();
                    }
                    final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
                    final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
                    long now = System.currentTimeMillis();
                    final long softExpire = now + cacheHitButRefreshed;
                    final long ttl = now + cacheExpired;
                    cacheEntry.data = response.data;
                    cacheEntry.softTtl = softExpire;
                    cacheEntry.ttl = ttl;
                    String headerValue;
                    headerValue = response.headers.get("Date");
                    if (headerValue != null) {
                        cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
                    }
                    headerValue = response.headers.get("Last-Modified");
                    if (headerValue != null) {
                        cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
                    }
                    cacheEntry.responseHeaders = response.headers;
                    final String jsonString = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers));
                    return Response.success(new JSONArray(jsonString), cacheEntry);
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    return Response.error(new ParseError(e));
                }
            }

            @Override
            protected void deliverResponse(JSONArray response) {
                super.deliverResponse(response);
            }

            @Override
            public void deliverError(VolleyError error) {
                super.deliverError(error);
            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                return super.parseNetworkError(volleyError);
            }
        };
        // Adding JsonObject request to request queue
        RequestQueueSingleton.getInstance(this.mContext.getApplicationContext()).addToRequestQueue(jsonArrayReq);
    }

    public void volleyParseResponse(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject timeZoneObject = response.getJSONObject(i);
                String timeZoneObjectCode = timeZoneObject.getString("code");
                JSONArray statesArray = timeZoneObject.getJSONArray("states").getJSONArray(0);

                Map<StateEnum, List<Resource>> resourceMap = new HashMap<>(); // object used to set resources

                for (int j = 0; j < statesArray.length(); j++) {
                    JSONObject stateObject = statesArray.getJSONObject(j);
                    String stateObjectCode = stateObject.getString("code");

                    State st = mTimeZones.get(timeZoneObjectCode).getState(stateObjectCode);
                    StateEnum stEnum = st.getEnum();
                    List<Resource> resources = new ArrayList<>();

                    JSONArray childAbuseResources = stateObject.getJSONArray("childAbuseResources").getJSONArray(0);
                    JSONArray bullyingResources = stateObject.getJSONArray("bullyingResources").getJSONArray(0);
                    JSONArray domesticViolenceResources = stateObject.getJSONArray("domesticViolenceResources").getJSONArray(0);

                    resources.addAll(volleyParseResources(childAbuseResources, stEnum, Config.categories.CHILD_ABUSE));
                    resources.addAll(volleyParseResources(bullyingResources, stEnum, Config.categories.BULLYING));
                    resources.addAll(volleyParseResources(domesticViolenceResources, stEnum, Config.categories.DOMESTIC_VIOLENCE));

                    resourceMap.put(stEnum, resources);
                }
                mTimeZones.get(timeZoneObjectCode).setResources(resourceMap);
                mTimeZones.get("ALL").setResources(resourceMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Resource> volleyParseResources(JSONArray resourcesArray, StateEnum stEnum, String category) {
        List<Resource> resources = new ArrayList<>();
        for (int i = 0; i < resourcesArray.length(); i++){
            try {
                int id = resourcesArray.getJSONObject(i).getInt("id");
                String orgName = resourcesArray.getJSONObject(i).getString("orgName");
                String orgUrl = resourcesArray.getJSONObject(i).getString("orgUrl");
                String orgPhone = resourcesArray.getJSONObject(i).getString("orgPhone");

                Resource resource = new Resource(category, id, orgName, orgPhone, stEnum, orgUrl);
                resources.add(resource);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return resources;
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
            for (Map.Entry<String, TimeZone> entry : this.mTimeZones.entrySet()) {
                TimeZone tz = entry.getValue();
                if (!tz.getEnum().equals(TimeZoneEnum.ALL)) { // needed to fix leak causing a couple of the timezones to highlight to the ALL timezone color
                    this.changeTimeZoneFillColor(tz, tz.getColorCode());
                }
            }
        } else {
            this.changeTimeZoneFillColor(this.getTimeZone(this.mHighlightedTimeZone), this.getTimeZone(this.mHighlightedTimeZone).getColorCode());
        }
    }

    public TimeZone getTimeZone(TimeZoneEnum timeZoneEnum) {
        for (Map.Entry<String, TimeZone> entry : this.mTimeZones.entrySet()) {
            TimeZone timeZone = entry.getValue();
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
        //this.drawTimeZoneLabels(canvas); todo remove

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
        int textSize = this.mController.getTimeZoneLabelTextSize();
        int strokeWidth = this.mController.getTimeZoneLabelStrokeSize();
        //TODO: find more attractive font for timezone names
        this.mPaintGrey.setColor(Color.DKGRAY);
        this.mPaintGrey.setTextSize(textSize);
        this.mPaintGrey.setStyle(Paint.Style.STROKE);
        this.mPaintGrey.setStrokeWidth(strokeWidth);

        this.mPaintWhite.setColor(Color.WHITE);
        this.mPaintWhite.setTextSize(textSize);

        // Code to draw time zone names as text on map
        for (Map.Entry<String, TimeZone> entry : this.mTimeZones.entrySet()) {
            TimeZone timeZone = entry.getValue();
            if (!timeZone.getEnum().equals(TimeZoneEnum.ALL)) {
                float top = this.mController.calculateTop(timeZone);
                float left = this.mController.calculateLeft(timeZone);
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