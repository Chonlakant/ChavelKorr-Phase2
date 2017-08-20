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

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;

import java.util.ArrayList;
import java.util.List;


public class ShareFragment extends Fragment {

    String[] icons = {"New Route", "From Draft"};

    TabLayout tabLayout;
    ViewPager viewPager;

    View view;

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).hideToolbar();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pins2, container, false);

        init();
        for (int i = 0; i < icons.length; i++) {
            tabLayout.getTabAt(i).setText(icons[i]);
        }
        tabLayout.getTabAt(0).select();

        ((MainActivity)getActivity()).hideToolbar();

        return view;
    }



    private void init() {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.main_tab_content);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            init();
        } else {

        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.insertNewFragment(new NewRouteFragment());
        adapter.insertNewFragment(new NewRouteFragment());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());


    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

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

        public void insertNewFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }


}
