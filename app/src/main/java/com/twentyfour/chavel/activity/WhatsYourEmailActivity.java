package com.twentyfour.chavel.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class WhatsYourEmailActivity extends AppCompatActivity {

    LinearLayout ls_next;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.ed_name)
    EditText ed_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_email);

        ButterKnife.bind(this);
        toolbar.setTitle("WhatsYourEmail");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ls_next = (LinearLayout) findViewById(R.id.ls_next);


        ls_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FindFacebookFriendsActivity.class);
                startActivity(intent);
            }
        });

        ed_name.addTextChangedListener(new TextWatcher() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {

                    ls_next.setBackground(getResources().getDrawable(R.drawable.bg_unselected, null));
                } else {

                    ls_next.setBackground(getResources().getDrawable(R.drawable.bg_selected, null));

                }


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_skip, menu);
        return true;
    }

}
