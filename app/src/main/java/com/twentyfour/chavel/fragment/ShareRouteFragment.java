package com.twentyfour.chavel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;

import java.util.ArrayList;
import java.util.List;


public class ShareRouteFragment extends Fragment {

    String[] titles = {"NEW ROUTE", "FROM DRAFT"};

    TabLayout tabLayout;
    FrameLayout frameLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_route, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        frameLayout = (FrameLayout) view.findViewById(R.id.share_route_frame);
        tabLayout = (TabLayout) view.findViewById(R.id.share_route_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(titles[0]),true);
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));
        selectNewRoute();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    selectNewRoute();
                }else if(tab.getPosition()==1){
                    selectFromDraft();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void selectNewRoute() {
        NewRouteFragment newRouteFragment = new NewRouteFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.share_route_frame, newRouteFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        tabLayout.getTabAt(0).select();
    }

    private void selectFromDraft() {
        NewRouteFragment newRouteFragment = new NewRouteFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.share_route_frame, newRouteFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        tabLayout.getTabAt(1).select();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

}
