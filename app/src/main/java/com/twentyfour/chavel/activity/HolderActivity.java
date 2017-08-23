package com.twentyfour.chavel.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.twentyfour.chavel.BaseActivity;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.fragment.HomeFragment;

public class HolderActivity extends BaseActivity {

    Toolbar toolbar;
    TextView toolbar_title;
    ImageView toolbar_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        ft.replace(R.id.frame_holder, new HomeFragment());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit();

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_icon = (ImageView) findViewById(R.id.toolbar_icon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if(toolbar != null) {
            //setSupportActionBar(toolbar);
            if(getIntent().getExtras().getInt("index") == 1) {
                toolbar_title.setText("My Route");
                toolbar_icon.setImageDrawable(getDrawable(R.drawable.ic_tab_my_route));
            } else {
                toolbar_title.setText("Favorite");
                toolbar_icon.setImageDrawable(getDrawable(R.drawable.ic_tab_my_favourite));
            }

        }
    }
}
