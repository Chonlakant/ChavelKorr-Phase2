package com.twentyfour.chavel.activity.LoginRegister;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RegisterByPhoneAndEmailActivity extends BaseActivity {

    TextView txt_phone;
    TextView txt_email;
    Button btn_next;
    EditText ed_name;
    EditText ed_phone_code;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone_email);

        ButterKnife.bind(this);

        countryCodePicker = (CountryCodePicker) findViewById(R.id.ccp);

        toolbar.setTitle("PHONE AND EMAIL");
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

        ed_name = (EditText) findViewById(R.id.ed_name);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        btn_next = (Button) findViewById(R.id.btn_next);


        txt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txt_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), WhatsYourEmailOrPhoneActivity.class);
                startActivity(intent);

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VerifySendActivity.class);
                startActivity(i);

            }
        });

//        ed_phone_code.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), UnusedChooseCountryActivity.class);
//                startActivity(i);
//            }
//        });


        Drawable drawable = ed_name.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_name.setBackground(drawable); // set the new drawable to EditText

        } else {
            ed_name.setBackgroundDrawable(drawable);
        }


        ed_name.addTextChangedListener(new TextWatcher() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {

                    btn_next.setBackground(getResources().getDrawable(R.drawable.bg_unselected, null));
                } else {

                    btn_next.setBackground(getResources().getDrawable(R.drawable.bg_selected, null));

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

        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                //  ed_name.setText(countryCodePicker.getSelectedCountryName());

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phone_email, menu);
        return true;
    }

}
