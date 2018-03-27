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

public class SAAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> delaware = new ArrayList<>();
        List<Resource> florida = new ArrayList<>();
        List<Resource> georgia = new ArrayList<>();
        List<Resource> maryland = new ArrayList<>();
        List<Resource> north_carolina = new ArrayList<>();
        List<Resource> south_carolina = new ArrayList<>();
        List<Resource> virginia = new ArrayList<>();
        List<Resource> west_virginia = new ArrayList<>();

        delaware.addAll(mTimeZone.getAllStateResources(StateEnum.DELAWARE.toStringCode()));
        florida.addAll(mTimeZone.getAllStateResources(StateEnum.FLORIDA.toStringCode()));
        georgia.addAll(mTimeZone.getAllStateResources(StateEnum.GEORGIA.toStringCode()));
        maryland.addAll(mTimeZone.getAllStateResources(StateEnum.MARYLAND.toStringCode()));
        north_carolina.addAll(mTimeZone.getAllStateResources(StateEnum.NORTH_CAROLINA.toStringCode()));
        south_carolina.addAll(mTimeZone.getAllStateResources(StateEnum.SOUTH_CAROLINA.toStringCode()));
        virginia.addAll(mTimeZone.getAllStateResources(StateEnum.VIRGINIA.toStringCode()));
        west_virginia.addAll(mTimeZone.getAllStateResources(StateEnum.WEST_VIRGINIA.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(SAAllResourcesActivity.this, 8, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.DELAWARE, delaware);
        adapter.addDataToGroup(ExpandableResourceListAdapter.FLORIDA, florida);
        adapter.addDataToGroup(ExpandableResourceListAdapter.GEORGIA, georgia);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MARYLAND, maryland);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NORTH_CAROLINA, north_carolina);
        adapter.addDataToGroup(ExpandableResourceListAdapter.SOUTH_CAROLINA, south_carolina);
        adapter.addDataToGroup(ExpandableResourceListAdapter.VIRGINIA, virginia);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WEST_VIRGINIA, west_virginia);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
