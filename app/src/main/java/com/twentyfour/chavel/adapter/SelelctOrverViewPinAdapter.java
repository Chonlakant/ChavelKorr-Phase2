package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;
import java.util.List;

public class SelelctOrverViewPinAdapter extends RecyclerView.Adapter<SelelctOrverViewPinAdapter.ViewHolder> {

    private List<Search> list = new ArrayList<>();


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Search obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout ls_view;
        public CheckBox check;


        public ViewHolder(View v) {
            super(v);
            ls_view = (RelativeLayout) v.findViewById(R.id.ls_view);
            check = (CheckBox) v.findViewById(R.id.check);
        }

    }

    public SelelctOrverViewPinAdapter(Context ctx, List<Search> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public SelelctOrverViewPinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_over_view, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Search c = list.get(position);


//        Glide.with(ctx)
//                .load(c.getImageUrl())
//                .into(holder.img_cover);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}