package com.twentyfour.chavel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SingInActivity extends AppCompatActivity {

    LinearLayout sing_create;
    TextView txt_sing_in;

    @Bind(R.id.txt_login)
    TextView txt_login;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_login);
        ButterKnife.bind(this);

        toolbar.setTitle("Sing in");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txt_sing_in = (TextView) findViewById(R.id.txt_sing_in);
        sing_create = (LinearLayout) findViewById(R.id.sing_create);

        sing_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateUserIdActivity.class);
                startActivity(i);
            }
        });

        txt_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), RegisterByPhoneAndEmailActivity.class);
                startActivity(i);

            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
    }

}
