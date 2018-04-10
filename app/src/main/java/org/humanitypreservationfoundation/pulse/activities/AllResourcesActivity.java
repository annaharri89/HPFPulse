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

/**
 * Created by ETASpare on 3/7/2018.
 */

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.utils.Utils;

public class AllResourcesActivity extends ResourcesActivity {

    protected ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_resources);

        mListView = (ExpandableListView) findViewById(R.id.all_resources_list);
        TextView emptyListView = (TextView) findViewById(R.id.empty_all_resources_list_view);

        if (Utils.isConnectedToInternet(this)) {
            emptyListView.setText(R.string.txt_resource_empty_list_with_internet);
        } else {
            emptyListView.setText(R.string.txt_resource_empty_list_no_internet);
        }

        mListView.setEmptyView(emptyListView);


    }
}
