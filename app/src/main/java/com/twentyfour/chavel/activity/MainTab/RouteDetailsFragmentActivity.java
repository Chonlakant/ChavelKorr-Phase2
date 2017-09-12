package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.fragment.NewRouteFragment;
import com.twentyfour.chavel.fragment.RouteDetailsFragment;


public class RouteDetailsFragmentActivity extends Fragment {

    public static final String KEY_PROFILE = "key_data";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route_details, container, false);

        return rootView;

    }


}
