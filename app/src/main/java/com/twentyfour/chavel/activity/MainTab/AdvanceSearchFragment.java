package com.twentyfour.chavel.activity.MainTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;


public class AdvanceSearchFragment extends Fragment {


    Toolbar toolbar;


    LinearLayout ls_location;

    LinearLayout ls_activity;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.advance_search_activity, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ls_activity = (LinearLayout) rootView.findViewById(R.id.ls_activity);
        ls_location = (LinearLayout) rootView.findViewById(R.id.ls_location);

        toolbar.setTitle("Advance Search");
        //  setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        ls_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdvanceSearchFragment profileFragment = new AdvanceSearchFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container6, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ls_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FindPeopleFragment findPeopleFragment = new FindPeopleFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container6, findPeopleFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_phone_email, menu);
//
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        return super.onOptionsItemSelected(item);
//    }

}
