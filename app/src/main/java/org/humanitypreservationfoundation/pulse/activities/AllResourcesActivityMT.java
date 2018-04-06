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

public class AllResourcesActivityMT extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> arizona = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ARIZONA.toStringCode()));
        List<Resource> colorado = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.COLORADO.toStringCode()));
        List<Resource> idaho = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.IDAHO.toStringCode()));
        List<Resource> montana = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MONTANA.toStringCode()));
        List<Resource> nevada = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEVADA.toStringCode()));
        List<Resource> new_mexico = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_MEXICO.toStringCode()));
        List<Resource> utah = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.UTAH.toStringCode()));
        List<Resource> wyoming = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WYOMING.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityMT.this, 8, this.mTimeZoneEnum);

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
