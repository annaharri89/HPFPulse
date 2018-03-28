package org.humanitypreservationfoundation.pulse.activities;

/**
 * Created by ETASpare on 3/7/2018.
 */

import android.os.Bundle;
import android.widget.ExpandableListView;

import org.humanitypreservationfoundation.pulse.R;

public class AllResourcesActivity extends ResourcesActivity {

    protected ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_resources);

        mListView = (ExpandableListView) findViewById(R.id.all_resources_list);
    }
}
