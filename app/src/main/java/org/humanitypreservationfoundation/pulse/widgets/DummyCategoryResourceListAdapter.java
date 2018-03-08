package org.humanitypreservationfoundation.pulse.widgets;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.classes.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ETASpare on 3/8/2018.
 */

public class DummyCategoryResourceListAdapter extends ArrayAdapter<Resource> { //todo turn into CursorAdapter

    private Context mContext;

    public DummyCategoryResourceListAdapter(Context context, List<Resource> resources) { //todo might need to turn resources into ArrayList
        super(context, 0, resources);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Resource resource = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_list_item, parent, false);
        }

        TextView orgName = (TextView) convertView.findViewById(R.id.txt_org_name);
        TextView orgState = (TextView) convertView.findViewById(R.id.txt_org_state);
        Button orgWeb = (Button) convertView.findViewById(R.id.btn_org_web);
        Button orgCall = (Button) convertView.findViewById(R.id.btn_org_call);

        orgName.setText(resource.getName());
        orgState.setText(resource.getStateName());

        //orgWeb.setTag(position);
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



        return convertView;
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        this.mContext.startActivity(intent);
    }

    private void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        this.mContext.startActivity(intent);
    }
    //todo add openWebsite() and makeCall() look at ExpandableResourceListAdapter to see how
}
