package com.twentyfour.chavel.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;


public class SingInNextActivity extends AppCompatActivity {

    TextView accout;
    LinearLayout login;
    LinearLayout sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_next);


    }

}
