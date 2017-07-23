package com.chavel.chavel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chavel.chavel.R;

public class LoginActivity extends AppCompatActivity {

    LinearLayout sing_create;
    TextView txt_sing_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_login);
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

                Intent i =new Intent(getApplicationContext(),RegisterByPhoneAndEmailActivity.class);
                startActivity(i);

            }
        });
    }

}
