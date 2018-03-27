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

public class MTAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> arizona = new ArrayList<>();
        List<Resource> colorado = new ArrayList<>();
        List<Resource> idaho = new ArrayList<>();
        List<Resource> montana = new ArrayList<>();
        List<Resource> nevada = new ArrayList<>();
        List<Resource> new_mexico = new ArrayList<>();
        List<Resource> utah = new ArrayList<>();
        List<Resource> wyoming = new ArrayList<>();

        arizona.addAll(mTimeZone.getAllStateResources(StateEnum.ARIZONA.toStringCode()));
        colorado.addAll(mTimeZone.getAllStateResources(StateEnum.COLORADO.toStringCode()));
        idaho.addAll(mTimeZone.getAllStateResources(StateEnum.IDAHO.toStringCode()));
        montana.addAll(mTimeZone.getAllStateResources(StateEnum.MONTANA.toStringCode()));
        nevada.addAll(mTimeZone.getAllStateResources(StateEnum.NEVADA.toStringCode()));
        new_mexico.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_MEXICO.toStringCode()));
        utah.addAll(mTimeZone.getAllStateResources(StateEnum.UTAH.toStringCode()));
        wyoming.addAll(mTimeZone.getAllStateResources(StateEnum.WYOMING.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(MTAllResourcesActivity.this, 8, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ARIZONA, arizona);
        adapter.addDataToGroup(ExpandableResourceListAdapter.COLORADO, colorado);
        adapter.addDataToGroup(ExpandableResourceListAdapter.IDAHO, idaho);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MONTANA, montana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEVADA, nevada);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_MEXICO, new_mexico);
        adapter.addDataToGroup(ExpandableResourceListAdapter.UTAH, utah);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WYOMING, wyoming);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
