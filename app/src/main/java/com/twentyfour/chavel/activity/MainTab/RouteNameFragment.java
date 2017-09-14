package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.twentyfour.chavel.BusProvider.BusProvider;
import com.twentyfour.chavel.Event.Events_Desc;
import com.twentyfour.chavel.Event.Events_Route_Name;
import com.twentyfour.chavel.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RouteNameFragment extends Fragment {

    Toolbar toolbar;
    EditText dt_route_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getInstance().register(this);
        setRetainInstance(true);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route_name, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        dt_route_name = (EditText) rootView.findViewById(R.id.dt_route_name);


        toolbar.setTitle("Route Name*");
        //setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Events_Route_Name.Events_RoutNameFragmentMessage fragmentActivityMessageEvent =
                        new Events_Route_Name.Events_RoutNameFragmentMessage(dt_route_name.getText().toString());
                BusProvider.getInstance().post(fragmentActivityMessageEvent);
                getActivity().onBackPressed();

            }
        });


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }


}
