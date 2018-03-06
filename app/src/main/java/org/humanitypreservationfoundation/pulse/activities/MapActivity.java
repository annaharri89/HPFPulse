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
import org.humanitypreservationfoundation.pulse.TimeZone;
import org.humanitypreservationfoundation.pulse.views.MapView;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

public class MapActivity extends AppCompatActivity {

    private String activityName;
    private MapView map;
    private TextView descriptionTextView;
    private TimeZoneEnum tze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ActionBar ab = getSupportActionBar();
        Intent intent = getIntent();
        activityName = intent.getStringExtra(Config.intents.ACTIVITY_EXTRA);
        try {
            ab.setTitle(activityName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        map = (MapView) findViewById(R.id.map_view);
        descriptionTextView = (TextView) findViewById(R.id.region_description);
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
                    tze = TimeZoneEnum.ALL;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.PST.toStringName())) {
                    tze = TimeZoneEnum.PST;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MT.toStringName())) {
                    tze = TimeZoneEnum.MT;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WNC.toStringName())) {
                    tze = TimeZoneEnum.WNC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WSC.toStringName())) {
                    tze = TimeZoneEnum.WSC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ENC.toStringName())) {
                    tze = TimeZoneEnum.ENC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ESC.toStringName())) {
                    tze = TimeZoneEnum.ESC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MA.toStringName())) {
                    tze = TimeZoneEnum.MA;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.SA.toStringName())) {
                    tze = TimeZoneEnum.SA;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.NE.toStringName())) {
                    tze = TimeZoneEnum.NE;
                } else {
                    return;
                }

                if (!getResults.isEnabled()) {
                    getResults.setEnabled(true);
                }
                map.changeHighlightedTimeZone(tze);
                setDescriptionText(tze);
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
                this.activityName = data.getStringExtra(Config.intents.ACTIVITY_EXTRA);
            }
        }
    }

    public void setDescriptionText(TimeZoneEnum timeZoneEnum) {
        String lcActivityName = this.activityName.toLowerCase();
        String description;
        if (timeZoneEnum.equals(TimeZoneEnum.ALL)) {
            description = String.format(getResources().getString(R.string.ALL_description), lcActivityName);
        } else {
            TimeZone tz = map.getTimeZone(timeZoneEnum);
            description = String.format(tz.getDescription(), lcActivityName);
        }
        descriptionTextView.setText(description);
    }

    public void getResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, activityName);
        intent.putExtra(Config.intents.REGION_EXTRA, this.tze);
        startActivityForResult(intent, 2404);
    }
}
