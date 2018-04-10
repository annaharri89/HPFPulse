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

public class AllResourcesActivityENC extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> illinois = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ILLINOIS.toStringCode()));
        List<Resource> indiana = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.INDIANA.toStringCode()));
        List<Resource> michigan = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MICHIGAN.toStringCode()));
        List<Resource> ohio = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.OHIO.toStringCode()));
        List<Resource> wisconsin = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WISCONSIN.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityENC.this, 5, this.mTimeZoneEnum);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ILLINOIS, illinois);
        adapter.addDataToGroup(ExpandableResourceListAdapter.INDIANA, indiana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MICHIGAN, michigan);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OHIO, ohio);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WISCONSIN, wisconsin);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
