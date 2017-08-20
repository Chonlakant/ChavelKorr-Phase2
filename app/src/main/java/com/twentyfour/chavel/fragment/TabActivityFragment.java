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
import com.twentyfour.chavel.model.ModelActivityProfile;

import java.util.ArrayList;


public class TabActivityFragment extends Fragment {
    MyActivityProfileAdapter myActivityProfileAdapter;
    ArrayList<ModelActivityProfile> mPinList = new ArrayList<>();

    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.ryc);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i <= 10; i++) {
            ModelActivityProfile modelPins = new ModelActivityProfile();
            modelPins.setTitle("Your Friend Name");
            modelPins.setContent("ผู้นำ ฉลุย สุนทรีย์ มหภาคทอมเอนทรานซ์ อันเดอร์มั้งฮากกาฟลุก นรีแพทย์แซว");
            modelPins.setTime("15:0" + i);
            mPinList.add(modelPins);
            myActivityProfileAdapter = new MyActivityProfileAdapter(getActivity(), mPinList);
            mRecyclerView.setAdapter(myActivityProfileAdapter);
        }

        return view;
    }
}
