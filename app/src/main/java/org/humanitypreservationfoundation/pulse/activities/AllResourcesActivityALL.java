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

public class AllResourcesActivityALL extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alabama = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ALABAMA.toStringCode()));
        List<Resource> alaska = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ALASKA.toStringCode()));
        List<Resource> arizona = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ARIZONA.toStringCode()));
        List<Resource> arkansas = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ARKANSAS.toStringCode()));
        List<Resource> california = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.CALIFORNIA.toStringCode()));

        List<Resource> colorado = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.COLORADO.toStringCode()));
        List<Resource> connecticut = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.CONNECTICUT.toStringCode()));
        List<Resource> delaware = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.DELAWARE.toStringCode()));
        List<Resource> florida = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.FLORIDA.toStringCode()));
        List<Resource> georgia = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.GEORGIA.toStringCode()));

        List<Resource> hawaii = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.HAWAII.toStringCode()));
        List<Resource> idaho = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.IDAHO.toStringCode()));
        List<Resource> illinois = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.ILLINOIS.toStringCode()));
        List<Resource> indiana = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.INDIANA.toStringCode()));
        List<Resource> iowa = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.IOWA.toStringCode()));

        List<Resource> kansas = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.KANSAS.toStringCode()));
        List<Resource> kentucky = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.KENTUCKY.toStringCode()));
        List<Resource> louisiana = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.LOUISIANA.toStringCode()));
        List<Resource> maine = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MAINE.toStringCode()));
        List<Resource> maryland = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MARYLAND.toStringCode()));

        List<Resource> massachusetts = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MASSACHUSETTS.toStringCode()));
        List<Resource> michigan = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MICHIGAN.toStringCode()));
        List<Resource> minnesota = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MINNESOTA.toStringCode()));
        List<Resource> mississippi = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MISSISSIPPI.toStringCode()));
        List<Resource> missouri = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MISSOURI.toStringCode()));

        List<Resource> montana = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.MONTANA.toStringCode()));
        List<Resource> nebraska = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEBRASKA.toStringCode()));
        List<Resource> nevada = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEVADA.toStringCode()));
        List<Resource> new_hampshire = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_HAMPSHIRE.toStringCode()));
        List<Resource> new_jersey = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_JERSEY.toStringCode()));

        List<Resource> new_mexico = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_MEXICO.toStringCode()));
        List<Resource> new_york = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NEW_YORK.toStringCode()));
        List<Resource> north_carolina = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NORTH_CAROLINA.toStringCode()));
        List<Resource> north_dakota = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.NORTH_DAKOTA.toStringCode()));
        List<Resource> ohio = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.OHIO.toStringCode()));

        List<Resource> oklahoma = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.OKLAHOMA.toStringCode()));
        List<Resource> oregon = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.OREGON.toStringCode()));
        List<Resource> pennsylvania = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.PENNSYLVANIA.toStringCode()));
        List<Resource> rhode_island = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.RHODE_ISLAND.toStringCode()));
        List<Resource> south_carolina = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.SOUTH_CAROLINA.toStringCode()));

        List<Resource> south_dakota = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.SOUTH_DAKOTA.toStringCode()));
        List<Resource> tennessee = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.TENNESSEE.toStringCode()));
        List<Resource> texas = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.TEXAS.toStringCode()));
        List<Resource> utah = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.UTAH.toStringCode()));
        List<Resource> vermont = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.VERMONT.toStringCode()));

        List<Resource> virginia = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.VIRGINIA.toStringCode()));
        List<Resource> washington = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WASHINGTON.toStringCode()));
        List<Resource> west_virginia = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WEST_VIRGINIA.toStringCode()));
        List<Resource> wisconsin = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WISCONSIN.toStringCode()));
        List<Resource> wyoming = new ArrayList<>(mTimeZone.getAllStateResources(StateEnum.WYOMING.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(AllResourcesActivityALL.this, 50, TimeZoneEnum.ALL);

        adapter.addDataToGroup(ExpandableResourceListAdapter.ALABAMA, alabama);
        adapter.addDataToGroup(ExpandableResourceListAdapter.ALASKA, alaska);
        adapter.addDataToGroup(ExpandableResourceListAdapter.ARIZONA, arizona);
        adapter.addDataToGroup(ExpandableResourceListAdapter.ARKANSAS, arkansas);
        adapter.addDataToGroup(ExpandableResourceListAdapter.CALIFORNIA, california);

        adapter.addDataToGroup(ExpandableResourceListAdapter.COLORADO, colorado);
        adapter.addDataToGroup(ExpandableResourceListAdapter.CONNECTICUT, connecticut);
        adapter.addDataToGroup(ExpandableResourceListAdapter.DELAWARE, delaware);
        adapter.addDataToGroup(ExpandableResourceListAdapter.FLORIDA, florida);
        adapter.addDataToGroup(ExpandableResourceListAdapter.GEORGIA, georgia);

        adapter.addDataToGroup(ExpandableResourceListAdapter.HAWAII, hawaii);
        adapter.addDataToGroup(ExpandableResourceListAdapter.IDAHO, idaho);
        adapter.addDataToGroup(ExpandableResourceListAdapter.ILLINOIS, illinois);
        adapter.addDataToGroup(ExpandableResourceListAdapter.INDIANA, indiana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.IOWA, iowa);

        adapter.addDataToGroup(ExpandableResourceListAdapter.KANSAS, kansas);
        adapter.addDataToGroup(ExpandableResourceListAdapter.KENTUCKY, kentucky);
        adapter.addDataToGroup(ExpandableResourceListAdapter.LOUISIANA, louisiana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MAINE, maine);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MARYLAND, maryland);

        adapter.addDataToGroup(ExpandableResourceListAdapter.MASSACHUSETTS, massachusetts);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MICHIGAN, michigan);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MINNESOTA, minnesota);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MISSISSIPPI, mississippi);
        adapter.addDataToGroup(ExpandableResourceListAdapter.MISSOURI, missouri);

        adapter.addDataToGroup(ExpandableResourceListAdapter.MONTANA, montana);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEBRASKA, nebraska);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEVADA, nevada);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_HAMPSHIRE, new_hampshire);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_JERSEY, new_jersey);

        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_MEXICO, new_mexico);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NEW_YORK, new_york);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NORTH_CAROLINA, north_carolina);
        adapter.addDataToGroup(ExpandableResourceListAdapter.NORTH_DAKOTA, north_dakota);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OHIO, ohio);

        adapter.addDataToGroup(ExpandableResourceListAdapter.OKLAHOMA, oklahoma);
        adapter.addDataToGroup(ExpandableResourceListAdapter.OREGON, oregon);
        adapter.addDataToGroup(ExpandableResourceListAdapter.PENNSYLVANIA, pennsylvania);
        adapter.addDataToGroup(ExpandableResourceListAdapter.RHODE_ISLAND, rhode_island);
        adapter.addDataToGroup(ExpandableResourceListAdapter.SOUTH_CAROLINA, south_carolina);

        adapter.addDataToGroup(ExpandableResourceListAdapter.SOUTH_DAKOTA, south_dakota);
        adapter.addDataToGroup(ExpandableResourceListAdapter.TENNESSEE, tennessee);
        adapter.addDataToGroup(ExpandableResourceListAdapter.TEXAS, texas);
        adapter.addDataToGroup(ExpandableResourceListAdapter.UTAH, utah);
        adapter.addDataToGroup(ExpandableResourceListAdapter.VERMONT, vermont);

        adapter.addDataToGroup(ExpandableResourceListAdapter.VIRGINIA, virginia);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WASHINGTON, washington);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WEST_VIRGINIA, west_virginia);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WISCONSIN, wisconsin);
        adapter.addDataToGroup(ExpandableResourceListAdapter.WYOMING, wyoming);

        mListView.setAdapter(adapter);
        mListView.invalidateViews();
    }
}
