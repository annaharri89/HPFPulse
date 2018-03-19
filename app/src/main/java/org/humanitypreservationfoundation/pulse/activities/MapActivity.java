package org.humanitypreservationfoundation.pulse.activities;

import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.TimeZone;
import org.humanitypreservationfoundation.pulse.enums.DensitiesEnum;
import org.humanitypreservationfoundation.pulse.utils.Utils;
import org.humanitypreservationfoundation.pulse.views.MapView;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private String mActivityName;
    private MapView mMap;
    private TextView mDescriptionTextView;
    private TimeZoneEnum mTZE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); //needed so that vector drawables can be used in backgrounds
        setContentView(R.layout.activity_map);

        mMap = (MapView) findViewById(R.id.map_view);
        mDescriptionTextView = (TextView) findViewById(R.id.region_description);
        Spinner regionSpinner = (Spinner) findViewById(R.id.region_spinner);
        final Button getResults = (Button) findViewById(R.id.get_results);
        getResults.setEnabled(false);

        ActionBar ab = getSupportActionBar();
        Intent intent = getIntent();
        mActivityName = intent.getStringExtra(Config.intents.ACTIVITY_EXTRA);
        try {
            ab.setTitle(mActivityName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

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
        //regionSpinner.setBackground(VectorDrawableCompat.create(getResources(), R.drawable.ic_grey_spinner, null));
        //regionSpinner.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_grey_spinner));
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

        // Set background here for backwards compatibility
        regionSpinner.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_grey_spinner));
        getResults.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_blue_button_caret_right));

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
        TimeZone tz = mMap.getTimeZone(mTZE);
        String description;
        StringBuilder allCategories = new StringBuilder();
        List<String> allCategoriesList = Arrays.asList(Config.categories.CHILD_ABUSE, Config.categories.BULLYING, Config.categories.DOMESTIC_VIOLENCE);

        if (mActivityName.equals(Config.categories.ALL_RESOURCES)) {
            for (int i = 0; i < allCategoriesList.size(); i++) {
                if (i == allCategoriesList.size() - 1) {
                    allCategories.append("and ");
                }
                allCategories.append(allCategoriesList.get(i).toLowerCase());
                if (i < allCategoriesList.size() - 1) {
                    allCategories.append(", ");
                }
            }
            description = String.format(getResources().getString(R.string.description_header), allCategories.toString(), tz.getDescription());
        } else {
            String lowerCaseActivityName = mActivityName.toLowerCase();
            description = String.format(getResources().getString(R.string.description_header), lowerCaseActivityName, tz.getDescription());
        }
        mDescriptionTextView.setText(description);
    }

    public void getResults(View view) {
        Intent intent = new Intent();
        if (!mActivityName.equals(Config.categories.ALL_RESOURCES)) {
            intent.setClass(this, CategoryResourcesActivity.class);
        } else if (mTZE.equals(TimeZoneEnum.PST)) {
            intent.setClass(this, PSTAllResourcesActivity.class);
        } else { //todo only needed to handle when All Activities is selected and then a timezone other than PST is selected todo: remove once all other timezone specific activities are implemented
            intent.setClass(this, CategoryResourcesActivity.class);
        }

        intent.putExtra(Config.intents.ACTIVITY_EXTRA, mActivityName);
        intent.putExtra(Config.intents.TIMEZONE_EXTRA, mMap.getTimeZone(mTZE));
        startActivityForResult(intent, 2404);
    }
}
