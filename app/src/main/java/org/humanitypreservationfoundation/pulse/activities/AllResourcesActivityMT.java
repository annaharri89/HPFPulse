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

public class AllResourcesActivityMT extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> arizona = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ARIZONA.toStringCode()));
        List<Resource> colorado = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.COLORADO.toStringCode()));
        List<Resource> idaho = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.IDAHO.toStringCode()));
        List<Resource> montana = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MONTANA.toStringCode()));
        List<Resource> nevada = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEVADA.toStringCode()));
        List<Resource> new_mexico = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_MEXICO.toStringCode()));
        List<Resource> utah = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.UTAH.toStringCode()));
        List<Resource> wyoming = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WYOMING.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityMT.this, 8, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ARIZONA, arizona);
        adapter.addDataToGroup(ExpandableResourceListAdapter.COLORADO, colorado);
        adapter.addDataToGroup(ExpandableResourceListAdapter.IDAHO, idaho);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MONTANA, montana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEVADA, nevada);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_MEXICO, new_mexico);
        adapter.addDataToGroup(ExpandableResourceListAdapter.UTAH, utah);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WYOMING, wyoming);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
