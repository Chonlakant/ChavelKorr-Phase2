package com.twentyfour.chavel;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.twentyfour.chavel.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainTabActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_tab);
        int[] icons = {R.drawable.tab_home,
                R.drawable.tab_search,
                R.drawable.tab_location,
                R.drawable.tab_noti, R.drawable.tab_user
        };
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_tab_content);

        setupViewPager(viewPager);


        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < icons.length; i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
        tabLayout.getTabAt(0).select();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.insertNewFragment(new HomeFragment());
        adapter.insertNewFragment(new HomeFragment());
        adapter.insertNewFragment(new HomeFragment());
        adapter.insertNewFragment(new HomeFragment());
        adapter.insertNewFragment(new HomeFragment());
        viewPager.setAdapter(adapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//
//            case R.id.action_settings:
//                Intent settingsIntent = new Intent(this, TabSample.class);
//                startActivity(settingsIntent);
//            default:
//
//        }
        return super.onOptionsItemSelected(item);
    }

}