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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_login);

        sing_create = (LinearLayout) findViewById(R.id.sing_create);

        sing_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateUserIdActivity.class);
                startActivity(i);
            }
        });


    }

}
