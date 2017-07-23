package com.chavel.chavel.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chavel.chavel.R;

public class RegisterByPhoneAndEmailActivity extends AppCompatActivity {

    TextView txt_phone;
    TextView txt_email;
    LinearLayout ls_next;
    EditText ed_phone_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone_email);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        ls_next = (LinearLayout) findViewById(R.id.ls_next);
        ed_phone_code = (EditText) findViewById(R.id.ed_phone_code);

        txt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txt_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),WhatsYourEmailOrPhoneActivity.class);
                startActivity(intent);

            }
        });

        ls_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VertificationSendActivity.class);
                startActivity(i);

            }
        });

        ed_phone_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ChooseCountryActivity.class);
                startActivity(i);
            }
        });


        Drawable drawable = ed_phone_code.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_phone_code.setBackground(drawable); // set the new drawable to EditText

        } else {
            ed_phone_code.setBackgroundDrawable(drawable);
        }


    }

    public static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            Log.e("sum", sum + "");
        }
        return sum;
    }
}
