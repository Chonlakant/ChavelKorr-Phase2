package com.twentyfour.chavel.activity.MainTab;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.adapter.MyActivityProfileAdapter;
import com.twentyfour.chavel.adapter.RouteHistoryAdapter;
import com.twentyfour.chavel.model.ModelActivityProfile;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RouteHistoryActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    RouteHistoryAdapter routeHistoryAdapter;
    ArrayList<ModelActivityProfile> mPinList = new ArrayList<>();


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_route_history);
        ButterKnife.bind(this);

        toolbar.setTitle("Route History");
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

        mRecyclerView = (RecyclerView) findViewById(R.id.ryc);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0; i <= 10; i++) {
            ModelActivityProfile modelPins = new ModelActivityProfile();
            modelPins.setTitle("Your Friend Name");
            modelPins.setContent("ผู้นำ ฉลุย สุนทรีย์ มหภาคทอมเอนทรานซ์ อันเดอร์มั้งฮากกาฟลุก นรีแพทย์แซว");
            modelPins.setTime("15:0" + i);
            mPinList.add(modelPins);
            routeHistoryAdapter = new RouteHistoryAdapter(getApplicationContext(), mPinList);
            mRecyclerView.setAdapter(routeHistoryAdapter);
        }


    }


}
