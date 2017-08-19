package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.OverViewPinsActivity;
import com.twentyfour.chavel.adapter.OverviewAdapter;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;


public class OverviewFragment extends Fragment {

    OverviewAdapter pinsAdapter;
    ArrayList<ModelPins> list = new ArrayList<>();

    RecyclerView mRecyclerView;

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            for (int i = 0; i < 5; i++) {
                ModelPins modelPins = new ModelPins();
                modelPins.setPins("PINS" + i);
                modelPins.setTitlePins("แวะกินข้าว อร่อยๆ" + i);
                list.add(modelPins);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                ModelPins modelPins = new ModelPins();
                modelPins.setPins("PINS" + i);
                modelPins.setTitlePins("แวะกินข้าว อร่อยๆ" + i);
                list.add(modelPins);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orverview, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.ryc);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());



        pinsAdapter = new OverviewAdapter(getActivity(), list);
        mRecyclerView.setAdapter(pinsAdapter);
        pinsAdapter.notifyDataSetChanged();
        pinsAdapter.setOnItemClickListener(new OverviewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(getActivity(), OverViewPinsActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
