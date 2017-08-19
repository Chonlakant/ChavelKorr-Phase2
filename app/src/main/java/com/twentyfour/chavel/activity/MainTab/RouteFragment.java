package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.fragment.OverviewFragment;
import com.twentyfour.chavel.fragment.PinsFragment;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;
import java.util.List;


public class RouteFragment extends Fragment  {

    private ExpandableLayout expandableLayout0;

    Toolbar toolbar;
    Button btn_locaion_map;

    LinearLayout fragment_map;
    LinearLayout fragment_container3;
    LinearLayout ls_save_lin;
    LinearLayout ls_locaion_map;

    Button ls_save;


    private TabLayout tabLayout;
    private ViewPager viewPager;

    ImageView img_click;


    public static RouteFragment newInstance() {
        return new RouteFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route, container, false);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);


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

                fragment_map.setVisibility(View.VISIBLE);
                fragment_container3.setVisibility(View.GONE);

            }
        });

        ls_locaion_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_map.setVisibility(View.VISIBLE);
                fragment_container3.setVisibility(View.GONE);
            }
        });

        ls_save.setOnClickListener(new View.OnClickListener() {
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


        img_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableLayout0.isExpanded()) {
                    expandableLayout0.collapse();
                    img_click.setImageResource(R.drawable.down_icon);
                } else {
                    expandableLayout0.expand();
                    img_click.setImageResource(R.drawable.up_icon);
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
