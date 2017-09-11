package com.twentyfour.chavel.activity.MainTab;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.ProfileFragment;
import com.twentyfour.chavel.adapter.ExpandableHomeFeedAdapter;
import com.twentyfour.chavel.adapter.ExpandableSingleAdapter;
import com.twentyfour.chavel.api.Apis;
import com.twentyfour.chavel.model.HomeFeed;
import com.twentyfour.chavel.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MySigleRouteFragment extends Fragment {

    RecyclerView ryc;
    ExpandableSingleAdapter expandableListAdapter;

    ArrayList<HomeFeed> list = new ArrayList<>();
    List<String> listString = new ArrayList<>();

    List<ExpandableHomeFeedAdapter.Item> data = new ArrayList<>();

    Dialog dialogShare;

    TextView txt_route;
    TextView txt_share_follower;
    TextView txt_share_person;
    TextView txt_share_public;
    TextView txt_share_others;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_home2, null);
//        toolbar.setTitle("Chavel");
        // setSupportActionBar(toolbar);
     //   toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
       // toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
//        toolbar.setNavigationIcon(R.drawable.ic_back);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

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

                        for (int j = 0; j < response.body().getList().get(i).getRoute_img().size(); j++) {
                            Log.e("accc", response.body().getList().get(i).getRoute_img().get(j).getImg_text() + "");
                            //if(j < 4)
                            listString.add(response.body().getList().get(i).getRoute_img().get(j).getImg_text());
                        }

                        data.add(new ExpandableHomeFeedAdapter.Item(ExpandableHomeFeedAdapter.HEADER, header, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", listString));
                        data.add(new ExpandableHomeFeedAdapter.Item(ExpandableHomeFeedAdapter.CHILD, child, user_id, user_name, user_image
                                , route_id, route_title, route_detail, diffDate, like_status, favorite_status, route_activity, route_city,
                                route_travel_method, route_budgetmin, route_budgetmax, route_suggestion, listString));


                        ryc.setAdapter(expandableListAdapter);




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
