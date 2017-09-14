package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/fragment/UserProfileFragment.java
import com.twentyfour.chavel.activity.MainTab.CommentActivity;
import com.twentyfour.chavel.activity.MainTab.EditProfileFragment;
import com.twentyfour.chavel.activity.LoginRegister.ProfileFragment;
import com.twentyfour.chavel.activity.SettingSystemActivity;


public class UserProfileFragment extends AppCompatActivity {

    Toolbar toolbar;
=======
import com.twentyfour.chavel.activity.MainTab.EditProfileActivity;
import com.twentyfour.chavel.activity.MainTab.ProfileActivity;
import com.twentyfour.chavel.SettingSystemActivity;


public class ProfileFragment extends Fragment {
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/fragment/ProfileFragment.java

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
<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/fragment/UserProfileFragment.java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile_fragment);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Mr.Chavel");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        // toolbar.setNavigationIcon(R.drawable.ic_back);


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
=======
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
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/fragment/ProfileFragment.java

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

                String styledTextActivity = "<u><font color='#aaa'>Activity</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);

            }
        });

        ls_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/fragment/UserProfileFragment.java
                TabMyRouteFragment2 fragment1 = new TabMyRouteFragment2();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment1);
=======
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container2, fragment);
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/fragment/ProfileFragment.java
                transaction.commit();

                String styledTextActivity = "<u><font color='#aaa'>My route</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);

            }
        });

        ls_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD:app/src/main/java/com/twentyfour/chavel/fragment/UserProfileFragment.java
//                TabMyRouteFragment fragment = new TabMyRouteFragment();
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container2, fragment);
//                transaction.commit();
//
//                String styledTextActivity = "<u><font color='#aaa'>Favorite</font></u>";
//                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);
//                ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting1, null));


                Intent i =new Intent(getApplicationContext(),CommentActivity.class);
                startActivity(i);
=======
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container2, fragment);
                transaction.commit();

                String styledTextActivity = "<u><font color='#aaa'>Favorite</font></u>";
                txt_status.setText(Html.fromHtml(styledTextActivity), TextView.BufferType.SPANNABLE);
                ls_activity.setBackground(getResources().getDrawable(R.drawable.bg_selected_setting1, null));
>>>>>>> korrio/master:app/src/main/java/com/twentyfour/chavel/fragment/ProfileFragment.java



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

        ls_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingSystemActivity.class);
                startActivity(i);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fragment_profile, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.action_settings:

                Intent i = new Intent(getApplicationContext(), SettingSystemActivity.class);
                startActivity(i);

                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
