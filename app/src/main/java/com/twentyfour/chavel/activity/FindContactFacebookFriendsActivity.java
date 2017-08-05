package com.twentyfour.chavel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FindContactFacebookFriendsActivity extends AppCompatActivity {

    LinearLayout ls_follow;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        ButterKnife.bind(this);

        toolbar.setTitle("FindContactFacebookFriends");
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

        ls_follow = (LinearLayout) findViewById(R.id.ls_findfacebook);


        ls_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), FindContactFriendsActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_skip, menu);
        return true;
    }
}
