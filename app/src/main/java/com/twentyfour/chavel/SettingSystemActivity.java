package com.twentyfour.chavel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.FindContactFacebookFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.FindContactFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.FindFacebookFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.FindPeopleActivity;
import com.twentyfour.chavel.activity.MainTab.EditProfileActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class  SettingSystemActivity extends BaseActivity {

    Toolbar toolbar;

    @Bind(R.id.menuInviteFriends)
    LinearLayout menuInviteFriends;

    @Bind(R.id.menuInviteFBFriends)
    LinearLayout menuInviteFBFriends;

    @Bind(R.id.menuFollowFriend)
    LinearLayout menuFollowFriend;

    @Bind(R.id.menuFollowFBFriend)
    LinearLayout menuFollowFBFriend;

    @Bind(R.id.menuEditMyProfile)
    LinearLayout menuEditMyProfile;

    @OnClick(R.id.menuEditMyProfile)
    void onMenuEditMyProfile(View view) {
        Intent i = new Intent(this, EditProfileActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.menuInviteFriends)
    void onMenuInviteFriendsClick(View view) {
        Intent i = new Intent(this, FindContactFacebookFriendsActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.menuInviteFBFriends)
    void onMenuInviteFBFriendsClick(View view) {
        Intent i = new Intent(this, FindPeopleActivity.class);
        startActivity(i);
    }


    @OnClick(R.id.menuFollowFriend)
    void onMenuFollowFriendClick(View view) {
        Intent i = new Intent(this, FindContactFriendsActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.menuFollowFBFriend)
    void onMenuFollowFBFriendClick(View view) {
        Intent i = new Intent(this, FindFacebookFriendsActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {

            toolbar.setTitle("Settings");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

        }


    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

}
