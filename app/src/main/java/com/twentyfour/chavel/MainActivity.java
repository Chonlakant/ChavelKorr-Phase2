package com.twentyfour.chavel;

import android.opengl.Visibility;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.twentyfour.chavel.fragment.HomeFragment;
import com.twentyfour.chavel.fragment.PageFriendFragment;
import com.twentyfour.chavel.fragment.PageProfileFragment;
import com.twentyfour.chavel.fragment.SearchFragment;
import com.twentyfour.chavel.fragment.ShareRouteFragment;
import com.twentyfour.chavel.utils.FragNavController;
import com.twentyfour.chavel.utils.FragmentHistory;
import com.twentyfour.chavel.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BaseFragment.FragmentNavigation, FragNavController.TransactionListener, FragNavController.RootFragmentListener {

    @Bind(R.id.content_frame)
    FrameLayout contentFrame;

    int[] mTabIconsNormal = {
            R.mipmap.ic_tab_home,
            R.mipmap.ic_tab_search,
            R.mipmap.ic_tab_chavel,
            R.mipmap.ic_tab_noti,
            R.mipmap.ic_tab_profile
    };

    int[] mTabIconsSelected = {
            R.mipmap.ic_tab_home_color,
            R.mipmap.ic_tab_search_color,
            R.mipmap.ic_tab_chavel_color,
            R.mipmap.ic_tab_noti_color,
            R.mipmap.ic_tab_profile_color
    };
    String[] TABS = {"Chavel", "Search", "Add Route", "Notification", "Mr.Chavel24"};
    @Bind(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;
    TextView toolbar_title;
    ImageView toolbar_icon;
    ImageView toolbar_back_icon;

    private FragNavController mNavController;
    private FragmentHistory fragmentHistory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initActionBar();
        initTab();

        fragmentHistory = new FragmentHistory();

        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.content_frame)
                .transactionListener(this)
                .rootFragmentListener(this, TABS.length)
                .build();

        switchTab(0);

        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                fragmentHistory.push(tab.getPosition());

                switchTab(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
 
                mNavController.clearStack();
                switchTab(tab.getPosition());

            }
        });
    }

    Toolbar toolbar;

    private void initActionBar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setCustomView(R.layout.toolbar_custom);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //actionBar = getSupportActionBar().getCustomView();

        updateToolbar(0);

        toolbar_title.setText("Chavel");
        toolbar_icon.setImageDrawable(getDrawable(R.drawable.ic_logo));

        toolbar_back_icon = (ImageView) findViewById(R.id.back_icon);
        toolbar_back_icon.setVisibility(View.GONE);
    }

    private void initTab() {
        if (bottomTabLayout != null) {
            for (int i = 0; i < TABS.length; i++) {
                bottomTabLayout.addTab(bottomTabLayout.newTab());
                TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(getTabView(i));
            }
        }
    }

    View viewTab;


    private View getTabView(int position) {
        viewTab = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_item_bottom, null);
        ImageView icon = (ImageView) viewTab.findViewById(R.id.tab_icon);
        icon.setImageDrawable(Utils.setDrawableSelector(MainActivity.this, mTabIconsNormal[position], mTabIconsSelected[position]));
        return viewTab;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {

        super.onStop();
    }

    private void switchTab(int position) {
        mNavController.switchTab(position);

//        updateToolbarTitle(position);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    Menu toolbar_menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        toolbar_menu = menu;
        //getMenuInflater().inflate(R.menu.menu_fragment_home, menu);
        return true;
    }



    @Override
    public void onBackPressed() {

        if (!mNavController.isRootFragment()) {
            mNavController.popFragment();
        } else {

            if (fragmentHistory.isEmpty()) {
                super.onBackPressed();
            } else {

                if (fragmentHistory.getStackSize() > 1) {

                    int position = fragmentHistory.popPrevious();

                    switchTab(position);

                    updateTabSelection(position);

                } else {

                    switchTab(0);

                    updateTabSelection(0);

                    fragmentHistory.emptyStack();
                }
            }

        }
    }

    private void updateTabSelection(int currentTab) {

        for (int i = 0; i < TABS.length; i++) {
            TabLayout.Tab selectedTab = bottomTabLayout.getTabAt(i);
            if (currentTab != i) {
                selectedTab.getCustomView().setSelected(false);
            } else {
                selectedTab.getCustomView().setSelected(true);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }
    }

    @Override
    public void onTabTransaction(Fragment fragment, int index) {
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {

            updateToolbar(index);

        }
    }

    private void updateToolbar(int index) {

        updateToolbarTitle(index);
        updateToolbarIcon(index);

//        View indicator = findViewById(R.id.indicator);
//        indicator.setVisibility(View.INVISIBLE);

        switch (index) {
            case 0:
                getSupportActionBar().show();
                toolbar.inflateMenu(R.menu.menu_fragment_home);
                break;
            case 1:
                getSupportActionBar().show();
                toolbar.inflateMenu(R.menu.menu_fragment_search);
                break;
            case 2:
                getSupportActionBar().hide();
                break;
            case 3:
                getSupportActionBar().hide();
                break;
            case 4:
                getSupportActionBar().show();
                toolbar.inflateMenu(R.menu.menu_fragment_profile);
                break;
            default:
                getSupportActionBar().setTitle("Chavel App");
                break;
        }
    }

    private void updateToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        getSupportActionBar().setDisplayShowHomeEnabled(!mNavController.isRootFragment());
    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
        //do fragmentty stuff. Maybe change title, I'm not going to tell you how to live your life
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {

            updateToolbar();

        }
    }

    @Override
    public Fragment getRootFragment(int index) {
        switch (index) {

            case FragNavController.TAB1:
                return new HomeFragment();
            case FragNavController.TAB2:
                return new SearchFragment();
            case FragNavController.TAB3:
                return new ShareRouteFragment();
            case FragNavController.TAB4:
                //return new NewsFragment();
                return new PageFriendFragment();
            case FragNavController.TAB5:
                //return new ProfileFragment();
                return new PageProfileFragment();

        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    private void updateToolbarTitle(int index) {

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText(TABS[index]);

    }

    private void updateToolbarIcon(int index) {

        toolbar_icon = (ImageView) findViewById(R.id.toolbar_icon);
        if (toolbar != null) {

            if (index == 0) {
                toolbar_icon.setImageDrawable(getDrawable(R.mipmap.ic_tab_chavel_color));
            } else {
                toolbar_icon.setVisibility(View.GONE);
            }

        }
    }

}