package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.DraftModel;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;

public class DratfAdapter extends RecyclerView.Adapter<DratfAdapter.ViewHolder> {

    private List<DraftModel> list = new ArrayList<>();


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    private OnItemClickImageListener mOnItemClickImageListener;

    public interface OnItemClickListener {
        void onItemClick(View viewj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public interface OnItemClickImageListener {
        void onItemClickImage(View viewj, int position);
    }

    public void setOnItemClickImageListener(final OnItemClickImageListener mOnItemClickImageListener) {
        this.mOnItemClickImageListener = mOnItemClickImageListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image_cover;
        ImageView image_map;

        public ViewHolder(View v) {
            super(v);

            image_cover = (ImageView) v.findViewById(R.id.image_cover);
            image_map = (ImageView) v.findViewById(R.id.image_map);

        }

        @Override
        public void onClick(View v) {

//            switch (v.getId()) {
//                case R.id.txt_pins:
//                    if (mOnItemClickListener != null) {
//                        mOnItemClickListener.onItemClick(v, getPosition());
//                    }
//                    break;
//
//                case R.id.rl_image:
//                    if (mOnItemClickImageListener != null) {
//                        mOnItemClickImageListener.onItemClickImage(v, getPosition());
//                    }
//                    break;
//
//
//
//            }

        }
    }

    public DratfAdapter(Context ctx, List<DraftModel> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public DratfAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_draft, parent, false);

        ViewHolder vh = new ViewHolder(v);



        Glide.with(ctx)
                .load("https://4.bp.blogspot.com/-nVpNaFD3uO0/WAIGO_s-SzI/AAAAAAAANZg/mA-LdqbA-fYC4wpG-HrVBneD87hoXVTrwCLcB/s640/20160719162112655956.jpg")
                .into(vh.image_cover);

        Glide.with(ctx)
                .load("https://www.expat-dakar.com/modAnnonces/images/annonces/max_google-map_59075b10a5d9d.png")
                .into(vh.image_map);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final DraftModel c = list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}