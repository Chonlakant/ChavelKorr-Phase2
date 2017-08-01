package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.RouteActivity;
import com.twentyfour.chavel.adapter.PinsAdapter;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;


public class PinsFragment extends Fragment {

    PinsAdapter pinsAdapter;
    ArrayList<ModelPins> list = new ArrayList<>();

    RecyclerView ryc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pins, null);
        ryc = (RecyclerView) view.findViewById(R.id.ryc);

        ryc.setLayoutManager(new LinearLayoutManager(getActivity()));
        ryc.setHasFixedSize(true);
        ryc.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0; i < 5; i++) {
            ModelPins modelPins = new ModelPins();
            modelPins.setPins("PINS" + i);
            modelPins.setTitlePins("แวะกินข้าว อร่อยๆ" + i);
            list.add(modelPins);
        }

        pinsAdapter = new PinsAdapter(getActivity(), list);
        ryc.setAdapter(pinsAdapter);

        return view;
    }
}
