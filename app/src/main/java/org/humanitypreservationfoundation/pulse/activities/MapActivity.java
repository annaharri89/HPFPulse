package org.humanitypreservationfoundation.pulse.activities;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.content.res.AppCompatResources;
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

import java.util.Arrays;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private String mActivityName;
    private MapView mMap;
    private TextView mDescriptionTextView;
    private TimeZoneEnum mTimeZoneEnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); //needed so that vector drawables can be used in backgrounds
        setContentView(R.layout.activity_map);

        mMap = (MapView) findViewById(R.id.map_view);
        mDescriptionTextView = (TextView) findViewById(R.id.region_description);
        Spinner regionSpinner = (Spinner) findViewById(R.id.region_spinner);
        final Button getResults = (Button) findViewById(R.id.get_results);

        ActionBar ab = getSupportActionBar();
        Intent intent = getIntent();
        mActivityName = intent.getStringExtra(Config.intents.ACTIVITY_EXTRA);
        try {
            ab.setTitle(mActivityName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        SpinnerAdapter adapter = new ArrayAdapter<String>(this, R.layout.region_spinner_item, getResources().getStringArray(R.array.timezones)) {
            /**
             * Disables the "Select a region" option
             */
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }

            /**
             * Sets the "Select a region" text to grey to show that it isn't selectable
             */
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

        regionSpinner.setAdapter(adapter);
        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ALL.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.ALL;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.PST.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.PST;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MT.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.MT;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WNC.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.WNC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.WSC.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.WSC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ENC.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.ENC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.ESC.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.ESC;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.MA.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.MA;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.SA.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.SA;
                } else if (parent.getItemAtPosition(position).equals(TimeZoneEnum.NE.toStringName())) {
                    mTimeZoneEnum = TimeZoneEnum.NE;
                } else {
                    return;
                }

                //getResults button is not enabled until a time zone is selected from the spinner
                if (!getResults.isEnabled()) {
                    getResults.setEnabled(true);
                }
                mMap.changeHighlightedTimeZone(mTimeZoneEnum);
                setDescriptionText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Set background here for backwards compatibility (to handle vector drawables in API 20
        // and below
        regionSpinner.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_grey_spinner));
        getResults.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_blue_button_caret_right));

    }

    /**
     * Needed so that the MapActivity will retain the correct category when the user travels back
     * from the one of the Resources Activities. Category stored in mActivityName and used to set
     * the action bar title
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 2404) {
            if(data != null) {
                mActivityName = data.getStringExtra(Config.intents.ACTIVITY_EXTRA);
            }
        }
    }

    /**
     * Sets the time zone description text (a description for what category the user is getting
     * resources for and what states belong to the selected time zone)
     */
    public void setDescriptionText() {
        TimeZone tz = mMap.getTimeZone(mTimeZoneEnum);
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

    /**
     * Opens appropriate Resource activity based on the category / timezone
     */
    public void getResults(View view) {
        Intent intent = new Intent();
        if (!mActivityName.equals(Config.categories.ALL_RESOURCES)) {
            intent.setClass(this, CategoryResourcesActivity.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.PST)) {
            intent.setClass(this, AllResourcesActivityPST.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.MT)) {
            intent.setClass(this, AllResourcesActivityMT.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.WNC)) {
            intent.setClass(this, AllResourcesActivityWNC.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.WSC)) {
            intent.setClass(this, AllResourcesActivityWSC.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.ENC)) {
            intent.setClass(this, AllResourcesActivityENC.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.ESC)) {
            intent.setClass(this, AllResourcesActivityESC.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.MA)) {
            intent.setClass(this, AllResourcesActivityMA.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.SA)) {
            intent.setClass(this, AllResourcesActivitySA.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.NE)) {
            intent.setClass(this, AllResourcesActivityNE.class);
        } else if (mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            intent.setClass(this, AllResourcesActivityALL.class);
        }

        intent.putExtra(Config.intents.ACTIVITY_EXTRA, mActivityName);
        intent.putExtra(Config.intents.TIMEZONE_EXTRA, mMap.getTimeZone(mTimeZoneEnum));
        startActivityForResult(intent, 2404);
    }
}
