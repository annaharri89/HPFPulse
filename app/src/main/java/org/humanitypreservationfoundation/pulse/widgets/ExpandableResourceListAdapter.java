package org.humanitypreservationfoundation.pulse.widgets;

/**
 * Created by ETASpare on 3/6/2018.
 */

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.R;
import java.util.List;

public class ExpandableResourceListAdapter implements ExpandableListAdapter {
    private Context mContext;


    /*
    public ExpandableResourceListAdapter(Context context) {
        this(context, new ArrayList<Resource>(), new ArrayList<Resource>());
    }
    */

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
        return view;
    }

    /**
     * Called when Website is clicked. Opens Website in user's browser
     */
    public void onWebsiteClick() {
        /*todo is this needed here? or should it be in the ResultsActivity
        todo implement correctly
        Intent intent = new Intent(mContext,
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        mContext.startActivity(intent);
        */
    }

    /**
     * Called when Website is clicked. Opens Website in user's browser
     */
    public void onPhoneNumberClick() {
        /*todo is this needed here? or should it be in the ResultsActivity
        todo implement correctly
        Intent intent = new Intent(mContext,
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        mContext.startActivity(intent);
        */
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
