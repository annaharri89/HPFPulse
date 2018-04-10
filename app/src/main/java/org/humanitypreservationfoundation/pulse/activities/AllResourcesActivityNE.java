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

public class AllResourcesActivityNE extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> connecticut = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.CONNECTICUT.toStringCode()));
        List<Resource> maine = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MAINE.toStringCode()));
        List<Resource> massachusetts = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MASSACHUSETTS.toStringCode()));
        List<Resource> new_hampshire = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_HAMPSHIRE.toStringCode()));
        List<Resource> rhode_island = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.RHODE_ISLAND.toStringCode()));
        List<Resource> vermont = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.VERMONT.toStringCode()));

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
