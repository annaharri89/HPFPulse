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
