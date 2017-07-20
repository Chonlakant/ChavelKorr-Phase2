package com.chavel.chavel.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chavel.chavel.R;

public class SingInActivity extends AppCompatActivity {

    TextView accout;
    TextView forget;
    LinearLayout login;
    LinearLayout sign_up;

    EditText ed_mail;
    EditText ed_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        forget = (TextView) findViewById(R.id.forget);
        accout = (TextView) findViewById(R.id.accout);
        ed_mail = (EditText) findViewById(R.id.ed_mail);
        ed_pass = (EditText) findViewById(R.id.ed_pass);

        Drawable drawable = ed_mail.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_mail.setBackground(drawable); // set the new drawable to EditText
            ed_pass.setBackground(drawable);
        } else {
            ed_mail.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
            ed_pass.setBackgroundDrawable(drawable);
        }

        accout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SingInNextActivity.class);
                startActivity(i);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SetPasswordActivity.class);
                startActivity(i);
            }
        });

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
