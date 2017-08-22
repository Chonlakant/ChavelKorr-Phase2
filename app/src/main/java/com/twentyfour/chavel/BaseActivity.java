package com.twentyfour.chavel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.twentyfour.chavel.activity.LoginRegister.FindContactFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.LoginActivity;
import com.twentyfour.chavel.activity.LoginRegister.RegisterActivity;


public abstract class BaseActivity extends AppCompatActivity {



    public void initToolbar(Toolbar toolbar, boolean isBackEnabled) {
        setSupportActionBar(toolbar);

        if(isBackEnabled) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

    public void initToolbar(Toolbar toolbar, String title, boolean isBackEnabled) {

        setSupportActionBar(toolbar);

        if(isBackEnabled) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        getSupportActionBar().setTitle(title);


    }

    public void updateToolbarTitle(String title) {


        getSupportActionBar().setTitle(title);

    }

    public void updateToolbarUpIndicator(int resId) {

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(resId);

    }

    Toolbar toolbar;

    public void showToolbar() {

        if(toolbar != null) {
            toolbar.setVisibility(View.VISIBLE);
        }

    }

    public void hideToolbar() {
        if(toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }

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
