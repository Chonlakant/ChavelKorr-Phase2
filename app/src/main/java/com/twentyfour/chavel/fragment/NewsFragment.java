package com.twentyfour.chavel.fragment;

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

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.fragment.TabActivityFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NewsFragment extends Fragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    TabLayout tabLayout;
    ViewPager viewPagerNoti;

    String[] iconsNoti = {"Following", "You"};

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).hideToolbar();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_noti,null);
        ButterKnife.bind(getActivity());
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPagerNoti = (ViewPager) view.findViewById(R.id.main_tab_content);
        setupViewPager(viewPagerNoti);

        tabLayout.setupWithViewPager(viewPagerNoti);

        for (int i = 0; i < iconsNoti.length; i++) {
            tabLayout.getTabAt(i).setText(iconsNoti[i]);
        }
        tabLayout.getTabAt(0).select();

        return view;

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapterNoti adapter = new ViewPagerAdapterNoti(getActivity().getSupportFragmentManager());
        adapter.insertNewFragment(new TabActivityFragment());
        adapter.insertNewFragment(new TabActivityFragment());
        viewPager.setAdapter(adapter);

    }


    class ViewPagerAdapterNoti extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapterNoti(FragmentManager manager) {
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
