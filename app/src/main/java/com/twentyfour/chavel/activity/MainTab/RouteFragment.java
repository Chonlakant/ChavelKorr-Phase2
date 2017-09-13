package com.twentyfour.chavel.activity.MainTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;
import com.twentyfour.chavel.BusProvider.BusProvider;
import com.twentyfour.chavel.Event.Events;
import com.twentyfour.chavel.Event.Events_Route_Period;
import com.twentyfour.chavel.Event.Events_State_Menu;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.ProfileFragment;
import com.twentyfour.chavel.activity.SelectOverViewPinsActivity;
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
    public static final String KEY_MESSAGE = "message";

    Toolbar toolbar;
    Button btn_locaion_map;

    LinearLayout fragment_map;
    LinearLayout fragment_container3;
    LinearLayout ls_save_lin;
    LinearLayout ls_locaion_map;
    LinearLayout ls_feed;


    Button ls_save;


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
    View view_border1;
    View view_border2;

    String key1;
    String key2;

    public static RouteFragment newInstance(String message) {
        RouteFragment fragment = new RouteFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, message);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getBus().register(this);
        setRetainInstance(true);


        Bundle bundle = getArguments();
        if (bundle != null) {
            key1 = bundle.getString(KEY_MESSAGE);
        }

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route, container, false);

        ls_1 = (LinearLayout) rootView.findViewById(R.id.ls_1);
        ls_2 = (LinearLayout) rootView.findViewById(R.id.ls_2);

        view_1 = (View) rootView.findViewById(R.id.view_1);
        view_2 = (View) rootView.findViewById(R.id.view_2);

        view_border1 = (View) rootView.findViewById(R.id.view_border1);
        view_border2 = (View) rootView.findViewById(R.id.view_border2);

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

        toolbar.inflateMenu(R.menu.menu_main);
       // toolbar.inflateMenu(R.menu.menu_over_map);






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

        view_border1.setVisibility(View.VISIBLE);
        view_border2.setVisibility(View.GONE);
        view_1.setVisibility(View.GONE);
        view_2.setVisibility(View.VISIBLE);
        PinsFragment twoFragment = new PinsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment_container, twoFragment);
        transaction.commit();


        ls_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), SelectOverViewPinsActivity.class);
                startActivity(i);

//                OverviewFragment twoFragment = new OverviewFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.layout_fragment_container, twoFragment);
//                transaction.commit();
                view_1.setVisibility(View.VISIBLE);
                view_2.setVisibility(View.GONE);
                view_border2.setVisibility(View.VISIBLE);
                view_border1.setVisibility(View.GONE);

            }
        });


        ls_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_border1.setVisibility(View.VISIBLE);
                view_border2.setVisibility(View.GONE);
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


    @Subscribe
    public void getMessage(Events.ActivityFragmentMessage activityFragmentMessage) {

    }


    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getBus().unregister(this);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //TODO Add your menu entries here
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_location:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void getRoteState(Events_State_Menu.Events_StateMenuFragmentMessage texts) {
        if (texts.getMessage() != "") {
            key2 = texts.getMessage();

            Log.e("key2",key2);
        }

    }

}
