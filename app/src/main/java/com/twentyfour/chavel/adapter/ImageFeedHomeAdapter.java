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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_feed_home, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String c = list.get(position);


        String url = "http://chavel.me/api/uploads/"+c.toString();
        String[] a = {"https://www.ilovetogo.com/FileUpload/Webboard/091225015340319.jpg","https://image.dek-d.com/24/651421/107696373","http://phuket.thai-sale.com/wp-content/uploads/2014/08/samui2.jpg?039e20?039e20","http://travel.mthai.com/app/uploads/2013/07/Ang-Thong-National-Marine-Park-view-point.jpg"};

        Log.e("url",url);

        Glide.with(ctx)
                .load(a[position]).override(100, 100)
                .centerCrop()
                .error(R.drawable.profile_photo)
                .into(holder.img_cover);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }


}