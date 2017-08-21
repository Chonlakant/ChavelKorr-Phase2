package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.SelectActivityActivity;
import com.twentyfour.chavel.activity.MainTab.BudgetActivity;
import com.twentyfour.chavel.activity.MainTab.LocationActivity;
import com.twentyfour.chavel.activity.MainTab.PeriodTimeActivity;
import com.twentyfour.chavel.activity.MainTab.RouteDescriptionActivity;
import com.twentyfour.chavel.activity.MainTab.RouteHistoryActivity;
import com.twentyfour.chavel.activity.MainTab.RouteNameActivity;
import com.twentyfour.chavel.activity.LoginRegister.SuggestionActivity;
import com.twentyfour.chavel.activity.MainTab.SelectTravelMethodActivity;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;


public class NewRouteFragment extends Fragment {

    private ExpandableLayout expandableLayout0;

    ImageView imf_next;
    ImageView btn_expand_toggle;
    EditText dt_period;
    EditText ed_suggesstion;
    EditText et_travel_method;
    EditText dt_location;
    EditText dt_activity;
    EditText dt_route_descrition;
    EditText dt_name;
    TextView dt_details;
    LinearLayout ls_budget;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        View view = inflater.inflate(R.layout.fragment_new_route, null);

        expandableLayout0 = (ExpandableLayout) view.findViewById(R.id.expandable_layout_0);

        imf_next = (ImageView) view.findViewById(R.id.imf_next);
        btn_expand_toggle = (ImageView) view.findViewById(R.id.btn_expand_toggle);
        dt_period = (EditText) view.findViewById(R.id.dt_period);
        ed_suggesstion = (EditText) view.findViewById(R.id.ed_suggesstion);
        ls_budget = (LinearLayout) view.findViewById(R.id.ls_budget);
        et_travel_method = (EditText) view.findViewById(R.id.et_travel_method);
        dt_activity = (EditText) view.findViewById(R.id.dt_activity);
        dt_location = (EditText) view.findViewById(R.id.dt_location);
        dt_route_descrition = (EditText) view.findViewById(R.id.dt_route_descrition);
        dt_name = (EditText) view.findViewById(R.id.dt_name);
        dt_details = (TextView) view.findViewById(R.id.dt_details);

        ArrayList<View> views = new ArrayList<>();

        views.add(dt_details);
        views.add(dt_name);
        views.add(dt_route_descrition);
        views.add(dt_location);
        views.add(dt_activity);
        views.add(et_travel_method);
        views.add(dt_period);
        views.add(ed_suggesstion);

        for (int i = 0; i < views.size(); i++) {
            views.get(i).setFocusable(false);
            views.get(i).setClickable(true);
        }

        imf_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i = new Intent(getActivity(), RouteActivity.class);
//                startActivity(i);

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

                Intent i = new Intent(getActivity(), BudgetActivity.class);
                startActivity(i);

            }
        });

        et_travel_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SelectTravelMethodActivity.class);
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

                Intent i = new Intent(getActivity(), SelectActivityActivity.class);
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

        btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandableLayout0.isExpanded()) {
                    expandableLayout0.collapse();
                    btn_expand_toggle.setImageResource(R.drawable.ic_down);
                } else {
                    expandableLayout0.expand();
                    btn_expand_toggle.setImageResource(R.drawable.ic_up);
                }

            }
        });

        expandableLayout0.collapse();


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_add_route, menu);
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
