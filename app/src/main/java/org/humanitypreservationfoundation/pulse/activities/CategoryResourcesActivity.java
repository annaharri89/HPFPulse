package org.humanitypreservationfoundation.pulse.activities;

/**
 * Created by ETASpare on 3/7/2018.
 */

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.State;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.humanitypreservationfoundation.pulse.utils.Utils;
import org.humanitypreservationfoundation.pulse.widgets.CategoryResourceListAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoryResourcesActivity extends ResourcesActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_resources);

        List<Resource> resources = new ArrayList<>();
        switch (mActivityName) {
            case Config.categories.CHILD_ABUSE:
                for (State state: mTimeZone.getStates()) {
                    resources.addAll(mTimeZone.getStateChildAbuseResources(state.getCode()));
                }
                break;
            case Config.categories.BULLYING:
                for (State state: mTimeZone.getStates()) {
                    resources.addAll(mTimeZone.getStateBullyingResources(state.getCode()));
                }
                break;
            case Config.categories.DOMESTIC_VIOLENCE:
                for (State state: mTimeZone.getStates()) {
                    resources.addAll(mTimeZone.getStateDomesticViolenceResources(state.getCode()));
                }
                break;
        }

        mListView = (ListView) findViewById(R.id.category_resources_list);
        TextView emptyListView = (TextView) findViewById(R.id.empty_category_list_view);

        if (Utils.isConnectedToInternet(this)) {
            emptyListView.setText(R.string.txt_resource_empty_list_with_internet);
        } else {
            emptyListView.setText(R.string.txt_resource_empty_list_no_internet);
        }

        if (resources.size() > 0) {
            CategoryResourceListAdapter adapter = new CategoryResourceListAdapter(this, resources);
            mListView.setAdapter(adapter);
            mListView.invalidateViews();
        } else {
            mListView.setEmptyView(emptyListView);
        }

    }
}
