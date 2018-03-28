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

public class AllResourcesActivityWSC extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> arkansas = new ArrayList<>();
        List<Resource> louisiana = new ArrayList<>();
        List<Resource> oklahoma = new ArrayList<>();
        List<Resource> texas = new ArrayList<>();

        arkansas.addAll(mTimeZone.getAllStateResources(StateEnum.ARKANSAS.toStringCode()));
        louisiana.addAll(mTimeZone.getAllStateResources(StateEnum.LOUISIANA.toStringCode()));
        oklahoma.addAll(mTimeZone.getAllStateResources(StateEnum.OKLAHOMA.toStringCode()));
        texas.addAll(mTimeZone.getAllStateResources(StateEnum.TEXAS.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityWSC.this, 4, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ARKANSAS, arkansas);
        adapter.addDataToGroup(ExpandableResourceListAdapter.LOUISIANA, louisiana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OKLAHOMA, oklahoma);
        adapter.addDataToGroup(ExpandableResourceListAdapter.TEXAS, texas);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
