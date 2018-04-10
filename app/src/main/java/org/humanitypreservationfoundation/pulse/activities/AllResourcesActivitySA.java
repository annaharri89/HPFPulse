/*
        Copyright 2018 The Humanity Preservation Foundation

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
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

public class AllResourcesActivitySA extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> delaware = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.DELAWARE.toStringCode()));
        List<Resource> florida = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.FLORIDA.toStringCode()));
        List<Resource> georgia = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.GEORGIA.toStringCode()));
        List<Resource> maryland = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MARYLAND.toStringCode()));
        List<Resource> north_carolina = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NORTH_CAROLINA.toStringCode()));
        List<Resource> south_carolina = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.SOUTH_CAROLINA.toStringCode()));
        List<Resource> virginia = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.VIRGINIA.toStringCode()));
        List<Resource> west_virginia = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WEST_VIRGINIA.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivitySA.this, 8, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.DELAWARE, delaware);
        adapter.addDataToGroup(ExpandableResourceListAdapter.FLORIDA, florida);
        adapter.addDataToGroup(ExpandableResourceListAdapter.GEORGIA, georgia);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MARYLAND, maryland);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NORTH_CAROLINA, north_carolina);
        adapter.addDataToGroup(ExpandableResourceListAdapter.SOUTH_CAROLINA, south_carolina);
        adapter.addDataToGroup(ExpandableResourceListAdapter.VIRGINIA, virginia);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WEST_VIRGINIA, west_virginia);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
