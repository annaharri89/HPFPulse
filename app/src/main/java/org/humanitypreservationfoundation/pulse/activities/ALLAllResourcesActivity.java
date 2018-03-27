package org.humanitypreservationfoundation.pulse.activities;

import android.os.Bundle;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.humanitypreservationfoundation.pulse.widgets.ExpandableResourceListAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ETASpare on 3/7/2018.
 */

public class ALLAllResourcesActivity extends AllResourcesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Resource> alabama = new ArrayList<>();
        List<Resource> alaska = new ArrayList<>();
        List<Resource> arizona = new ArrayList<>();
        List<Resource> arkansas = new ArrayList<>();
        List<Resource> california = new ArrayList<>();

        List<Resource> colorado = new ArrayList<>();
        List<Resource> connecticut = new ArrayList<>();
        List<Resource> delaware = new ArrayList<>();
        List<Resource> florida = new ArrayList<>();
        List<Resource> georgia = new ArrayList<>();

        List<Resource> hawaii = new ArrayList<>();
        List<Resource> idaho = new ArrayList<>();
        List<Resource> illinois = new ArrayList<>();
        List<Resource> indiana = new ArrayList<>();
        List<Resource> iowa = new ArrayList<>();

        List<Resource> kansas = new ArrayList<>();
        List<Resource> kentucky = new ArrayList<>();
        List<Resource> louisiana = new ArrayList<>();
        List<Resource> maine = new ArrayList<>();
        List<Resource> maryland = new ArrayList<>();

        List<Resource> massachusetts = new ArrayList<>();
        List<Resource> michigan = new ArrayList<>();
        List<Resource> minnesota = new ArrayList<>();
        List<Resource> mississippi = new ArrayList<>();
        List<Resource> missouri = new ArrayList<>();

        List<Resource> montana = new ArrayList<>();
        List<Resource> nebraska = new ArrayList<>();
        List<Resource> nevada = new ArrayList<>();
        List<Resource> new_hampshire = new ArrayList<>();
        List<Resource> new_jersey = new ArrayList<>();

        List<Resource> new_mexico = new ArrayList<>();
        List<Resource> new_york = new ArrayList<>();
        List<Resource> north_carolina = new ArrayList<>();
        List<Resource> north_dakota = new ArrayList<>();
        List<Resource> ohio = new ArrayList<>();

        List<Resource> oklahoma = new ArrayList<>();
        List<Resource> oregon = new ArrayList<>();
        List<Resource> pennsylvania = new ArrayList<>();
        List<Resource> rhode_island = new ArrayList<>();
        List<Resource> south_carolina = new ArrayList<>();

        List<Resource> south_dakota = new ArrayList<>();
        List<Resource> tennessee = new ArrayList<>();
        List<Resource> texas = new ArrayList<>();
        List<Resource> utah = new ArrayList<>();
        List<Resource> vermont = new ArrayList<>();

        List<Resource> virginia = new ArrayList<>();
        List<Resource> washington = new ArrayList<>();
        List<Resource> west_virginia = new ArrayList<>();
        List<Resource> wisconsin = new ArrayList<>();
        List<Resource> wyoming = new ArrayList<>();

        alabama.addAll(mTimeZone.getAllStateResources(StateEnum.ALABAMA.toStringCode()));
        alaska.addAll(mTimeZone.getAllStateResources(StateEnum.ALASKA.toStringCode()));
        arizona.addAll(mTimeZone.getAllStateResources(StateEnum.ARIZONA.toStringCode()));
        arkansas.addAll(mTimeZone.getAllStateResources(StateEnum.ARKANSAS.toStringCode()));
        california.addAll(mTimeZone.getAllStateResources(StateEnum.CALIFORNIA.toStringCode()));

        colorado.addAll(mTimeZone.getAllStateResources(StateEnum.COLORADO.toStringCode()));
        connecticut.addAll(mTimeZone.getAllStateResources(StateEnum.CONNECTICUT.toStringCode()));
        delaware.addAll(mTimeZone.getAllStateResources(StateEnum.DELAWARE.toStringCode()));
        florida.addAll(mTimeZone.getAllStateResources(StateEnum.FLORIDA.toStringCode()));
        georgia.addAll(mTimeZone.getAllStateResources(StateEnum.GEORGIA.toStringCode()));

        hawaii.addAll(mTimeZone.getAllStateResources(StateEnum.HAWAII.toStringCode()));
        idaho.addAll(mTimeZone.getAllStateResources(StateEnum.IDAHO.toStringCode()));
        illinois.addAll(mTimeZone.getAllStateResources(StateEnum.ILLINOIS.toStringCode()));
        indiana.addAll(mTimeZone.getAllStateResources(StateEnum.INDIANA.toStringCode()));
        iowa.addAll(mTimeZone.getAllStateResources(StateEnum.IOWA.toStringCode()));

        kansas.addAll(mTimeZone.getAllStateResources(StateEnum.KANSAS.toStringCode()));
        kentucky.addAll(mTimeZone.getAllStateResources(StateEnum.KENTUCKY.toStringCode()));
        louisiana.addAll(mTimeZone.getAllStateResources(StateEnum.LOUISIANA.toStringCode()));
        maine.addAll(mTimeZone.getAllStateResources(StateEnum.MAINE.toStringCode()));
        maryland.addAll(mTimeZone.getAllStateResources(StateEnum.MARYLAND.toStringCode()));

        massachusetts.addAll(mTimeZone.getAllStateResources(StateEnum.MASSACHUSETTS.toStringCode()));
        michigan.addAll(mTimeZone.getAllStateResources(StateEnum.MICHIGAN.toStringCode()));
        minnesota.addAll(mTimeZone.getAllStateResources(StateEnum.MINNESOTA.toStringCode()));
        mississippi.addAll(mTimeZone.getAllStateResources(StateEnum.MISSISSIPPI.toStringCode()));
        missouri.addAll(mTimeZone.getAllStateResources(StateEnum.MISSOURI.toStringCode()));

        montana.addAll(mTimeZone.getAllStateResources(StateEnum.MONTANA.toStringCode()));
        nebraska.addAll(mTimeZone.getAllStateResources(StateEnum.NEBRASKA.toStringCode()));
        nevada.addAll(mTimeZone.getAllStateResources(StateEnum.NEVADA.toStringCode()));
        new_hampshire.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_HAMPSHIRE.toStringCode()));
        new_jersey.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_JERSEY.toStringCode()));

        new_mexico.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_MEXICO.toStringCode()));
        new_york.addAll(mTimeZone.getAllStateResources(StateEnum.NEW_YORK.toStringCode()));
        north_carolina.addAll(mTimeZone.getAllStateResources(StateEnum.NORTH_CAROLINA.toStringCode()));
        north_dakota.addAll(mTimeZone.getAllStateResources(StateEnum.NORTH_DAKOTA.toStringCode()));
        ohio.addAll(mTimeZone.getAllStateResources(StateEnum.OHIO.toStringCode()));

        oklahoma.addAll(mTimeZone.getAllStateResources(StateEnum.OKLAHOMA.toStringCode()));
        oregon.addAll(mTimeZone.getAllStateResources(StateEnum.OREGON.toStringCode()));
        pennsylvania.addAll(mTimeZone.getAllStateResources(StateEnum.PENNSYLVANIA.toStringCode()));
        rhode_island.addAll(mTimeZone.getAllStateResources(StateEnum.RHODE_ISLAND.toStringCode()));
        south_carolina.addAll(mTimeZone.getAllStateResources(StateEnum.SOUTH_CAROLINA.toStringCode()));

        south_dakota.addAll(mTimeZone.getAllStateResources(StateEnum.SOUTH_DAKOTA.toStringCode()));
        tennessee.addAll(mTimeZone.getAllStateResources(StateEnum.TENNESSEE.toStringCode()));
        texas.addAll(mTimeZone.getAllStateResources(StateEnum.TEXAS.toStringCode()));
        utah.addAll(mTimeZone.getAllStateResources(StateEnum.UTAH.toStringCode()));
        vermont.addAll(mTimeZone.getAllStateResources(StateEnum.VERMONT.toStringCode()));

        virginia.addAll(mTimeZone.getAllStateResources(StateEnum.VIRGINIA.toStringCode()));
        washington.addAll(mTimeZone.getAllStateResources(StateEnum.WASHINGTON.toStringCode()));
        west_virginia.addAll(mTimeZone.getAllStateResources(StateEnum.WEST_VIRGINIA.toStringCode()));
        wisconsin.addAll(mTimeZone.getAllStateResources(StateEnum.WISCONSIN.toStringCode()));
        wyoming.addAll(mTimeZone.getAllStateResources(StateEnum.WYOMING.toStringCode()));

        final ExpandableResourceListAdapter adapter = new ExpandableResourceListAdapter(ALLAllResourcesActivity.this, 50, TimeZoneEnum.ALL);

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
