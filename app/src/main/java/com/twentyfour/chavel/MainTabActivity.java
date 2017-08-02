package com.twentyfour.chavel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.twentyfour.chavel.adapter.PageFragmentAdapter;
import com.twentyfour.chavel.fragment.HomeFragment;
import com.twentyfour.chavel.fragment.LocationFragment;
import com.twentyfour.chavel.fragment.NotiFragment;
import com.twentyfour.chavel.fragment.SerachFragment;
import com.twentyfour.chavel.fragment.SettingsUserFragment;

public class MainTabActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageFragmentAdapter adapter;

    private HomeFragment f_home;
    private SerachFragment f_search;
    private LocationFragment f_location;
    private NotiFragment f_notif;
    private SettingsUserFragment f_user;
    int[] icons = {R.drawable.tab_home,
            R.drawable.tab_search,
            R.drawable.tab_location,
            R.drawable.tab_noti, R.drawable.tab_user
    };

    boolean checkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Chavel");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        setupTabClick();


        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }


    private void setupViewPager(ViewPager viewPager) {
        adapter = new PageFragmentAdapter(getSupportFragmentManager());
        if (f_home == null) {
            f_home = new HomeFragment();
        }
        if (f_search == null) {
            f_search = new SerachFragment();
        }
        if (f_location == null) {
            f_location = new LocationFragment();
        }
        if (f_notif == null) {
            f_notif = new NotiFragment();
        }
        if (f_user == null) {
            f_user = new SettingsUserFragment();
        }
        adapter.addFragment(f_home, "");
        adapter.addFragment(f_search, "");
        adapter.addFragment(f_location, "");
        adapter.addFragment(f_notif, "");
        adapter.addFragment(f_user, "");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[1]);
        tabLayout.getTabAt(2).setIcon(icons[2]);
        tabLayout.getTabAt(3).setIcon(icons[3]);
        tabLayout.getTabAt(4).setIcon(icons[4]);
    }

    private void setupTabClick() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
                actionbar.setTitle(adapter.getTitle(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "ออกจากระบบ", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        doExitApp();
    }


}