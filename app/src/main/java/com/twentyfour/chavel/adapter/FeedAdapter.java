package com.twentyfour.chavel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;
import java.util.List;


public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    FeedImageAdapter feedImageAdapter;
    Context context;

    private List<Item> data;
    private List<String> listStr = new ArrayList<>();

    public static OnItemClickLikeListener mOnItemClickLikeListener;
    public static OnItemClickShListener mOnItemClickShListener;
    public static OnItemClickCommentListener mOnItemClickCommentListener;
    public static OnItemClickPhotoListener mOnItemClickPhotoListener;
    public static OnItemClickUsernameListener mOnItemClickUsernameListener;
    public static OnItemClickRouteTitleListener mOnItemClickRouteTitleListener;
<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/adapter/ExpandableListAdapter.java



    public interface OnItemClickLikeListener {
        void onItemLikeClick(View view, int position);
    }

    public void setOnItemClickLikeListener(final OnItemClickLikeListener mItemClickLikeListener) {
        this.mOnItemClickLikeListener = mItemClickLikeListener;
    }

    public interface OnItemClickShListener {
        void onItemShClick(View view, int position);
    }

    public void setOnItemClickShListener(final OnItemClickShListener mItemClickShListener) {
        this.mOnItemClickShListener = mItemClickShListener;
    }

    public interface OnItemClickCommentListener {
        void onItemCommentClick(View view, int position);
    }

    public void setOnItemClickCommentListener(final OnItemClickCommentListener mOnItemClickCommentListener) {
        this.mOnItemClickCommentListener = mOnItemClickCommentListener;
    }


    public interface OnItemClickPhotoListener {
        void onItemPhotoClick(View view, int position);
    }

    public void setOnItemClickPhotoListener(final OnItemClickPhotoListener mOnItemClickPhotoListener) {
        this.mOnItemClickPhotoListener = mOnItemClickPhotoListener;
    }

    public interface OnItemClickUsernameListener {
        void onItemUsernameClick(View view, int position);
    }

    public void setOnItemClickUsernameListener(final OnItemClickUsernameListener mOnItemClickUsernameListener) {
        this.mOnItemClickUsernameListener = mOnItemClickUsernameListener;
    }

    public interface OnItemClickRouteTitleListener {
        void onItemRouteTitleClick(View view, int position);
    }

    public void setOnItemClickRouteTitleListener(final OnItemClickRouteTitleListener mOnItemClickRouteTitleListener) {
        this.mOnItemClickRouteTitleListener = mOnItemClickRouteTitleListener;
    }

=======
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/adapter/FeedAdapter.java

    public interface OnItemClickLikeListener {
        void onItemLikeClick(View view, int position);
    }

    public void setOnItemClickLikeListener(final OnItemClickLikeListener mItemClickLikeListener) {
        this.mOnItemClickLikeListener = mItemClickLikeListener;
    }

    public interface OnItemClickShListener {
        void onItemShClick(View view, int position);
    }

    public void setOnItemClickShListener(final OnItemClickShListener mItemClickShListener) {
        this.mOnItemClickShListener = mItemClickShListener;
    }

    public interface OnItemClickCommentListener {
        void onItemCommentClick(View view, int position);
    }

    public void setOnItemClickCommentListener(final OnItemClickCommentListener mOnItemClickCommentListener) {
        this.mOnItemClickCommentListener = mOnItemClickCommentListener;
    }


    public interface OnItemClickPhotoListener {
        void onItemPhotoClick(View view, int position);
    }

    public void setOnItemClickPhotoListener(final OnItemClickPhotoListener mOnItemClickPhotoListener) {
        this.mOnItemClickPhotoListener = mOnItemClickPhotoListener;
    }

    public interface OnItemClickUsernameListener {
        void onItemUsernameClick(View view, int position);
    }

    public void setOnItemClickUsernameListener(final OnItemClickUsernameListener mOnItemClickUsernameListener) {
        this.mOnItemClickUsernameListener = mOnItemClickUsernameListener;
    }

    public interface OnItemClickRouteTitleListener {
        void onItemRouteTitleClick(View view, int position);
    }

    public void setOnItemClickRouteTitleListener(final OnItemClickRouteTitleListener mOnItemClickRouteTitleListener) {
        this.mOnItemClickRouteTitleListener = mOnItemClickRouteTitleListener;
    }



    public FeedAdapter(List<Item> data, Context context) {
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
                view = inflater2.inflate(R.layout.list_item, parent, false);
                ListContentViewHolder content = new ListContentViewHolder(view);
                return content;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindHolder(holder,position);
    }

    public void onBindHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position);
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                itemController.header_title.setText(item.text);
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.ic_down);
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
                            itemController.btn_expand_toggle.setImageResource(R.drawable.ic_down);
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

<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/adapter/ExpandableListAdapter.java


=======
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/adapter/FeedAdapter.java
                break;
            case CHILD:
                position = (position + 1) / 2;
                ListContentViewHolder itemContent = (ListContentViewHolder) holder;
                //itemContent.text_create.setText("Create " + data.get(position).text);
                //itemContent.txt_catgory.setText("Category " + data.get(position).diffDate);
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
<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/adapter/ExpandableListAdapter.java
                imageFeedHomeAdapter = new ImageFeedHomeAdapter(context, listStr);
=======
                feedImageAdapter = new FeedImageAdapter(context, listStr);
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/adapter/FeedAdapter.java
                //}

                itemContent.ryc.setAdapter(feedImageAdapter);


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

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView header_title;
        public Item refferalItem;
        public ImageView btn_expand_toggle;
        public ImageView img_comments;
        public ImageView img_like;
        public ImageView img_sh;
        public ImageView photo;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            img_comments = (ImageView) itemView.findViewById(R.id.img_comments);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            img_like = (ImageView) itemView.findViewById(R.id.img_like);
            img_sh = (ImageView) itemView.findViewById(R.id.img_sh);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);

            img_like.setOnClickListener(this);
            img_comments.setOnClickListener(this);
            img_sh.setOnClickListener(this);
            photo.setOnClickListener(this);
            header_title.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img_like:
                    if (mOnItemClickLikeListener != null) {
                        mOnItemClickLikeListener.onItemLikeClick(v, getPosition());
                    }
                    break;

                case R.id.img_comments:
                    if (mOnItemClickCommentListener != null) {
                        mOnItemClickCommentListener.onItemCommentClick(v, getPosition());
                    }
                    break;

                case R.id.img_sh:
                    if (mOnItemClickShListener != null) {
                        mOnItemClickShListener.onItemShClick(v, getPosition());
                    }
                    break;
                case R.id.photo:
                    if (mOnItemClickPhotoListener != null) {
                        mOnItemClickPhotoListener.onItemPhotoClick(v, getPosition());
                    }
                    break;

                case R.id.header_title:
                    if (mOnItemClickRouteTitleListener != null) {
                        mOnItemClickRouteTitleListener.onItemRouteTitleClick(v, getPosition());
                    }
                    break;


            }
        }
    }

    private static class ListContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            txt_by_username.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.txt_by_username:
                    if (mOnItemClickUsernameListener != null) {
                        mOnItemClickUsernameListener.onItemUsernameClick(v, getPosition());
                    }
                    break;

            }
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