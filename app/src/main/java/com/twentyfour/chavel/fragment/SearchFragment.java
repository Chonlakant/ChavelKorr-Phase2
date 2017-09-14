package com.twentyfour.chavel.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.AdvanceSearchFragment;
import com.twentyfour.chavel.activity.MainTab.SearchFragmentAdvance;
import com.twentyfour.chavel.activity.MainTab.SearchMutiTypeFragment;
import com.twentyfour.chavel.adapter.SearchRouteAdapter;
import com.twentyfour.chavel.adapter.SearchProfileAdapter;
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;

import butterknife.Bind;


public class SearchFragment extends AppCompatActivity {

    SearchRouteAdapter searchRouteAdapter;
    SearchProfileAdapter searchProfileAdapter;
    RecyclerView recyclerView;
    RecyclerView recyclerView_profile;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Search> listProfile = new ArrayList<>();
    ArrayList<Search> listRoute = new ArrayList<>();

<<<<<<< HEAD
    Toolbar toolbar;
=======
    private RecyclerView.LayoutManager mLayoutManager;

>>>>>>> korrio/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));


<<<<<<< HEAD
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView_profile = (RecyclerView) findViewById(R.id.recyclerView_profile);

=======
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView_profile.setHasFixedSize(true);
        recyclerView_profile.setItemAnimator(new DefaultItemAnimator());
        recyclerView_profile.setLayoutManager(mLayoutManager);
>>>>>>> korrio/master

        mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView_profile.setLayoutManager(mLayoutManager);

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i <= 10; i++) {
            Search modelRoute = new Search();
            Search modelProfile = new Search();
            modelRoute.setImageUrl("http://phuket.thai-sale.com/wp-content/uploads/2014/08/samui2.jpg");
            modelProfile.setImageUrl("http://i.pravatar.cc/150?img=5");
            listProfile.add(modelProfile);
            listRoute.add(modelRoute);

            searchRouteAdapter = new SearchRouteAdapter(getApplicationContext(), listRoute);
            searchProfileAdapter = new SearchProfileAdapter(getApplicationContext(), listProfile);

            recyclerView_profile.setAdapter(searchProfileAdapter);
            recyclerView.setAdapter(searchRouteAdapter);
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fragment_search, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:

                SearchMutiTypeFragment searchFragmentAdvance = new SearchMutiTypeFragment();
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container6, searchFragmentAdvance);
                transaction.addToBackStack(null);
                transaction.commit();




                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
