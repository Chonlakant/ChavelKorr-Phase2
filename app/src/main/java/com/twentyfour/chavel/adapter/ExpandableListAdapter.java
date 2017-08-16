package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twentyfour.chavel.R;

import java.util.ArrayList;
import java.util.List;


public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private List<Item> data;

    public ExpandableListAdapter(List<Item> data) {
        this.data = data;
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
                break;
            case CHILD:
                 ListContentViewHolder itemContent = (ListContentViewHolder) holder;

                itemContent.text_create.setText(data.get(position).text);
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
        public ImageView btn_expand_toggle;
        public Item refferalItem;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }

    private static class ListContentViewHolder extends RecyclerView.ViewHolder {
        public TextView text_create;


        public ListContentViewHolder(View itemView) {
            super(itemView);
            text_create = (TextView) itemView.findViewById(R.id.text_create);
        }
    }

    public static class Item {
        public int type;
        public String text;
        private String user_id;
        private String user_name;
        private String user_image;
        private String route_id;
        private String route_title;
        private String route_detail;
        private String diffDate;
        private String like_status;
        private String favorite_status;
        private String route_activity;
        private String route_city;
        private String route_travel_method;
        private String route_budgetmin;
        private String route_budgetmax;
        private String route_suggestion;

        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type, String text, String user_id, String user_name, String user_image, String route_id, String route_title, String route_detail, String diffDate, String like_status, String favorite_status, String route_activity, String route_city, String route_travel_method, String route_budgetmin, String route_budgetmax, String route_suggestion) {
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
        }
    }

}
