package com.twentyfour.chavel.activity;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hbb20.CountryCodePicker;
import com.twentyfour.chavel.R;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;


public class WhatsBirthDayActivity extends AppCompatActivity {

    LinearLayout ls_next;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.ed_name)
    EditText ed_name;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_birthday);
        ButterKnife.bind(this);

        toolbar.setTitle("WhatsBirthDay");
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


        DatePicker dp = (DatePicker) findViewById(R.id.dp);

        // Get a new Calendar instance
        Calendar calendar = Calendar.getInstance();
        // Get the Calendar current year, month and day of month
        int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Do something when the date changed from date picker object

                // Create a Date variable/object with user chosen date
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(0);
                cal.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
                Date chosenDate = cal.getTime();

                // Format the date
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
                String formattedDate = df.format(chosenDate);
                ed_name.setText( formattedDate);
            }
        });

        ls_next = (LinearLayout) findViewById(R.id.ls_next);


        ls_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), SettingsAddPhotoActivity.class);
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
