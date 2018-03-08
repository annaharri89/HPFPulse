package org.humanitypreservationfoundation.pulse.widgets;

/**
 * Created by ETASpare on 3/6/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;

import java.util.ArrayList;
import java.util.List;

public class PSTExpandableResourceListAdapter extends ExpandableResourceListAdapter {
    public static final int ALASKA = 0;
    public static final int CALIFORNIA = 1;
    public static final int HAWAII = 2;
    public static final int OREGON = 3;
    public static final int WASHINGTON = 4;

    private Context mContext;
    private List<Resource> mAlaskaData;
    private List<Resource> mCaliforniaData;
    private List<Resource> mHawaiiData;
    private List<Resource> mOregonData;
    private List<Resource> mWashingtionData;

    public PSTExpandableResourceListAdapter(Context context) {
        this(context, new ArrayList<Resource>(), new ArrayList<Resource>(), new ArrayList<Resource>(),
                new ArrayList<Resource>(), new ArrayList<Resource>());
    }

    public PSTExpandableResourceListAdapter(Context context, List<Resource> AKData, List<Resource> CAData,
                                            List<Resource> HIData, List<Resource> ORData, List<Resource> WAData) {
        super(context);
        this.mContext = context;
        this.mAlaskaData = AKData;
        this.mCaliforniaData = CAData;
        this.mHawaiiData = HIData;
        this.mOregonData = ORData;
        this.mWashingtionData = WAData;
    }

    /**
     * Adds Resource results to mAlaskaData, mCaliforniaData, mHawaiiData, mOregonData, mWashingtionData
     * depending on the <code>groupPosition</code>
     * @param groupPosition options: ALASKA = 0 CALIFORNIA = 1 HAWAII = 2 OREGON = 3 WASHINGTON = 4
     * @param data list of Resources
     */
    //TODO: Call in ResultsActivity adapter.addDataToGroup()
    @Override
    public void addDataToGroup(int groupPosition, List<? extends Resource> data) {
        switch (groupPosition) {
            case ALASKA:
                mAlaskaData.addAll(data);
                break;

            case CALIFORNIA:
                mCaliforniaData.addAll(data);
                break;

            case HAWAII:
                mHawaiiData.addAll(data);
                break;

            case OREGON:
                mOregonData.addAll(data);
                break;

            case WASHINGTON:
                mWashingtionData.addAll(data);
                break;
        }
    }

    /**
     * Depending on groupPosition, returns the data for a helper result or returns the data for a
     * resource.
     * @param groupPosition options: ALASKA = 0 CALIFORNIA = 1 HAWAII = 2 OREGON = 3 WASHINGTON = 4
     * @param childPosition dictates which result is returned
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        switch (groupPosition) {
            case ALASKA:
                return mAlaskaData.get(childPosition);

            case CALIFORNIA:
                return mCaliforniaData.get(childPosition);

            case HAWAII:
                return mHawaiiData.get(childPosition);

            case OREGON:
                return mOregonData.get(childPosition);

            case WASHINGTON:
                return mWashingtionData.get(childPosition);

        }

        return null;
    }

    /**
     * Returns a resources's Id
     * @param groupPosition options: ALASKA = 0 CALIFORNIA = 1 HAWAII = 2 OREGON = 3 WASHINGTON = 4
     * @param childPosition dictates which result is stored in <code>resource</code>
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        Resource resource = (Resource) getChild(groupPosition, childPosition);
        if (resource != null) {
            return resource.getId();
        }

        return -childPosition; //todo: look into: is this what it should be returning?
    }

    /**
     * Depending on the <code>groupPosition</code>, returns the size of the appropriate data group
     * @param groupPosition options: ALASKA = 0 CALIFORNIA = 1 HAWAII = 2 OREGON = 3 WASHINGTON = 4
     * @return size of data group
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        switch (groupPosition) {
            case ALASKA:
                return mAlaskaData.size();

            case CALIFORNIA:
                return mCaliforniaData.size();

            case HAWAII:
                return mHawaiiData.size();

            case OREGON:
                return mOregonData.size();

            case WASHINGTON:
                return mWashingtionData.size();


        }

        return 0;
    }

    /**
     * Inflates a child view depending on <code>groupPosition</code> and <code>childPosition</code>
     * @param groupPosition options: ALASKA = 0 CALIFORNIA = 1 HAWAII = 2 OREGON = 3 WASHINGTON = 4
     * @param childPosition position of child in list
     * @param isLastChild boolean
     * @param parent parent ViewGroup
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.resource_list_item, parent, false);

        final Resource resource = (Resource) getChild(groupPosition, childPosition);

        if (resource != null) {
            /*
            TextView primaryText = (TextView) view.findViewById(R.id.primary_text);
            TextView secondaryText = (TextView) view.findViewById(R.id.secondary_text);
            todo set result list item textviews and button data
            */
        }
        return view;
    }

    /**
     * Called when Website is clicked. Opens Website in user's browser
     */
    public void onWebsiteClick() {
        /*todo is this needed here? or should it be in the ResultsActivity or should it be in ExpandableResourceListAdapter
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
        /*todo is this needed here? or should it be in the ResultsActivity or should it be in ExpandableResourceListAdapter
        todo implement correctly
        Intent intent = new Intent(mContext,
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        mContext.startActivity(intent);
        */
    }

    /**
     * Depending on <code>groupPosition</code>, returns appropriate group's data
     * @param groupPosition options: ALASKA = 0 CALIFORNIA = 1 HAWAII = 2 OREGON = 3 WASHINGTON = 4
     */
    @Override
    public Object getGroup(int groupPosition) {
        switch (groupPosition) {
            case ALASKA:
                return mAlaskaData;

            case CALIFORNIA:
                return mCaliforniaData;

            case HAWAII:
                return mHawaiiData;

            case OREGON:
                return mOregonData;

            case WASHINGTON:
                return mWashingtionData;

            default:
                return null;

        }
    }

    /**
     * Returns the number of groups in <code>ExpandableListView</code>, 3 (Alaska, California,
     * Hawaii, Oregon, Washington)
     * @return the number of groups in <code>ExpandableListView</code>
     */
    @Override
    public int getGroupCount() {
        return 5;
    }

    /**
     * Inflates <code>R.layout.list_header</code>, set's <code>title</code>, and set's each group
     * header with the string associated with <code>title</code>.
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.resource_list_header, null, false);

        String title;
        switch (groupPosition) {
            case ALASKA:
                title = StateEnum.ALASKA.toStringName();
                break;

            case CALIFORNIA:
                title = StateEnum.CALIFORNIA.toStringName();
                break;

            case HAWAII:
                title = StateEnum.HAWAII.toStringName();
                break;

            case OREGON:
                title = StateEnum.OREGON.toStringName();
                break;

            case WASHINGTON:
                title = StateEnum.WASHINGTON.toStringName();
                break;

            default:
                title = "";
        }

        ((TextView) view.findViewById(R.id.header)).setText(title);

        return view;
    }

    @Override
    public boolean isEmpty() {
        return mAlaskaData.size()== 0 && mCaliforniaData.size() == 0 && mHawaiiData.size() == 0 &&
                mOregonData.size() == 0 && mWashingtionData.size() == 0;
    }
}
