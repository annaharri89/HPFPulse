package org.humanitypreservationfoundation.pulse.activities;

import android.os.Bundle;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.widgets.ExpandableResourceListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ETASpare on 3/7/2018.
 */

public class AllResourcesActivityPST extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alaska = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ALASKA.toStringCode()));
        List<Resource> california = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.CALIFORNIA.toStringCode()));
        List<Resource> hawaii = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.HAWAII.toStringCode()));
        List<Resource> oregon = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.OREGON.toStringCode()));
        List<Resource> washington = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WASHINGTON.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityPST.this, 5, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ALASKA, alaska);
        adapter.addDataToGroup(ExpandableResourceListAdapter.CALIFORNIA, california);
        adapter.addDataToGroup(ExpandableResourceListAdapter.HAWAII, hawaii);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OREGON, oregon);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WASHINGTON, washington);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
