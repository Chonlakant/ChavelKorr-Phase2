package com.twentyfour.chavel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.twentyfour.chavel.MainActivity;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.SettingSystemActivity;
import com.twentyfour.chavel.activity.HolderActivity;
import com.twentyfour.chavel.activity.LoginRegister.LoginActivity;
import com.twentyfour.chavel.activity.MainTab.EditProfileActivity;
import com.twentyfour.chavel.adapter.ExploreGridAdapter;
import com.twentyfour.chavel.adapter.FeedListAdapter;
import com.twentyfour.chavel.adapter.MyActivityProfileAdapter;
import com.twentyfour.chavel.data.Constant;
import com.twentyfour.chavel.data.Tools;
import com.twentyfour.chavel.model.Feed;
import com.twentyfour.chavel.model.ModelActivityProfile;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PageProfileFragment extends Fragment {
    private View view;

    RecyclerView recyclerView;
    List<Feed> items = new ArrayList<>();

    MyActivityProfileAdapter myActivityProfileAdapter;
    ArrayList<ModelActivityProfile> mActivityList = new ArrayList<>();

    @Bind(R.id.bt_grid)
    ImageView bt_grid;
    @Bind(R.id.bt_list)
    ImageView bt_list;
    @Bind(R.id.bt_places)
    ImageView bt_places;
    @Bind(R.id.bt_tags)
    ImageView bt_tags;

    @Bind(R.id.edit_profile_btn)
    Button editProfileBtn;

//    @Nullable
//    @OnClick({R.id.bt_grid,R.id.bt_list,R.id.bt_places,R.id.bt_tags})
    void actionClick(View v) {
        if (v.getId() == R.id.bt_grid) {
            //switchGridMode();
            switchMyActivityMode();
        } else if (v.getId() == R.id.bt_list) {
            switchMyRouteMode();
        } else if (v.getId() == R.id.bt_places) {
            switchMyFavMode();
        } else if (v.getId() == R.id.bt_tags) {
            Snackbar.make(view, "More Clicked", Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(view, "Tab Clicked", Snackbar.LENGTH_SHORT).show();
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_profile, container, false);
        //ButterKnife.bind(view,getActivity());
        // activate fragment menu
        setHasOptionsMenu(true);

        items = Constant.getListMyFeed(getActivity(), 15);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        switchMyActivityMode();

        bt_grid = (ImageView) view.findViewById(R.id.bt_grid);
        bt_list = (ImageView) view.findViewById(R.id.bt_list);
        bt_places = (ImageView) view.findViewById(R.id.bt_places);
        bt_tags = (ImageView) view.findViewById(R.id.bt_tags);

        editProfileBtn = (Button) view.findViewById(R.id.edit_profile_btn);

        bt_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick(v);
            }
        });

        bt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick(v);
            }
        });

        bt_places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick(v);
            }
        });

        bt_tags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick(v);
            }
        });

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

    private void switchMyRouteMode() {

        Intent i = new Intent(getActivity(), HolderActivity.class);
        i.putExtra("index",1);
        getActivity().startActivity(i);

    }

    private void switchMyFavMode(){
        Intent i = new Intent(getActivity(), HolderActivity.class);
        i.putExtra("index",2);
        getActivity().startActivity(i);
    }

    private void switchMyActivityMode() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i <= 10; i++) {
            ModelActivityProfile modelPins = new ModelActivityProfile();
            modelPins.setTitle("Your Friend Name");
            modelPins.setContent("ผู้นำ ฉลุย สุนทรีย์ มหภาคทอมเอนทรานซ์ อันเดอร์มั้งฮากกาฟลุก นรีแพทย์แซว");
            modelPins.setTime("15:0" + i);
            mActivityList.add(modelPins);
            myActivityProfileAdapter = new MyActivityProfileAdapter(getActivity(), mActivityList);
            recyclerView.setAdapter(myActivityProfileAdapter);
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about: {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("About");
                builder.setMessage(getString(R.string.about_text));
                builder.setNeutralButton("OK", null);
                builder.show();
                return true;
            } case R.id.action_login: {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                return true;
            } case R.id.action_settings: {
                Intent i = new Intent(getActivity(), SettingSystemActivity.class);
                startActivity(i);
                //Snackbar.make(view, "Setting Clicked", Snackbar.LENGTH_SHORT).show();

                return true;
            } case R.id.action_help: {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

}
