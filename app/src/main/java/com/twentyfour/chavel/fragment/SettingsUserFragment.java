package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.RouteActivity;
import com.twentyfour.chavel.adapter.MyActivityProfileAdapter;
import com.twentyfour.chavel.model.ModelActivityProfile;

import java.util.ArrayList;


public class SettingsUserFragment extends Fragment {

    TextView txt_status;
    TextView txt_activity;
    LinearLayout ls_activity;
    LinearLayout ls_route;
    LinearLayout ls_raverit;
    LinearLayout ls_more;

    boolean isFollowing = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_user_fragment, null);
        txt_status = (TextView) view.findViewById(R.id.txt_status);
        txt_activity = (TextView) view.findViewById(R.id.txt_activity);
        ls_activity = (LinearLayout) view.findViewById(R.id.ls_activity);
        ls_route = (LinearLayout) view.findViewById(R.id.ls_route);
        ls_raverit = (LinearLayout) view.findViewById(R.id.ls_raverit);
        ls_more = (LinearLayout) view.findViewById(R.id.ls_more);

        String styledText = "<u><font color='red'>Activity</font></u>.";
        txt_status.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting, null));
        txt_activity.setTextColor(Color.WHITE);


        ActivityProfileUserFragment fragment = new ActivityProfileUserFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

        return view;
    }

    public void toggleFollowing(LinearLayout v) {
        v.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting, null));

        // change state
        v.setSelected(true);
        v.setPressed(false);

    }

    public void toggleUnfollow(LinearLayout v) {
        v.setBackground(getResources().getDrawable(R.drawable.bg_unselected_setting, null));

        // change state
        v.setSelected(false);
        v.setPressed(false);

    }
}
