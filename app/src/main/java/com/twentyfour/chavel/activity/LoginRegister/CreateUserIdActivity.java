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
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class  CreateUserIdActivity extends BaseActivity {

    @Bind(R.id.ls_next)
    LinearLayout ls_next;

    @Bind(R.id.ed_create_id)
    EditText ed_create_id;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_id);
        ButterKnife.bind(this);

        if(toolbar != null) {

            toolbar.setTitle("");
            toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
            toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

        }

        //ls_next = (LinearLayout) findViewById();
       // ed_create_id = (EditText) findViewById(R.id.ed_create_id);

        Drawable drawable = ed_create_id.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_create_id.setBackground(drawable); // set the new drawable to EditText
        } else {
            ed_create_id.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
        }

        ls_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterByPhoneAndEmailActivity.class);
                startActivity(i);
            }
        });


        ed_create_id.addTextChangedListener(new TextWatcher() {

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
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
