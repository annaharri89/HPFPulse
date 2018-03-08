package org.humanitypreservationfoundation.pulse.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.classes.TimeZone;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

public class ResourcesActivity extends AppCompatActivity {

    protected String mActivityName;
    protected TimeZoneEnum mTimeZoneEnum;
    protected TimeZone mTimeZone;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent= new Intent();
                intent.putExtra(Config.intents.ACTIVITY_EXTRA, mActivityName);
                setResult(RESULT_OK, intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar ab = getSupportActionBar();
        Intent intent = getIntent();
        mActivityName = intent.getStringExtra(Config.intents.ACTIVITY_EXTRA);
        try {
            ab.setTitle(this.mActivityName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        //todo why do I need the timezone enum? if you figure it out, you can get it from the timezone object passed through the intent

        mTimeZone = (TimeZone) intent.getParcelableExtra(Config.intents.TIMEZONE_EXTRA);
        mTimeZoneEnum = mTimeZone.getEnum(); // todo why do i need the timezone enum?
    }
}
