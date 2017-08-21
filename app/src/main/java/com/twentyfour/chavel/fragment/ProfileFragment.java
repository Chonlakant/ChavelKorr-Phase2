package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.EditProfileActivity;
import com.twentyfour.chavel.activity.MainTab.ProfileActivity;
import com.twentyfour.chavel.SettingSystemActivity;


public class ProfileFragment extends Fragment {

    TextView txt_status;
    TextView txt_activity;
    TextView txt_my_route;
    TextView txt_fav_route;
    LinearLayout ls_activity;
    LinearLayout ls_route;
    LinearLayout ls_fav;
    LinearLayout ls_more;
    LinearLayout ls_edit_profile;
    ImageView photo;

    boolean isFollowing = false;

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).hideToolbar();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, null);
        setHasOptionsMenu(true);
        photo = (ImageView) view.findViewById(R.id.photo);
        txt_status = (TextView) view.findViewById(R.id.txt_status);
        txt_activity = (TextView) view.findViewById(R.id.txt_activity);
        ls_activity = (LinearLayout) view.findViewById(R.id.ls_activity);
        txt_my_route = (TextView) view.findViewById(R.id.txt_my_route);
        ls_route = (LinearLayout) view.findViewById(R.id.ls_my_route);
        txt_fav_route = (TextView) view.findViewById(R.id.txt_fav_route);
        ls_fav = (LinearLayout) view.findViewById(R.id.ls_fav);
        ls_more = (LinearLayout) view.findViewById(R.id.ls_more);
        ls_edit_profile = (LinearLayout) view.findViewById(R.id.ls_edit_profile);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(), ProfileActivity.class);
                startActivity(i);
            }
        });

        ls_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabActivityFragment fragment = new TabActivityFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container2, fragment);
                transaction.commit();

                String styledTextActivity = "<u><font color='#aaa'>Activity</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);

            }
        });

        ls_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeFragment fragment = new HomeFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container2, fragment);
                transaction.commit();

                String styledTextActivity = "<u><font color='#aaa'>My route</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);

            }
        });

        ls_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container2, fragment);
                transaction.commit();

                String styledTextActivity = "<u><font color='#aaa'>Favorite</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);
                ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting1, null));

            }
        });

        String styledTextActivity = "<u><font color='#aaa'>Activity</font></u>";
        txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);
        ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting1, null));
        txt_activity.setTextColor(Color.WHITE);

        TabActivityFragment fragment = new TabActivityFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

        ls_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(i);
            }
        });

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(getActivity(), SettingSystemActivity.class);
                startActivity(i);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
