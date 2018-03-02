package org.humanitypreservationfoundation.pulse;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MapView map = (MapView) findViewById(R.id.map_view);

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
                TimeZoneEnum tze;

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
                map.changeHighlightedTimeZone(tze);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
