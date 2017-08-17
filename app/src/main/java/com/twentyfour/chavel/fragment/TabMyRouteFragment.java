package com.twentyfour.chavel.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.ProfileActivity;
import com.twentyfour.chavel.activity.MainTab.CommentActivity;
import com.twentyfour.chavel.activity.MainTab.LocationActivity;
import com.twentyfour.chavel.activity.MainTab.RouteActivity;
import com.twentyfour.chavel.activity.MainTab.RouteHomeActivity;
import com.twentyfour.chavel.adapter.ExpandableListAdapter;
import com.twentyfour.chavel.adapter.HomeFeedAdapter;
import com.twentyfour.chavel.api.Apis;
import com.twentyfour.chavel.model.HomeFeed;
import com.twentyfour.chavel.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabMyRouteFragment extends Fragment {

    RecyclerView ryc;
    HomeFeedAdapter homeFeedAdapter;
    ExpandableListAdapter expandableListAdapter;
    ArrayList<HomeFeed> list = new ArrayList<>();
    List<String> listString = new ArrayList<>();

    List<ExpandableListAdapter.Item> data = new ArrayList<>();

    Dialog dialogShare;

    TextView txt_route;
    TextView txt_share_follower;
    TextView txt_share_person;
    TextView txt_share_public;
    TextView txt_share_others;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_home, null);
        setHasOptionsMenu(true);
        ryc = (RecyclerView) view.findViewById(R.id.ryc);
        ryc.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ryc.setLayoutManager(llm);

        dialogShare = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialogShare.setContentView(R.layout.dialog_share);

        txt_route = (TextView) dialogShare.findViewById(R.id.txt_route);
        txt_share_follower = (TextView) dialogShare.findViewById(R.id.txt_share_follower);
        txt_share_person = (TextView) dialogShare.findViewById(R.id.txt_share_person);
        txt_share_public = (TextView) dialogShare.findViewById(R.id.txt_share_public);
        txt_share_others = (TextView) dialogShare.findViewById(R.id.txt_share_others);


        getHomeFeed("2", "30", "100");

        return view;
    }


    private void getHomeFeed(final String user_id, String lat, String lng) {

        ServiceApi service = Apis.getClient().create(ServiceApi.class);

        Call<HomeFeed> userCall = service.getFeedHome(user_id, lat, lng);

        userCall.enqueue(new Callback<HomeFeed>() {
            @Override
            public void onResponse(Call<HomeFeed> call, Response<HomeFeed> response) {

                if (response.body().getList() != null) {
                    for (int i = 0; i < response.body().getList().size(); i++) {
                        list.add(response.body());
                        String header = response.body().getList().get(i).getRoute_title();
                        String child = response.body().getList().get(i).getDiffDate();
                        String user_id = response.body().getList().get(i).getUser_id();
                        String user_name = response.body().getList().get(i).getUser_name();
                        String user_image = response.body().getList().get(i).getUser_image();
                        String route_id = response.body().getList().get(i).getRoute_id();
                        String route_title = response.body().getList().get(i).getRoute_title();
                        String route_detail = response.body().getList().get(i).getRoute_detail();
                        String diffDate = response.body().getList().get(i).getDiffDate();
                        String like_status = response.body().getList().get(i).getLike_status();
                        String favorite_status = response.body().getList().get(i).getFavorite_status();
                        String route_activity = response.body().getList().get(i).getRoute_activity();
                        String route_city = response.body().getList().get(i).getRoute_city();
                        String route_travel_method = response.body().getList().get(i).getRoute_travel_method();
                        String route_budgetmin = response.body().getList().get(i).getRoute_budgetmin();
                        String route_budgetmax = response.body().getList().get(i).getRoute_budgetmax();
                        String route_suggestion = response.body().getList().get(i).getRoute_suggestion();

                        for(int j=0;j < response.body().getList().get(i).getRoute_img().size();j++){
                            Log.e("accc",response.body().getList().get(i).getRoute_img().get(j).getImg_text()+"");
                            //if(j < 4)
                                listString.add(response.body().getList().get(i).getRoute_img().get(j).getImg_text());
                        }

                        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, header, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",listString));
                        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, child, user_id, user_name, user_image
                                , route_id, route_title, route_detail, diffDate, like_status, favorite_status, route_activity, route_city,
                                route_travel_method, route_budgetmin, route_budgetmax, route_suggestion,listString));

                        expandableListAdapter = new ExpandableListAdapter(data,getActivity());
                        ryc.setAdapter(expandableListAdapter);
                        expandableListAdapter.setOnItemClickCommentListener(new ExpandableListAdapter.OnItemClickCommentListener() {
                            @Override
                            public void onItemCommentClick(View view, int position) {

                                Intent i = new Intent(getActivity(), CommentActivity.class);
                                startActivity(i);
                            }
                        });

                        expandableListAdapter.setOnItemClickLikeListener(new ExpandableListAdapter.OnItemClickLikeListener() {
                            @Override
                            public void onItemLikeClick(View view, int position) {

                                Toast.makeText(getActivity(),"Love this post",Toast.LENGTH_SHORT).show();

                            }
                        });
                        expandableListAdapter.setOnItemClickShListener(new ExpandableListAdapter.OnItemClickShListener() {
                            @Override
                            public void onItemShClick(View view, int position) {


                                dialogShare.show();

                                txt_route.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialogShare.dismiss();
                                    }
                                });

                                txt_share_follower.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialogShare.dismiss();
                                    }
                                });

                                txt_share_person.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialogShare.dismiss();
                                    }
                                });

                                txt_share_public.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialogShare.dismiss();
                                    }
                                });

                                txt_share_others.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialogShare.dismiss();
                                    }
                                });



                            }
                        });

                        expandableListAdapter.setOnItemClickPhotoListener(new ExpandableListAdapter.OnItemClickPhotoListener() {
                            @Override
                            public void onItemPhotoClick(View view, int position) {
                                Intent i =new Intent(getActivity(), ProfileActivity.class);
                                startActivity(i);
                            }
                        });
                        expandableListAdapter.setOnItemClickUsernameListener(new ExpandableListAdapter.OnItemClickUsernameListener() {
                            @Override
                            public void onItemUsernameClick(View view, int position) {
                                Intent i =new Intent(getActivity(), ProfileActivity.class);
                                startActivity(i);
                            }
                        });

                        expandableListAdapter.setOnItemClickRouteTitleListener(new ExpandableListAdapter.OnItemClickRouteTitleListener() {
                            @Override
                            public void onItemRouteTitleClick(View view, int position) {
                                Intent i =new Intent(getActivity(), RouteHomeActivity.class);
                                startActivity(i);
                            }
                        });
                        //listString.clear();
                    }

                }

            }

            @Override
            public void onFailure(Call<HomeFeed> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_fragment_home, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
////            case R.id.action_new_friend:
////                Snackbar.make(view, item.getTitle() + " Clicked", Snackbar.LENGTH_SHORT).show();
////                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
