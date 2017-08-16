package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.AdvanceSearchActivity;
import com.twentyfour.chavel.adapter.MyActivityProfileAdapter;
import com.twentyfour.chavel.adapter.SearchAdapter;
import com.twentyfour.chavel.adapter.SearchProfileAdapter;
import com.twentyfour.chavel.model.ModelActivityProfile;
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;


public class SearchFragment extends Fragment {

    SearchAdapter searchAdapter;
    SearchProfileAdapter searchProfileAdapter;
    RecyclerView recyclerView;
    RecyclerView recyclerView_profile;

    ArrayList<Search> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        setHasOptionsMenu(true);



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView_profile = (RecyclerView) view.findViewById(R.id.recyclerView_profile);


        recyclerView_profile.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView_profile.setHasFixedSize(true);
        recyclerView_profile.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i <= 10; i++) {
            Search modelPins = new Search();
            modelPins.setImageUrl("https://skyfrog.net/store/skyfrog/00008/pictures/0897770008/A20170810214041.jpg");
            list.add(modelPins);
            searchAdapter = new SearchAdapter(getActivity(), list);
            searchProfileAdapter = new SearchProfileAdapter(getActivity(), list);
            recyclerView_profile.setAdapter(searchProfileAdapter);
            recyclerView.setAdapter(searchAdapter);
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
