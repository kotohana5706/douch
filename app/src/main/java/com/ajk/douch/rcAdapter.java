package com.ajk.douch;

import android.app.WallpaperManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by ahnju on 2016-09-14.
 */
public class rcAdapter extends RecyclerView.Adapter<rcAdapter.ViewHolder> {

    public ArrayList<mData> datas;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public TextView groupText;
        public TextView startText;
        public TextView endText;
        public ViewHolder(View v){
            super(v);
            nameText = (TextView)v.findViewById(R.id.rDate);
            groupText = (TextView)v.findViewById(R.id.rName);
            startText = (TextView)v.findViewById(R.id.starttime);
            endText = (TextView)v.findViewById(R.id.endtime);
        }
    }

    public rcAdapter(ArrayList<mData> mDataset){
        datas = mDataset;
    }

    @Override
    public rcAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cardview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int pos){
        viewHolder.nameText.setText(datas.get(pos).name);
        viewHolder.groupText.setText(datas.get(pos).groupName);
        viewHolder.startText.setText(datas.get(pos).startTime);
        viewHolder.endText.setText(datas.get(pos).endTime);
    }

    @Override
    public int getItemCount(){
        return datas.size();
    }

}

class mData{
    public String name;
    public String startTime;
    public String endTime;
    public String groupName;
    public mData(String name, String startTime, String endTime, String groupName){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.groupName = groupName;
    }
}
