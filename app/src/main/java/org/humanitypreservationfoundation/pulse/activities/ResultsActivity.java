package org.humanitypreservationfoundation.pulse.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

public class ResultsActivity extends AppCompatActivity {

    private String activityName;
    private TimeZoneEnum timeZoneEnum;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent= new Intent();
                intent.putExtra(Config.intents.ACTIVITY_EXTRA, this.activityName);
                setResult(RESULT_OK, intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ActionBar ab = getSupportActionBar();
        Intent intent = getIntent();
        activityName = intent.getStringExtra(Config.intents.ACTIVITY_EXTRA);
        try {
            ab.setTitle(activityName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        timeZoneEnum = (TimeZoneEnum) intent.getSerializableExtra(Config.intents.REGION_EXTRA);
    }
}
