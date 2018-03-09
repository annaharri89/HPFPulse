package org.humanitypreservationfoundation.pulse.activities;

import android.os.Bundle;
import android.widget.ExpandableListView;

import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.widgets.PSTExpandableResourceListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ETASpare on 3/7/2018.
 */

public class PSTAllResourcesActivity extends AllResourcesActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alaska = new ArrayList<Resource>();
        List<Resource> california = new ArrayList<Resource>();
        List<Resource> hawaii = new ArrayList<Resource>();
        List<Resource> oregon = new ArrayList<Resource>();
        List<Resource> washington = new ArrayList<Resource>();

        alaska.addAll(mTimeZone.getAllStateResources(StateEnum.ALASKA.toStringCode()));
        california.addAll(mTimeZone.getAllStateResources(StateEnum.CALIFORNIA.toStringCode()));
        hawaii.addAll(mTimeZone.getAllStateResources(StateEnum.HAWAII.toStringCode()));
        oregon.addAll(mTimeZone.getAllStateResources(StateEnum.OREGON.toStringCode()));
        washington.addAll(mTimeZone.getAllStateResources(StateEnum.WASHINGTON.toStringCode()));

        final PSTExpandableResourceListAdapter adapter = new PSTExpandableResourceListAdapter(PSTAllResourcesActivity.this);

        adapter.addDataToGroup(PSTExpandableResourceListAdapter.ALASKA, alaska);
        adapter.addDataToGroup(PSTExpandableResourceListAdapter.CALIFORNIA, california);
        adapter.addDataToGroup(PSTExpandableResourceListAdapter.HAWAII, hawaii);
        adapter.addDataToGroup(PSTExpandableResourceListAdapter.OREGON, oregon);
        adapter.addDataToGroup(PSTExpandableResourceListAdapter.WASHINGTON, washington);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
