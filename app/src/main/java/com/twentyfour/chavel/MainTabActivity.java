package com.twentyfour.chavel;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.twentyfour.chavel.activity.NotiFragment;
import com.twentyfour.chavel.adapter.PageFragmentAdapter;
import com.twentyfour.chavel.fragment.TabMyRouteFragment;
import com.twentyfour.chavel.fragment.NewRouteFragment;
import com.twentyfour.chavel.fragment.SearchFragment;
import com.twentyfour.chavel.fragment.UserProfileFragment;

public class MainTabActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private PageFragmentAdapter adapter;

    private TabMyRouteFragment f_home;
    private SearchFragment f_search;
    private NewRouteFragment f_location;
    private NotiFragment f_notif;
    private UserProfileFragment f_user;
    int[] icons = {R.drawable.tab_home,
            R.drawable.tab_search,
            R.drawable.tab_location,
            R.drawable.tab_noti, R.drawable.tab_user
    };
    String[] titles = {"Chavel","Search","Add Pin", "Notification", "My Profile"};

    boolean checkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {

            toolbar.setTitle("Chavel");
            toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
            toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
            //toolbar.setNavigationIcon(R.drawable.ic_back);

            setSupportActionBar(toolbar);
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onBackPressed();
//                }
//            });

        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        setupViewPager(viewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        setupTabClick();

        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }


    private void setupViewPager(ViewPager viewPager) {
        adapter = new PageFragmentAdapter(getSupportFragmentManager());
        if (f_home == null) {
            f_home = new TabMyRouteFragment();
        }
        if (f_search == null) {
            f_search = new SearchFragment();
        }
        if (f_location == null) {
            f_location = new NewRouteFragment();
        }
        if (f_notif == null) {
            f_notif = new NotiFragment();
        }
        if (f_user == null) {
            f_user = new UserProfileFragment();
        }
        adapter.addFragment(f_home, "");
        adapter.addFragment(f_search, "");
        adapter.addFragment(f_location, "");
        adapter.addFragment(f_notif, "");
        adapter.addFragment(f_user, "");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) tab.setCustomView(R.layout.view_home_tab);
        }

        mTabLayout.getTabAt(0).setIcon(icons[0]);
        mTabLayout.getTabAt(1).setIcon(icons[1]);
        mTabLayout.getTabAt(2).setIcon(icons[2]);
        mTabLayout.getTabAt(3).setIcon(icons[3]);
        mTabLayout.getTabAt(4).setIcon(icons[4]);
    }

    private void setupTabClick() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
                if(toolbar != null) {
                    toolbar.setTitle(titles[position]);
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