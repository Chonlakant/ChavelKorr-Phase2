package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.twentyfour.chavel.BaseActivity;
import com.twentyfour.chavel.R;

import butterknife.ButterKnife;

public class EditProfileActivity extends BaseActivity {

    Toolbar toolbar;
    TextView toolbar_title;
    ImageView toolbar_icon;
    ImageView toolbar_back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_icon = (ImageView) findViewById(R.id.toolbar_icon);
        toolbar_back_icon = (ImageView) findViewById(R.id.back_icon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (toolbar != null) {

            toolbar_title.setText("Edit My Profile");
            toolbar_icon.setVisibility(View.GONE);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}
