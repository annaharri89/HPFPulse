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

public class ENCAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> illinois = new ArrayList<>();
        List<Resource> indiana = new ArrayList<>();
        List<Resource> michigan = new ArrayList<>();
        List<Resource> ohio = new ArrayList<>();
        List<Resource> wisconsin = new ArrayList<>();

        illinois.addAll(mTimeZone.getAllStateResources(StateEnum.ILLINOIS.toStringCode()));
        indiana.addAll(mTimeZone.getAllStateResources(StateEnum.INDIANA.toStringCode()));
        michigan.addAll(mTimeZone.getAllStateResources(StateEnum.MICHIGAN.toStringCode()));
        ohio.addAll(mTimeZone.getAllStateResources(StateEnum.OHIO.toStringCode()));
        wisconsin.addAll(mTimeZone.getAllStateResources(StateEnum.WISCONSIN.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(ENCAllResourcesActivity.this, 5, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ILLINOIS, illinois);
        adapter.addDataToGroup(ExpandableResourceListAdapter.INDIANA, indiana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MICHIGAN, michigan);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OHIO, ohio);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WISCONSIN, wisconsin);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
