package com.ajk.douch;

import android.support.v7.widget.RecyclerView;
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

    private ArrayList<rcData> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public ImageView mImage;

        public ViewHolder(View v){
            super(v);
            nameText = (TextView)v.findViewById(R.id.rName);
            mImage = (ImageView)v.findViewById(R.id.rImage);
        }
    }

    public rcAdapter(ArrayList<rcData> rcDataset){
        mDataset = rcDataset;
    }

    @Override
    public rcAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameText.setText(mDataset.get(position).text);
        holder.mImage.setImageResource(mDataset.get(position).img);

    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }

}
class rcData{
    public String text;
    public int img;
    public rcData(String text, int img){
        this.text = text;
        this.img = img;
    }
}