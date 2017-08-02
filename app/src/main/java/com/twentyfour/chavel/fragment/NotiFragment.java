package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.RouteActivity;


public class NotiFragment extends Fragment {

    ImageView imf_next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_route, null);



        imf_next = (ImageView) view.findViewById(R.id.imf_next);

        imf_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), RouteActivity.class);
                startActivity(i);

            }
        });

        return view;
    }
}
