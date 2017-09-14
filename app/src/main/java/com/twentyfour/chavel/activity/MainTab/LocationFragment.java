package com.twentyfour.chavel.activity.MainTab;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LocationFragment extends Fragment {


    LinearLayout ls_contry;
    LinearLayout ls_city_state;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    Dialog dialogContry;
    Dialog dialogCityState;


    public static LocationFragment newInstance() {
        return new LocationFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);


        ls_contry = (LinearLayout) rootView.findViewById(R.id.ls_contry);
        ls_city_state = (LinearLayout) rootView.findViewById(R.id.ls_city_state);

        dialogContry = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialogContry.setContentView(R.layout.dialog_selelct_location);

        dialogCityState = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialogCityState.setContentView(R.layout.dialog_selelct_city_state);

        toolbar.setTitle("Location");
        //setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().onBackPressed();
            }
        });

        ls_contry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogContry.show();
            }
        });

        ls_city_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCityState.show();
            }
        });

        return rootView;
    }

}
