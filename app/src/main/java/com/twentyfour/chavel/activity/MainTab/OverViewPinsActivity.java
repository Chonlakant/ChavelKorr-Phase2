package com.twentyfour.chavel.activity.MainTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;
<<<<<<< HEAD
import com.twentyfour.chavel.activity.SelectOverViewPinsActivity;
import com.twentyfour.chavel.adapter.OrverViewPinAdapter;
=======
import com.twentyfour.chavel.adapter.OverViewPinAdapter;
>>>>>>> korrio/master
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class OverViewPinsActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    OverViewPinAdapter searchAdapter;
    RecyclerView recyclerView;

    LinearLayout ls_view;


    ArrayList<Search> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_pins_activity);
        ButterKnife.bind(this);
        ls_view = (LinearLayout) findViewById(R.id.ls_view);

        toolbar.setTitle("Overview (Pin)");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0; i <= 8; i++) {
            Search modelPins = new Search();
            modelPins.setImageUrl("http://2.bp.blogspot.com/-xRdb6iiVKec/TviHLTZT4qI/AAAAAAAAJ2g/Cn8FJsLEczQ/s1600/wallpapers-cafe.blogspot.com%2B%25252823%252529.jpg");
            list.add(modelPins);

            searchAdapter = new OverViewPinAdapter(getApplicationContext(), list);
            recyclerView.setAdapter(searchAdapter);
            searchAdapter.setOnItemClickListener(new OrverViewPinAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent i = new Intent(getApplication(), SelectOverViewPinsActivity.class);
                    startActivity(i);
                }
            });
        }

        ls_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
