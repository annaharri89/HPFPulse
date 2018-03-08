package org.humanitypreservationfoundation.pulse.activities;

/**
 * Created by ETASpare on 3/7/2018.
 */

import android.os.Bundle;

import org.humanitypreservationfoundation.pulse.R;

public class AllResourcesActivity extends ResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_resources);


        //todo: IS THIS ACTIVITY NEEDED? CAN PSTAllResourcesActivity JUST BE PSTResourcesActivity?
        //todo: what is reusable?        ---> setContentView, anything else?



        //todo to set dummy data: call mTimezone.getState("AL").setChildAbuseResources(Resources.ChildAbuse.DummyData.AL), etc.
        // todo can for loop through timezone's states to set the resource

    }
}
