package com.twentyfour.chavel.activity.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RegisterActivity extends BaseActivity {

    @Bind(R.id.create_account)
    LinearLayout ll_create_account;

    @Bind(R.id.continue_fb)
    LinearLayout ll_continue_fb;

    @Bind(R.id.login)
    TextView login;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.term)
    TextView term;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        String styledText = "<u><font>Term&Privacy Policy</font></u>";
        term.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        if(toolbar != null) {

            toolbar.setTitle("Sign up");
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

        ll_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterByPhoneAndEmailActivity.class);
                startActivity(i);
            }
        });

        ll_continue_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_more: {
                Toast.makeText(getApplicationContext(),"Soon",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return false;
    }

}
