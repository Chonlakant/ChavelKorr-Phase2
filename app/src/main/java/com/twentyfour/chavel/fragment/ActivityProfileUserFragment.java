package com.twentyfour.chavel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.adapter.MyActivityProfileAdapter;
import com.twentyfour.chavel.adapter.PinsAdapter;
import com.twentyfour.chavel.model.ModelActivityProfile;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;


public class ActivityProfileUserFragment extends Fragment {
    MyActivityProfileAdapter myActivityProfileAdapter;
    ArrayList<ModelActivityProfile> list = new ArrayList<>();

    RecyclerView ryc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);


        ryc = (RecyclerView) view.findViewById(R.id.ryc);

        ryc.setLayoutManager(new LinearLayoutManager(getActivity()));
        ryc.setHasFixedSize(true);
        ryc.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0; i <= 10; i++) {
            ModelActivityProfile modelPins = new ModelActivityProfile();
            modelPins.setContent("MMMMMMMMM" + i);
            modelPins.setTime("15:0 " + i);
            list.add(modelPins);
            myActivityProfileAdapter = new MyActivityProfileAdapter(getActivity(), list);
            ryc.setAdapter(myActivityProfileAdapter);
        }



        return view;
    }
}
