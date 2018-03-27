package org.humanitypreservationfoundation.pulse.activities;

import android.os.Bundle;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.humanitypreservationfoundation.pulse.widgets.ExpandableResourceListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ETASpare on 3/7/2018.
 */

public class PSTAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alaska = new ArrayList<>();
        List<Resource> california = new ArrayList<>();
        List<Resource> hawaii = new ArrayList<>();
        List<Resource> oregon = new ArrayList<>();
        List<Resource> washington = new ArrayList<>();

        alaska.addAll(mTimeZone.getAllStateResources(StateEnum.ALASKA.toStringCode()));
        california.addAll(mTimeZone.getAllStateResources(StateEnum.CALIFORNIA.toStringCode()));
        hawaii.addAll(mTimeZone.getAllStateResources(StateEnum.HAWAII.toStringCode()));
        oregon.addAll(mTimeZone.getAllStateResources(StateEnum.OREGON.toStringCode()));
        washington.addAll(mTimeZone.getAllStateResources(StateEnum.WASHINGTON.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(PSTAllResourcesActivity.this, 5, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ALASKA, alaska);
        adapter.addDataToGroup(ExpandableResourceListAdapter.CALIFORNIA, california);
        adapter.addDataToGroup(ExpandableResourceListAdapter.HAWAII, hawaii);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OREGON, oregon);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WASHINGTON, washington);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
