package com.twentyfour.chavel.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.twentyfour.chavel.MainTabActivity;
import com.twentyfour.chavel.Tools;
import com.twentyfour.chavel.activity.LoginRegister.FindContactFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.LoginActivity;
import com.twentyfour.chavel.activity.LoginRegister.RegisterActivity;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Tools.systemBarLolipop(this);
        // mEmoView = (RelativeLayout) getEmoView();

    }

    public void toMainTab() {
        Intent i = new Intent(getApplicationContext(), MainTabActivity.class);
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
