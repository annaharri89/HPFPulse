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

public class AllResourcesActivityWNC extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> iowa = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.IOWA.toStringCode()));
        List<Resource> kansas = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.KANSAS.toStringCode()));
        List<Resource> minnesota = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MINNESOTA.toStringCode()));
        List<Resource> missouri = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MISSOURI.toStringCode()));
        List<Resource> nebraska = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEBRASKA.toStringCode()));
        List<Resource> north_dakota = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NORTH_DAKOTA.toStringCode()));
        List<Resource> south_dakota = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.SOUTH_DAKOTA.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityWNC.this, 7, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.IOWA, iowa);
        adapter.addDataToGroup(ExpandableResourceListAdapter.KANSAS, kansas);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MINNESOTA, minnesota);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MISSOURI, missouri);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEBRASKA, nebraska);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NORTH_DAKOTA, north_dakota);
        adapter.addDataToGroup(ExpandableResourceListAdapter.SOUTH_DAKOTA, south_dakota);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
