package com.twentyfour.chavel.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/fragment/NotiFragment.java
import com.twentyfour.chavel.adapter.ViewPagerAdapterNoti;
=======

import java.util.ArrayList;
import java.util.List;
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/fragment/NewsFragment.java

import butterknife.Bind;
import butterknife.ButterKnife;


<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/fragment/NotiFragment.java
public class NotiFragment extends AppCompatActivity {

    Toolbar toolbar;
=======
public class NewsFragment extends Fragment {
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/fragment/NewsFragment.java

    TabLayout tabLayoutNoti;
    ViewPager viewPagerNoti;

    String[] iconsNoti = {"Following", "You"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_noti);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayoutNoti = (TabLayout) findViewById(R.id.tab_layout1);
        viewPagerNoti = (ViewPager) findViewById(R.id.main_tab_content1);
        viewPagerNoti.setOffscreenPageLimit(5);
        setupViewPagerNoti(viewPagerNoti);

        tabLayoutNoti.setupWithViewPager(viewPagerNoti);

        for (int i = 0; i < iconsNoti.length; i++) {
            tabLayoutNoti.getTabAt(i).setText(iconsNoti[i]);
        }
        tabLayoutNoti.getTabAt(0).select();



    }

    private void setupViewPagerNoti(ViewPager viewPager1) {
        ViewPagerAdapterNoti adapter = new ViewPagerAdapterNoti(getSupportFragmentManager());
        adapter.insertNewFragment(new FollowingFragment());
        adapter.insertNewFragment(new YouFragment());
        viewPager1.setAdapter(adapter);

    }






}
