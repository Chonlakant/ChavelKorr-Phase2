package com.twentyfour.chavel.activity.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;

import butterknife.Bind;

public class FollowUserActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    TextView toolbar_title;
    ImageView toolbar_icon;
    ImageView toolbar_back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

<<<<<<< HEAD
        toolbar.setTitle("24 Likes");
=======

>>>>>>> korrio/master
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_icon = (ImageView) findViewById(R.id.toolbar_icon);
        toolbar_back_icon = (ImageView) findViewById(R.id.back_icon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

        toolbar_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        toolbar_title.setText("24 Likes");
                toolbar_icon.setImageDrawable(getDrawable(R.drawable.ic_like));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_skip, menu);
        return true;
    }

}
