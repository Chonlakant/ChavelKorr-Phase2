package com.twentyfour.chavel.activity.MainTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.ProfileFragment;
import com.twentyfour.chavel.adapter.ExpandableListAdapter;
import com.twentyfour.chavel.api.Apis;
import com.twentyfour.chavel.fragment.OverviewFragment;
import com.twentyfour.chavel.fragment.PinsFragment;
import com.twentyfour.chavel.model.HomeFeed;
import com.twentyfour.chavel.service.ServiceApi;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RouteFragment extends Fragment {

    private ExpandableLayout expandableLayout0;

    Toolbar toolbar;
    Button btn_locaion_map;

    LinearLayout fragment_map;
    LinearLayout fragment_container3;
    LinearLayout ls_save_lin;
    LinearLayout ls_locaion_map;
    LinearLayout ls_feed;
    LinearLayout ls_view_pager;

    Button ls_save;

    RecyclerView ryc;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    ImageView img_click;
    boolean check1 = false;


    ExpandableListAdapter expandableListAdapter;
    ArrayList<HomeFeed> list = new ArrayList<>();
    List<String> listString = new ArrayList<>();

    List<ExpandableListAdapter.Item> data = new ArrayList<>();


    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route, container, false);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        ryc = (RecyclerView) rootView.findViewById(R.id.ryc);
        ryc.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ryc.setLayoutManager(llm);


        ls_feed = (LinearLayout) rootView.findViewById(R.id.ls_feed);
        btn_locaion_map = (Button) rootView.findViewById(R.id.btn_locaion_map);
        ls_save_lin = (LinearLayout) rootView.findViewById(R.id.ls_save_lin);
        ls_locaion_map = (LinearLayout) rootView.findViewById(R.id.ls_locaion_map);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        fragment_map = (LinearLayout) rootView.findViewById(R.id.fragment_map);
        fragment_container3 = (LinearLayout) rootView.findViewById(R.id.fragment_container3);
        ls_save = (Button) rootView.findViewById(R.id.ls_save);

        toolbar.setTitle("Route");

        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        img_click = (ImageView) rootView.findViewById(R.id.img_click);
        expandableLayout0 = (ExpandableLayout) rootView.findViewById(R.id.expandable_layout_0);


//        toolbar.setTitle("Route");
//        getActionBar()setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });


        btn_locaion_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        ls_locaion_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPinFragment addPinActivity = new AddPinFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_2, addPinActivity);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ls_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i =new Intent(getActivity(),AddPinFragment.class);
//                startActivity(i);

//                AddPinFragment addPinActivity = new AddPinFragment();
//                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container8, addPinActivity);
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });


        img_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableLayout0.isExpanded()) {
                    expandableLayout0.collapse();
                    img_click.setImageResource(R.drawable.down_icon);
                    ls_feed.setVisibility(View.VISIBLE);


                } else {
                    expandableLayout0.expand();
                    img_click.setImageResource(R.drawable.up_icon);
                    ls_feed.setVisibility(View.GONE);

                }
            }
        });



        ls_save_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i =new Intent(getActivity(),AddPinFragment.class);
//                startActivity(i);


                AddPinFragment addPinActivity = new AddPinFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container8, addPinActivity);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        getHomeFeed("2", "30", "100");
        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new OverviewFragment(), "OVERVIEW");
        adapter.addFragment(new PinsFragment(), "PINS");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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

                        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, header, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", listString));
                        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, child, user_id, user_name, user_image
                                , route_id, route_title, route_detail, diffDate, like_status, favorite_status, route_activity, route_city,
                                route_travel_method, route_budgetmin, route_budgetmax, route_suggestion, listString));

                        expandableListAdapter = new ExpandableListAdapter(data, getActivity());
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

                                Toast.makeText(getActivity(), "Love this post", Toast.LENGTH_SHORT).show();

                            }
                        });


                    }

                }

            }

            @Override
            public void onFailure(Call<HomeFeed> call, Throwable t) {

            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        return super.onOptionsItemSelected(item);
//    }


}
