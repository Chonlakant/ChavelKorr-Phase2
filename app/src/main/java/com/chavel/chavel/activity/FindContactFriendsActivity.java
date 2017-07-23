package com.chavel.chavel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.chavel.chavel.R;

public class FindContactFriendsActivity extends AppCompatActivity {

    LinearLayout ls_follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_contact);
        ls_follow = (LinearLayout) findViewById(R.id.ls_follow);


        ls_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), WhatsBirthDayActivity.class);
                startActivity(i);


            }
        });
    }

    public static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            Log.e("sum", sum + "");
        }
        return sum;
    }
}
