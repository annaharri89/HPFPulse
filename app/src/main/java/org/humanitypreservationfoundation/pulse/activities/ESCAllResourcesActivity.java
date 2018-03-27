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

public class ESCAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alabama = new ArrayList<>();
        List<Resource> kentucky = new ArrayList<>();
        List<Resource> mississippi = new ArrayList<>();
        List<Resource> tennessee = new ArrayList<>();

        alabama.addAll(mTimeZone.getAllStateResources(StateEnum.ALABAMA.toStringCode()));
        kentucky.addAll(mTimeZone.getAllStateResources(StateEnum.KENTUCKY.toStringCode()));
        mississippi.addAll(mTimeZone.getAllStateResources(StateEnum.MISSISSIPPI.toStringCode()));
        tennessee.addAll(mTimeZone.getAllStateResources(StateEnum.TENNESSEE.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(ESCAllResourcesActivity.this, 4, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ALABAMA, alabama);
        adapter.addDataToGroup(ExpandableResourceListAdapter.KENTUCKY, kentucky);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MISSISSIPPI, mississippi);
        adapter.addDataToGroup(ExpandableResourceListAdapter.TENNESSEE, tennessee);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
