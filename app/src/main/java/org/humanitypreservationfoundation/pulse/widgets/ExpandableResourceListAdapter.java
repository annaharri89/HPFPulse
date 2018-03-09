package org.humanitypreservationfoundation.pulse.widgets;

/**
 * Created by ETASpare on 3/6/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.utils.Utils;

import java.util.List;

public class ExpandableResourceListAdapter implements ExpandableListAdapter {
    private Context mContext;

    public ExpandableResourceListAdapter(Context context) {
        this.mContext = context;
    }

    public void addDataToGroup(int groupPosition, List<? extends Resource> data) {

    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return -childPosition; //todo: look into: is this what it should be returning?
    }

    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.resource_list_item, parent, false);

        final Resource resource = (Resource) getChild(groupPosition, childPosition);

        if (resource != null) {
            TextView orgName = (TextView) view.findViewById(R.id.txt_org_name);
            TextView orgState = (TextView) view.findViewById(R.id.txt_org_subtitle);
            Button orgWeb = (Button) view.findViewById(R.id.btn_org_web);
            Button orgCall = (Button) view.findViewById(R.id.btn_org_call);

            orgName.setText(resource.getName());
            orgState.setText(resource.getCategory());

            orgWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openWebsite(resource.getUrl());
                }
            });

            orgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call(resource.getPhoneNumber());
                }
            });
        }

        //Adds 16dp padding to bottom of view if it's that last view
        if (childPosition == 2) {
            view.setPadding(0,0,0, Utils.dpToPx(this.mContext, 16));
        }
        return view;
    }

    /**
     * Called when Website is clicked. Opens Website in user's browser
     */
    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        this.mContext.startActivity(intent);
    }

    /**
     * Called when Call is clicked. Opens user's phone client with phoneNumber populated
     */
    private void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        this.mContext.startActivity(intent);
    }

    public long getCombinedChildId(long groupId, long childId) {
        return 0L;
    }

    public long getCombinedGroupId(long groupId) {
        return groupId;
    }

    public Object getGroup(int groupPosition) {
        return null;
    }

    public int getGroupCount() {
        return 0;
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.resource_list_header, null, false);
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public boolean isEmpty() {
        return true;
    }

    public void onGroupCollapsed(int groupPosition) {
        // NA
    }

    public void onGroupExpanded(int groupPosition) {
        // NA
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        // NA
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        // NA
    }
}
