package com.twentyfour.chavel.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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


public class VertificationSendEnterEmailActivity extends AppCompatActivity {

    EditText ed_code;
    LinearLayout ls_send_code;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_verification_code);

        ButterKnife.bind(this);

        toolbar.setTitle("Vertification Email");
        setSupportActionBar(toolbar);
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

        ls_send_code = (LinearLayout) findViewById(R.id.ls_send_code);

        ed_code = (EditText) findViewById(R.id.ed_code);

        Drawable drawable = ed_code.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_code.setBackground(drawable); // set the new drawable to EditText

        } else {
            ed_code.setBackgroundDrawable(drawable);
        }

        ls_send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), VertificationSendEnterEmailAgainActivity.class);
                startActivity(i);

            }
        });

        ed_code.addTextChangedListener(new TextWatcher() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {

                    ls_send_code.setBackground(getResources().getDrawable(R.drawable.bg_unselected, null));
                } else {

                    ls_send_code.setBackground(getResources().getDrawable(R.drawable.bg_selected, null));

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


}
