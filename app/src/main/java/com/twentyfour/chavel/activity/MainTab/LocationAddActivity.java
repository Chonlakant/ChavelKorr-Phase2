package com.twentyfour.chavel.activity.MainTab;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.twentyfour.chavel.BusProvider.BusProvider;
import com.twentyfour.chavel.Event.Events_Desc;
import com.twentyfour.chavel.Event.Events_Route_Loction;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.model.Location;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LocationAddActivity extends Fragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.et_country)
    EditText et_country;

    @Bind(R.id.et_state)
    EditText et_state;

    Dialog dialogContry;
    Dialog dialogCityState;

    Location location;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location_add, container, false);
        ButterKnife.bind(getActivity());
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        et_country = (EditText) rootView.findViewById(R.id.et_country);
        et_state = (EditText) rootView.findViewById(R.id.et_state);

        dialogContry = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialogContry.setContentView(R.layout.dialog_cross_province);

        dialogCityState = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialogCityState.setContentView(R.layout.dialog_choose_country);

        location = new Location();

        toolbar.setTitle("Location");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Events_Route_Loction.Events_RoutLocationFragmentMessage fragmentActivityMessageEvent
                        = new Events_Route_Loction.Events_RoutLocationFragmentMessage(location);
                BusProvider.getBus().post(fragmentActivityMessageEvent);
                getActivity().onBackPressed();
            }
        });


        et_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCityState.show();
            }
        });

        et_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogContry.show();
            }
        });

        return rootView;
    }




}
