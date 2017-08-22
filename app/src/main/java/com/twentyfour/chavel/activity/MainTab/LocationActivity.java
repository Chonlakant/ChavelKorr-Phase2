package com.twentyfour.chavel.activity.MainTab;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LocationActivity extends AppCompatActivity {


    LinearLayout ls_contry;
    LinearLayout ls_city_state;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    Dialog dialogContry;
    Dialog dialogCityState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_location);
        ButterKnife.bind(this);

        ls_contry = (LinearLayout) findViewById(R.id.ls_contry);
        ls_city_state = (LinearLayout) findViewById(R.id.ls_city_state);

        dialogContry = new Dialog(LocationActivity.this, R.style.FullHeightDialog);
        dialogContry.setContentView(R.layout.dialog_selelct_location);

        dialogCityState = new Dialog(LocationActivity.this, R.style.FullHeightDialog);
        dialogCityState.setContentView(R.layout.dialog_selelct_city_state);

        toolbar.setTitle("Location");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ls_contry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogContry.show();
            }
        });

        ls_city_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCityState.show();
            }
        });
    }

}
