package org.humanitypreservationfoundation.pulse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MapView map = (MapView) findViewById(R.id.map_view);

        SpinnerAdapter adap = new ArrayAdapter<String>(this, R.layout.region_spinner_item, getResources().getStringArray(R.array.timezones));
        Spinner regionSpinner = (Spinner) findViewById(R.id.region_spinner);
        regionSpinner.setAdapter(adap);
        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ALL.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.ALL.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.PST.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.PST.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MT.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.MT.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WNC.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.WNC.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WSC.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.WSC.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ENC.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.ENC.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ESC.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.ESC.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MA.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.MA.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.SA.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.SA.toStringCode());
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.NE.toStringName())) {
                    map.setHighlightedTimeZone(TimeZoneEnum.NE.toStringCode());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
