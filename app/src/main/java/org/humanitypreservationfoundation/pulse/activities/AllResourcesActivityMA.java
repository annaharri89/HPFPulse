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

public class AllResourcesActivityMA extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> new_jersey = new ArrayList<>();
        List<Resource> new_york = new ArrayList<>();
        List<Resource> pennsylvania = new ArrayList<>();

        new_jersey.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_JERSEY.toStringCode()));
        new_york.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_YORK.toStringCode()));
        pennsylvania.addAll(mTimeZone.getAllStateResources(StateEnum.PENNSYLVANIA.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityMA.this, 3, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_JERSEY, new_jersey);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_YORK, new_york);
        adapter.addDataToGroup(ExpandableResourceListAdapter.PENNSYLVANIA, pennsylvania);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
