package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.MainTab.CommentFragment;
import com.twentyfour.chavel.activity.MainTab.EditProfileFragment;
import com.twentyfour.chavel.activity.LoginRegister.ProfileFragment;


public class UserProfileFragment extends AppCompatActivity {

    Toolbar toolbar;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile_fragment);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Mr.Chavel");

        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
       // toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        photo = (ImageView) findViewById(R.id.photo);
        txt_status = (TextView) findViewById(R.id.txt_status);
        txt_activity = (TextView) findViewById(R.id.txt_activity);
        ls_activity = (LinearLayout) findViewById(R.id.ls_activity);

        txt_my_route = (TextView) findViewById(R.id.txt_my_route);
        ls_route = (LinearLayout) findViewById(R.id.ls_my_route);
        txt_fav_route = (TextView) findViewById(R.id.txt_fav_route);
        ls_fav = (LinearLayout) findViewById(R.id.ls_fav);
        ls_more = (LinearLayout) findViewById(R.id.ls_more);
        ls_edit_profile = (LinearLayout) findViewById(R.id.ls_edit_profile);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ProfileFragment profileFragment = new ProfileFragment();
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container5, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        ls_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                FollowingFragment fragment = new FollowingFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();

                String styledTextActivity = "<u><font color='#cccccc'>Favorite</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);

            }
        });

        ls_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                TabMyRouteFragment fragment1 = new TabMyRouteFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container2, fragment1);
//                transaction.commit();

                String styledTextActivity = "<u><font color='#aaa'>My route</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);

            }
        });

        ls_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TabMyRouteFragment fragment = new TabMyRouteFragment();
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container2, fragment);
//                transaction.commit();
//
//                String styledTextActivity = "<u><font color='#aaa'>Favorite</font></u>";
//                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);
//                ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting1, null));

                Intent i = new Intent(getApplicationContext(), CommentFragment.class);
                startActivity(i);

            }
        });

        String styledTextActivity = "<u><font color='#aaa'>Activity</font></u>";
        txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);
        ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting1, null));
        txt_activity.setTextColor(Color.WHITE);

        FollowingFragment fragment = new FollowingFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

        ls_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditProfileFragment profileFragment = new EditProfileFragment();
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container5, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


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

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_fragment_profile, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                Intent i = new Intent(getApplicationContext(), SettingSystemActivity.class);
//                startActivity(i);
//                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
