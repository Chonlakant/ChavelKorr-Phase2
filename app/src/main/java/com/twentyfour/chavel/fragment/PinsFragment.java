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

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.EditPinFragment;
import com.twentyfour.chavel.activity.MainTab.PinDetailsFragment;
import com.twentyfour.chavel.adapter.PinsAdapter;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;


public class PinsFragment extends Fragment {

    PinsAdapter pinsAdapter;
    ArrayList<ModelPins> list = new ArrayList<>();

    RecyclerView mRecyclerView;

    public PinsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pins, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.ryc);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < 5; i++) {
            ModelPins modelPins = new ModelPins();
            modelPins.setPins("PINS" + i);
            modelPins.setTitlePins("แวะกินข้าว อร่อยๆ" + i);
            list.add(modelPins);
        }

        pinsAdapter = new PinsAdapter(getActivity(), list);
        mRecyclerView.setAdapter(pinsAdapter);

        pinsAdapter.setOnItemClickListener(new PinsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View viewj, int position) {

                EditPinFragment editPinActivity = new EditPinFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container8, editPinActivity);
                transaction.addToBackStack(null);
                transaction.commit();

//                Intent i = new Intent(getActivity(), EditPinFragment.class);
//                startActivity(i);
            }
        });


        pinsAdapter.setOnItemClickImageListener(new PinsAdapter.OnItemClickImageListener() {
            @Override
            public void onItemClickImage(View viewj, int position) {
                PinDetailsFragment pinDetailsFragment = new PinDetailsFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container8, pinDetailsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}
