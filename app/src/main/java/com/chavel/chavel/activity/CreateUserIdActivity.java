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

public class CreateUserIdActivity extends AppCompatActivity {

    TextView accout;
    LinearLayout login;
    LinearLayout sign_up;

    EditText ed_create_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_id);

        ed_create_id = (EditText) findViewById(R.id.ed_create_id);

        Drawable drawable = ed_create_id.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_create_id.setBackground(drawable); // set the new drawable to EditText
        } else {
            ed_create_id.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
        }

    }

}
