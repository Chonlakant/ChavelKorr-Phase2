package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.CommentActivity;

import java.util.ArrayList;
import java.util.List;


public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    ImageFeedHomeAdapter imageFeedHomeAdapter;
    Context context;

    private List<Item> data;
    private List<String> listStr = new ArrayList<>();


    public ExpandableListAdapter(List<Item> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopAndBottom = (int) (5 * dp);
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflater2 = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater2.inflate(R.layout.item_home, parent, false);
                ListContentViewHolder content = new ListContentViewHolder(view);
                return content;

        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position);
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                itemController.header_title.setText(item.text);
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.down_icon);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.ic_up);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.down_icon);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.ic_up);
                            item.invisibleChildren = null;
                        }
                    }
                });

                itemController.img_comments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, CommentActivity.class);
                        context.startActivity(i);
                    }
                });
                break;
            case CHILD:
                position = (position + 1) / 2;
                ListContentViewHolder itemContent = (ListContentViewHolder) holder;
                itemContent.text_create.setText("Create " + data.get(position).text);
                itemContent.txt_catgory.setText("Category " + data.get(position).diffDate);
                itemContent.txt_by_username.setText(data.get(position).user_name);
                itemContent.txt_msg.setText(data.get(position).route_detail);

                itemContent.ryc.setLayoutManager(new GridLayoutManager(context, 2));
                itemContent.ryc.setHasFixedSize(true);
                itemContent.ryc.setItemAnimator(new DefaultItemAnimator());

                listStr = new ArrayList<>();
                //if(data.get(position) != null && data.get(position).list != null) {
//                    for(int i = 0 ; i < data.get(position).list.size() ; i++)
//                        listStr.add(data.get(position).list.get(i).toString());
                listStr.add("");
                listStr.add("");
                listStr.add("");
                listStr.add("");
                imageFeedHomeAdapter = new ImageFeedHomeAdapter(context, listStr);
                //}

                itemContent.ryc.setAdapter(imageFeedHomeAdapter);
//                Log.e("image",data.get(position).list.get(position).toString());


                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public Item refferalItem;
        public ImageView btn_expand_toggle;
        public ImageView img_comments;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            img_comments = (ImageView) itemView.findViewById(R.id.img_comments);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }

    private static class ListContentViewHolder extends RecyclerView.ViewHolder {
        public TextView text_create;
        public TextView txt_catgory;
        public TextView txt_by_username;
        public TextView txt_msg;
        public RecyclerView ryc;


        public ListContentViewHolder(View itemView) {
            super(itemView);
            text_create = (TextView) itemView.findViewById(R.id.text_create);
            txt_catgory = (TextView) itemView.findViewById(R.id.txt_catgory);
            txt_by_username = (TextView) itemView.findViewById(R.id.txt_by_username);
            txt_msg = (TextView) itemView.findViewById(R.id.txt_msg);
            ryc = (RecyclerView) itemView.findViewById(R.id.ryc);
        }
    }

    public static class Item {
        public int type;
        public String text;
        public String user_id;
        public String user_name;
        public String user_image;
        public String route_id;
        public String route_title;
        public String route_detail;
        public String diffDate;
        public String like_status;
        public String favorite_status;
        public String route_activity;
        public String route_city;
        public String route_travel_method;
        public String route_budgetmin;
        public String route_budgetmax;
        public String route_suggestion;

        public List<Item> invisibleChildren;
        public List<String> list = new ArrayList<>();

        public Item() {
        }

        public Item(int type, String text, String user_id, String user_name, String user_image, String route_id, String route_title, String route_detail, String diffDate, String like_status, String favorite_status, String route_activity, String route_city, String route_travel_method, String route_budgetmin, String route_budgetmax, String route_suggestion, List<String> list) {
            this.type = type;
            this.text = text;
            this.user_id = user_id;
            this.user_name = user_name;
            this.user_image = user_image;
            this.route_id = route_id;
            this.route_title = route_title;
            this.route_detail = route_detail;
            this.diffDate = diffDate;
            this.like_status = like_status;
            this.favorite_status = favorite_status;
            this.route_activity = route_activity;
            this.route_city = route_city;
            this.route_travel_method = route_travel_method;
            this.route_budgetmin = route_budgetmin;
            this.route_budgetmax = route_budgetmax;
            this.route_suggestion = route_suggestion;
            this.list = list;
        }
    }

}
