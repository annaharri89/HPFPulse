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

public class AllResourcesActivityESC extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alabama = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ALABAMA.toStringCode()));
        List<Resource> kentucky = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.KENTUCKY.toStringCode()));
        List<Resource> mississippi = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MISSISSIPPI.toStringCode()));
        List<Resource> tennessee = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.TENNESSEE.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityESC.this, 4, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ALABAMA, alabama);
        adapter.addDataToGroup(ExpandableResourceListAdapter.KENTUCKY, kentucky);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MISSISSIPPI, mississippi);
        adapter.addDataToGroup(ExpandableResourceListAdapter.TENNESSEE, tennessee);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
