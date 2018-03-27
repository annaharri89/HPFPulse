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

public class AllResourcesActivityNE extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> connecticut = new ArrayList<>();
        List<Resource> maine = new ArrayList<>();
        List<Resource> massachusetts = new ArrayList<>();
        List<Resource> new_hampshire = new ArrayList<>();
        List<Resource> rhode_island = new ArrayList<>();
        List<Resource> vermont = new ArrayList<>();

        connecticut.addAll(mTimeZone.getAllStateResources(StateEnum.CONNECTICUT.toStringCode()));
        maine.addAll(mTimeZone.getAllStateResources(StateEnum.MAINE.toStringCode()));
        massachusetts.addAll(mTimeZone.getAllStateResources(StateEnum.MASSACHUSETTS.toStringCode()));
        new_hampshire.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_HAMPSHIRE.toStringCode()));
        rhode_island.addAll(mTimeZone.getAllStateResources(StateEnum.RHODE_ISLAND.toStringCode()));
        vermont.addAll(mTimeZone.getAllStateResources(StateEnum.VERMONT.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityNE.this, 6, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.CONNECTICUT, connecticut);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MAINE, maine);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MASSACHUSETTS, massachusetts);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_HAMPSHIRE, new_hampshire);
        adapter.addDataToGroup(ExpandableResourceListAdapter.RHODE_ISLAND, rhode_island);
        adapter.addDataToGroup(ExpandableResourceListAdapter.VERMONT, vermont);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
