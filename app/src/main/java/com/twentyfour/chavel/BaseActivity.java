package com.twentyfour.chavel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.twentyfour.chavel.activity.LoginRegister.FindContactFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.LoginActivity;
import com.twentyfour.chavel.activity.LoginRegister.RegisterActivity;


public abstract class BaseActivity extends AppCompatActivity {



    public void initToolbar(Toolbar toolbar, boolean isBackEnabled) {
        setSupportActionBar(toolbar);

        if(isBackEnabled) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        }
    }

    public void initToolbar(Toolbar toolbar, String title, boolean isBackEnabled) {

        setSupportActionBar(toolbar);

        if(isBackEnabled) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        }

        getSupportActionBar().setTitle(title);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Tools.systemBarLolipop(this);
        // mEmoView = (RelativeLayout) getEmoView();

    }

    public void toMainTab() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void toRegister() {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
    }

    public void toLogin() {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    public void toFindContact() {
        Intent i = new Intent(getApplicationContext(), FindContactFriendsActivity.class);
        startActivity(i);
    }
}
