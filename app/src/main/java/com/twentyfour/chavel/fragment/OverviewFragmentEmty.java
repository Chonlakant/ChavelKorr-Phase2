package com.twentyfour.chavel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.adapter.OverviewAdapter;
import com.twentyfour.chavel.model.ModelPins;

import java.util.ArrayList;


public class OverviewFragmentEmty extends Fragment {


    public static OverviewFragmentEmty newInstance() {
        OverviewFragmentEmty fragment = new OverviewFragmentEmty();
//        Bundle bundle = new Bundle();
//        bundle.putString(EXTRA_KEY, key);
//        fragment.setArguments(bundle);
        return fragment;
    }

    public OverviewFragmentEmty() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orverview_emty, null);

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
