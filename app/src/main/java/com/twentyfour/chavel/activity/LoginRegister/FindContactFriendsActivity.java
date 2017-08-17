package com.twentyfour.chavel.activity.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.WhatsBirthDayActivity;
import com.twentyfour.chavel.service.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FindContactFriendsActivity extends BaseActivity {
    @Bind(R.id.ls_follow)
    LinearLayout ls_follow;

    @OnClick(R.id.ls_follow)
    void next(View view) {
        Toast.makeText(this, "Follow all friends", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), WhatsBirthDayActivity.class);
        startActivity(i);
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_contact);
        ButterKnife.bind(this);

        toolbar.setTitle("Contacts Friends");
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_skip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_skip: {
                Intent i = new Intent(getApplicationContext(), WhatsBirthDayActivity.class);
                startActivity(i);
                break;
            }
        }
        return false;
    }
}
