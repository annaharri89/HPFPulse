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

public class WNCAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> iowa = new ArrayList<>();
        List<Resource> kansas = new ArrayList<>();
        List<Resource> minnesota = new ArrayList<>();
        List<Resource> missouri = new ArrayList<>();
        List<Resource> nebraska = new ArrayList<>();
        List<Resource> north_dakota = new ArrayList<>();
        List<Resource> south_dakota = new ArrayList<>();

        iowa.addAll(mTimeZone.getAllStateResources(StateEnum.IOWA.toStringCode()));
        kansas.addAll(mTimeZone.getAllStateResources(StateEnum.KANSAS.toStringCode()));
        minnesota.addAll(mTimeZone.getAllStateResources(StateEnum.MINNESOTA.toStringCode()));
        missouri.addAll(mTimeZone.getAllStateResources(StateEnum.MISSOURI.toStringCode()));
        nebraska.addAll(mTimeZone.getAllStateResources(StateEnum.NEBRASKA.toStringCode()));
        north_dakota.addAll(mTimeZone.getAllStateResources(StateEnum.NORTH_DAKOTA.toStringCode()));
        south_dakota.addAll(mTimeZone.getAllStateResources(StateEnum.SOUTH_DAKOTA.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(WNCAllResourcesActivity.this, 7, this.mTimeZoneEnum);

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
