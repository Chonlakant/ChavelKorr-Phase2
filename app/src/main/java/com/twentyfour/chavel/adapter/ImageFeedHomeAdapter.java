package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;

public class ImageFeedHomeAdapter extends RecyclerView.Adapter<ImageFeedHomeAdapter.ViewHolder> {

    private List<String> list = new ArrayList<>();


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, ModelPins obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_cover;


        public ViewHolder(View v) {
            super(v);
            img_cover = (ImageView) v.findViewById(R.id.img_cover);


        }

    }
    public ImageFeedHomeAdapter(Context ctx, List<String> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public ImageFeedHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_feed_home, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String c = list.get(position);


        String url = "http://chavel.me/api/uploads/"+c.toString();

        Log.e("url",url);

//                Glide.with(ctx)
//                .load(url)
//                .into(holder.img_cover);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}