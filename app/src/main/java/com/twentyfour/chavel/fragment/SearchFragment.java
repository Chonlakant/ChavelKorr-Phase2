package com.twentyfour.chavel.fragment;

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

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.adapter.MyActivityProfileAdapter;
import com.twentyfour.chavel.adapter.SearchAdapter;
import com.twentyfour.chavel.model.ModelActivityProfile;
import com.twentyfour.chavel.model.Search;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    SearchAdapter searchAdapter;
    RecyclerView recyclerView;

    ArrayList<Search> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i <= 10; i++) {
            Search modelPins = new Search();
            modelPins.setImageUrl("http://2.bp.blogspot.com/-xRdb6iiVKec/TviHLTZT4qI/AAAAAAAAJ2g/Cn8FJsLEczQ/s1600/wallpapers-cafe.blogspot.com%2B%25252823%252529.jpg");
            list.add(modelPins);
            searchAdapter = new SearchAdapter(getActivity(), list);
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
//            case R.id.action_new_friend:
//                Snackbar.make(view, item.getTitle() + " Clicked", Snackbar.LENGTH_SHORT).show();
//                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
