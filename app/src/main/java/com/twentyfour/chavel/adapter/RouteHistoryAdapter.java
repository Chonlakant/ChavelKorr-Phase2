package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.ModelActivityProfile;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RouteHistoryAdapter extends RecyclerView.Adapter<RouteHistoryAdapter.ViewHolder> {

    private List<ModelActivityProfile> list = new ArrayList<>();

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
        public TextView txt_content;
        public TextView txt_time;
        public CircleImageView photo;


        public ViewHolder(View v) {
            super(v);
            text_name = (TextView) v.findViewById(R.id.text_name);
        //    txt_content = (TextView) v.findViewById(R.id.txt_content);
            txt_time = (TextView) v.findViewById(R.id.text_time);
            photo = (CircleImageView) v.findViewById(R.id.photo);

        }

    }

    public RouteHistoryAdapter(Context ctx, List<ModelActivityProfile> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @Override
    public RouteHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route_history, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelActivityProfile c = list.get(position);
        holder.text_name.setText(c.getTitle());
        //  holder.txt_content.setText(c.getContent());
        holder.txt_time.setText(c.getTime());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}