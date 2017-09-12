package com.twentyfour.chavel.activity.MainTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
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


    ImageView img_click;
    boolean check1 = false;


    ExpandableListAdapter expandableListAdapter;
    ArrayList<HomeFeed> list = new ArrayList<>();
    List<String> listString = new ArrayList<>();

    List<ExpandableListAdapter.Item> data = new ArrayList<>();

    LinearLayout ls_1;
    LinearLayout ls_2;
    View view_1;
    View view_2;


    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route, container, false);


        ls_1 = (LinearLayout) rootView.findViewById(R.id.ls_1);
        ls_2 = (LinearLayout) rootView.findViewById(R.id.ls_2);

        view_1 = (View) rootView.findViewById(R.id.view_1);
        view_2 = (View) rootView.findViewById(R.id.view_2);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);




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
                Toast.makeText(getActivity(), "Save", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(getActivity(), "Save", Toast.LENGTH_SHORT).show();


//                AddPinFragment addPinActivity = new AddPinFragment();
//                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container8, addPinActivity);
//                transaction.addToBackStack(null);
//                transaction.commit();


            }
        });

        view_1.setVisibility(View.GONE);
        view_2.setVisibility(View.VISIBLE);
        PinsFragment twoFragment = new PinsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment_container, twoFragment);
        transaction.commit();


        ls_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OverviewFragment twoFragment = new OverviewFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_fragment_container, twoFragment);
                transaction.commit();
                view_1.setVisibility(View.VISIBLE);
                view_2.setVisibility(View.GONE);

            }
        });

        ls_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_1.setVisibility(View.GONE);
                view_2.setVisibility(View.VISIBLE);
                PinsFragment twoFragment = new PinsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_fragment_container, twoFragment);
                transaction.commit();


            }
        });

        return rootView;
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
