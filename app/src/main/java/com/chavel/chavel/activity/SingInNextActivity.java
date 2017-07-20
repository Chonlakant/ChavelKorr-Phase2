package com.chavel.chavel.activity;

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

public class SingInNextActivity extends AppCompatActivity {

    TextView accout;
    LinearLayout login;
    LinearLayout sign_up;

    EditText ed_last;
    EditText ed_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_next);

        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_last = (EditText) findViewById(R.id.ed_last);

        Drawable drawable = ed_name.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_name.setBackground(drawable); // set the new drawable to EditText
            ed_last.setBackground(drawable);
        } else {
            ed_name.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
            ed_last.setBackgroundDrawable(drawable);
        }
    }

}
