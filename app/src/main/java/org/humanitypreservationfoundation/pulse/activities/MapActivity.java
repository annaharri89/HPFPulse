package org.humanitypreservationfoundation.pulse.activities;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.classes.TimeZone;
import org.humanitypreservationfoundation.pulse.views.MapView;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

public class MapActivity extends AppCompatActivity {

    private String mActivityName;
    private MapView mMap;
    private TextView mDescriptionTextView;
    private TimeZoneEnum mTZE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ActionBar ab = getSupportActionBar();
        Intent intent = getIntent();
        mActivityName = intent.getStringExtra(Config.intents.ACTIVITY_EXTRA);
        try {
            ab.setTitle(mActivityName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        mMap = (MapView) findViewById(R.id.map_view);
        mDescriptionTextView = (TextView) findViewById(R.id.region_description);
        final Button getResults = (Button) findViewById(R.id.get_results);
        getResults.setEnabled(false);

        SpinnerAdapter adapter = new ArrayAdapter<String>(this, R.layout.region_spinner_item, getResources().getStringArray(R.array.timezones)) {
            @Override
            public boolean isEnabled(int position) {
                return position != 0; //disable "Select a region" position
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView spinnerItem = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    spinnerItem.setTextColor(Color.LTGRAY);
                }
                return view;
            }
        };
        Spinner regionSpinner = (Spinner) findViewById(R.id.region_spinner);
        regionSpinner.setAdapter(adapter);
        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ALL.toStringName())) {
                    mTZE = TimeZoneEnum.ALL;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.PST.toStringName())) {
                    mTZE = TimeZoneEnum.PST;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MT.toStringName())) {
                    mTZE = TimeZoneEnum.MT;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WNC.toStringName())) {
                    mTZE = TimeZoneEnum.WNC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WSC.toStringName())) {
                    mTZE = TimeZoneEnum.WSC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ENC.toStringName())) {
                    mTZE = TimeZoneEnum.ENC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ESC.toStringName())) {
                    mTZE = TimeZoneEnum.ESC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MA.toStringName())) {
                    mTZE = TimeZoneEnum.MA;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.SA.toStringName())) {
                    mTZE = TimeZoneEnum.SA;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.NE.toStringName())) {
                    mTZE = TimeZoneEnum.NE;
                } else {
                    return;
                }

                if (!getResults.isEnabled()) {
                    getResults.setEnabled(true);
                }
                mMap.changeHighlightedTimeZone(mTZE);
                setDescriptionText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 2404) {
            if(data != null) {
                mActivityName = data.getStringExtra(Config.intents.ACTIVITY_EXTRA);
            }
        }
    }

    public void setDescriptionText() {
        String lcmActivityName = mActivityName.toLowerCase();
        TimeZone tz = mMap.getTimeZone(mTZE);
        String description = String.format(tz.getDescription(), lcmActivityName);

        mDescriptionTextView.setText(description);
    }

    public void getResults(View view) {
        Intent intent = new Intent();
        if (!mActivityName.equals(Config.categories.ALL_RESOURCES)) {
            intent.setClass(this, CategoryResourcesActivity.class);
        } else {
            /*
        if (mTZE.equals(TimeZoneEnum.ALL)) {
            intent = new Intent(this, ALLAllResourcesActivity.class);
        } else if (mTZE.equals(TimeZoneEnum.PST)) {
            intent = new Intent(this, PSTAllResourcesActivity.class);
        }
        */
        }


        intent.putExtra(Config.intents.ACTIVITY_EXTRA, mActivityName);
        intent.putExtra(Config.intents.TIMEZONE_EXTRA, mMap.getTimeZone(mTZE));
        startActivityForResult(intent, 2404);
    }
}
