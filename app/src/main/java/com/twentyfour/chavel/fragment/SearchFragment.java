package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.AdvanceSearchActivity;
import com.twentyfour.chavel.adapter.SearchRouteAdapter;
import com.twentyfour.chavel.adapter.SearchProfileAdapter;
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    SearchRouteAdapter searchRouteAdapter;
    SearchProfileAdapter searchProfileAdapter;
    RecyclerView recyclerView;
    RecyclerView recyclerView_profile;

    ArrayList<Search> listProfile = new ArrayList<>();
    ArrayList<Search> listRoute = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView_profile = (RecyclerView) view.findViewById(R.id.recyclerView_profile);


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



        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:

                Intent i = new Intent(getActivity(), AdvanceSearchActivity.class);
                startActivity(i);

                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
