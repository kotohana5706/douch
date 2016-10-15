package com.ajk.douch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahnju on 2016-10-15.
 */
public class GroupListViewAdapter extends ArrayAdapter<Group> {

    private LayoutInflater layoutInflater;
    public GroupListViewAdapter(Context context, ArrayList<Group> object){
        super(context, 0, object);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int pos, View v, ViewGroup parent){
        View view =null;
        if (v == null){
            view = layoutInflater.inflate(R.layout.group_content, null);
        }else{
            view = v;
        }
        final Group group = this.getItem(pos);
        if(group !=null){
            TextView groupName = (TextView) view.findViewById(R.id.groupName);
            groupName.setText(group.name);
        }
    return view;
    }


}
