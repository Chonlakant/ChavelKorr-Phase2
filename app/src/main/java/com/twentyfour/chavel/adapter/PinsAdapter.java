package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;

public class PinsAdapter extends RecyclerView.Adapter<PinsAdapter.ViewHolder> {

    private List<ModelPins> list = new ArrayList<>();


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

        public TextView txt_pins;
        public TextView txt_title_pins;
        public ImageView image;
        public RelativeLayout rl_image;
<<<<<<< HEAD
        public ImageView img_edit_pin;
        public ImageView img_delete_pin;
=======
>>>>>>> korrio/master

        public ViewHolder(View v) {
            super(v);
            img_edit_pin = (ImageView) v.findViewById(R.id.img_edit_pin);
            img_delete_pin = (ImageView) v.findViewById(R.id.img_delete_pin);
            txt_pins = (TextView) v.findViewById(R.id.txt_pins);
            txt_title_pins = (TextView) v.findViewById(R.id.txt_title_pins);
            rl_image = (RelativeLayout) v.findViewById(R.id.rl_image);
            txt_pins.setOnClickListener(this);
            rl_image.setOnClickListener(this);
<<<<<<< HEAD
            img_edit_pin.setOnClickListener(this);
            img_delete_pin.setOnClickListener(this);
=======
>>>>>>> korrio/master
        }

        @Override
        public void onClick(View v) {
<<<<<<< HEAD

            switch (v.getId()) {
                case R.id.img_edit_pin:
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, getPosition());
                    }
                    break;

                case R.id.img_delete_pin:
                    if (mOnItemClickImageListener != null) {
                        mOnItemClickImageListener.onItemClickImage(v, getPosition());
                    }
                    break;


=======

            switch (v.getId()) {
                case R.id.txt_pins:
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, getPosition());
                    }
                    break;

                case R.id.rl_image:
                    if (mOnItemClickImageListener != null) {
                        mOnItemClickImageListener.onItemClickImage(v, getPosition());
                    }
                    break;


>>>>>>> korrio/master

            }

        }
    }
    public PinsAdapter(Context ctx, List<ModelPins> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public PinsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pins, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelPins c = list.get(position);
        holder.txt_pins.setText(c.getPins());
        holder.txt_title_pins.setText(c.getTitlePins());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}