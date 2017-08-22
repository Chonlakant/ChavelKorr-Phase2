package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.adapter.SearchProfileAdapter;
import com.twentyfour.chavel.adapter.SearchRouteAdapter;
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;


public class SearchFragmentAdvance extends Fragment {

    SearchRouteAdapter searchRouteAdapter;
    SearchProfileAdapter searchProfileAdapter;
    RecyclerView recyclerView;
    RecyclerView recyclerView_profile;

    ArrayList<Search> listProfile = new ArrayList<>();
    ArrayList<Search> listRoute = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_ad, container, false);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView_profile = (RecyclerView) rootView.findViewById(R.id.recyclerView_profile);


        recyclerView_profile.setLayoutManager(new GridLayoutManager(getActivity(), 6));
        recyclerView_profile.setHasFixedSize(true);
        recyclerView_profile.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i <= 10; i++) {
            Search modelRoute = new Search();
            Search modelProfile = new Search();
            modelRoute.setImageUrl("http://phuket.thai-sale.com/wp-content/uploads/2014/08/samui2.jpg");
            modelProfile.setImageUrl("http://i.pravatar.cc/150?img=5");
            listProfile.add(modelProfile);
            listRoute.add(modelRoute);

            searchRouteAdapter = new SearchRouteAdapter(getActivity(), listRoute);
            searchProfileAdapter = new SearchProfileAdapter(getActivity(), listProfile);

            recyclerView_profile.setAdapter(searchProfileAdapter);
            recyclerView.setAdapter(searchRouteAdapter);
        }

        return rootView;
    }



//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_fragment_search, menu);
//
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_search:
//
//                AdvanceSearchFragment profileFragment = new AdvanceSearchFragment();
//                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container6, profileFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
