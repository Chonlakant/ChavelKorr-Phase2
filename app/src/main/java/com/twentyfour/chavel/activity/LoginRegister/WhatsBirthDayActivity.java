package com.twentyfour.chavel.activity.LoginRegister;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.BaseActivity;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;


public class WhatsBirthDayActivity extends BaseActivity {

    LinearLayout ls_next;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.ed_name)
    EditText ed_name;

    int year;
    int month;
    int day;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_birthday);
        ButterKnife.bind(this);

        // Get a new Calendar instance
        Calendar calendar = Calendar.getInstance();
        // Get the Calendar current year, month and day of month
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day = calendar.get(calendar.DAY_OF_MONTH);

        toolbar.setTitle("");
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

        ed_name.setFocusable(false);
        ed_name.setClickable(true);

        DatePicker dp = (DatePicker) findViewById(R.id.dp);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(0);
                cal.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
                Date chosenDate = cal.getTime();

                // Format the date
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
                String formattedDate = df.format(chosenDate);
                ed_name.setText(formattedDate);

                if(year < 2017) {
                    ls_next.setBackground(getDrawable(R.drawable.bg_selected));
                } else {
                    ls_next.setBackground(getDrawable(R.drawable.bg_unselected));
                    Toast.makeText(getApplicationContext(),"Please select a valid birthday",Toast.LENGTH_SHORT).show();
                }

            }
        });


        ls_next = (LinearLayout) findViewById(R.id.ls_next);

        ls_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(year < 2017) {
                    Intent i = new Intent(getApplicationContext(), SettingsAddPhotoActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"Please select a valid birthday.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_skip, menu);
        return true;
    }
}
