package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.HomeFeed;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;

public class HomeFeedAdapter extends RecyclerView.Adapter<HomeFeedAdapter.ViewHolder> {

    private List<HomeFeed> list = new ArrayList<>();


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, ModelPins obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text_name;
        public TextView text_title;
        public ImageView photo;


        public ViewHolder(View v) {
            super(v);
            text_name = (TextView) v.findViewById(R.id.text_name);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_title = (TextView) v.findViewById(R.id.text_title);

        }

    }
    public HomeFeedAdapter(Context ctx, List<HomeFeed> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public HomeFeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}