package com.twentyfour.chavel.activity.MainTab;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LocationAddActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.et_country)
    EditText et_country;

    @Bind(R.id.et_state)
    EditText et_state;

    Dialog dialogContry;
    Dialog dialogCityState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_location_add);
        ButterKnife.bind(this);

        dialogContry = new Dialog(LocationAddActivity.this, R.style.FullHeightDialog);
        dialogContry.setContentView(R.layout.dialog_cross_province);

        dialogCityState = new Dialog(LocationAddActivity.this, R.style.FullHeightDialog);
        dialogCityState.setContentView(R.layout.dialog_choose_country);

        toolbar.setTitle("Location Add");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        et_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCityState.show();
            }
        });

        et_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogContry.show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phone_email, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
