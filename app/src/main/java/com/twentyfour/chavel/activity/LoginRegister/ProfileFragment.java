package com.twentyfour.chavel.activity.LoginRegister;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.CommentFragment;
import com.twentyfour.chavel.service.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {

    Toolbar toolbar;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_activity, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);


        toolbar.setTitle("Mr.Chavel");
       // setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return rootView;
    }


}
