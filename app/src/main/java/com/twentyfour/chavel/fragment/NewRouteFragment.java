package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.ActivityActivity;
import com.twentyfour.chavel.activity.BudetActivity;
import com.twentyfour.chavel.activity.LocationActivity;
import com.twentyfour.chavel.activity.PeriodTimeActivity;
import com.twentyfour.chavel.activity.RouteActivity;
import com.twentyfour.chavel.activity.RouteDescriptionActivity;
import com.twentyfour.chavel.activity.RouteHistoryActivity;
import com.twentyfour.chavel.activity.RouteNameActivity;
import com.twentyfour.chavel.activity.SuggestionActivity;
import com.twentyfour.chavel.activity.TravelMethodActivity;


public class NewRouteFragment extends Fragment {

    ImageView imf_next;
    EditText dt_period;
    EditText ed_suggesstion;
    EditText et_travel_method;
    EditText dt_location;
    EditText dt_activity;
    EditText dt_route_descrition;
    EditText dt_name;
    EditText dt_details;
    LinearLayout ls_budget;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_route, null);
        imf_next = (ImageView) view.findViewById(R.id.imf_next);
        dt_period = (EditText) view.findViewById(R.id.dt_period);
        ed_suggesstion = (EditText) view.findViewById(R.id.ed_suggesstion);
        ls_budget = (LinearLayout) view.findViewById(R.id.ls_budget);
        et_travel_method = (EditText) view.findViewById(R.id.et_travel_method);
        dt_activity = (EditText) view.findViewById(R.id.dt_activity);
        dt_location = (EditText) view.findViewById(R.id.dt_location);
        dt_route_descrition = (EditText) view.findViewById(R.id.dt_route_descrition);
        dt_name = (EditText) view.findViewById(R.id.dt_name);
        dt_details = (EditText) view.findViewById(R.id.dt_details);

        imf_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), RouteActivity.class);
                startActivity(i);

            }
        });

        dt_period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PeriodTimeActivity.class);
                startActivity(i);
            }
        });

        ed_suggesstion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), SuggestionActivity.class);
                startActivity(i);
            }
        });

        ls_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), BudetActivity.class);
                startActivity(i);

            }
        });

        et_travel_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TravelMethodActivity.class);
                startActivity(i);
            }
        });

        dt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), LocationActivity.class);
                startActivity(i);

            }
        });

        dt_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ActivityActivity.class);
                startActivity(i);

            }
        });

        dt_route_descrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), RouteDescriptionActivity.class);
                startActivity(i);

            }
        });

        dt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getActivity(), RouteNameActivity.class);
                startActivity(i);

            }
        });

        dt_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), RouteHistoryActivity.class);
                startActivity(i);
            }
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_add_pin, menu);
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