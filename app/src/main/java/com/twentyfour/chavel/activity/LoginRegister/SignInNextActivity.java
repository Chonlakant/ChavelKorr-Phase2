package com.twentyfour.chavel.activity.LoginRegister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.service.BaseActivity;


public class SignInNextActivity extends BaseActivity {

    TextView accout;
    LinearLayout login;
    LinearLayout sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_next);


    }

}
