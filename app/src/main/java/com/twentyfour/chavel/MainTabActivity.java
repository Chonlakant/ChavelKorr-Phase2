package com.twentyfour.chavel;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import com.twentyfour.chavel.fragment.NewRouteTapFragment;
import com.twentyfour.chavel.fragment.NotiFragment;
import com.twentyfour.chavel.fragment.SearchFragment;
import com.twentyfour.chavel.fragment.TabMyRouteFragment;
import com.twentyfour.chavel.fragment.UserProfileFragment;

public class MainTabActivity extends TabActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // initiate TabHost
        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab

        spec = tabHost.newTabSpec(""); // Create a new TabSpec using tab host
        Drawable dr1 = ResourcesCompat.getDrawable(getResources(), R.drawable.home_tab1, null);
        spec.setIndicator("",dr1); // set the “HOME” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, TabMyRouteFragment.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        spec = tabHost.newTabSpec(""); // Create a new TabSpec using tab host
        Drawable dr2 = ResourcesCompat.getDrawable(getResources(), R.drawable.home_tab2, null);
        spec.setIndicator("",dr2); // set the “CONTACT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, SearchFragment.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec(""); // Create a new TabSpec using tab host
        Drawable dr3 = ResourcesCompat.getDrawable(getResources(), R.drawable.home_tab3, null);
        spec.setIndicator("",dr3); // set the “ABOUT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, NewRouteTapFragment.class);
        spec.setContent(intent);
        tabHost.addTab(spec);


        spec = tabHost.newTabSpec(""); // Create a new TabSpec using tab host
        Drawable dr4 = ResourcesCompat.getDrawable(getResources(), R.drawable.home_tab4, null);
        spec.setIndicator("",dr4); // set the “ABOUT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, NotiFragment.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec(""); // Create a new TabSpec using tab host
        Drawable dr5 = ResourcesCompat.getDrawable(getResources(), R.drawable.home_tab5, null);
        spec.setIndicator("",dr5); // set the “ABOUT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, UserProfileFragment.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        //set tab which one you want to open first time 0 or 1 or 2
        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
               // Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });


    }


}