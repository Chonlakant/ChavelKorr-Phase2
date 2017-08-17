package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.ViewHolder> {

    private List<ModelPins> list = new ArrayList<>();


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txt_pins;
        public TextView txt_title_pins;
        public ImageView image;
        public LinearLayout ls_image;


        public ViewHolder(View v) {
            super(v);
            txt_pins = (TextView) v.findViewById(R.id.txt_pins);
            txt_title_pins = (TextView) v.findViewById(R.id.txt_title_pins);
            ls_image = (LinearLayout) v.findViewById(R.id.ls_image);
            ls_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ls_image:
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, getPosition());
                    }
                    break;

            }
        }
    }

    public OverviewAdapter(Context ctx, List<ModelPins> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public OverviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orverview, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ModelPins c = list.get(position);
        holder.txt_pins.setText(c.getPins());
        holder.txt_title_pins.setText(c.getTitlePins());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}