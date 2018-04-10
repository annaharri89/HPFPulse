/*
        Copyright 2018 The Humanity Preservation Foundation

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
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

        mTimeZone = (TimeZone) intent.getParcelableExtra(Config.intents.TIMEZONE_EXTRA);
        mTimeZoneEnum = mTimeZone.getEnum();
    }
}
