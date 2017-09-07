package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.fragment.NewRouteFragment;


public class NewRouteFragmentActivity extends FragmentActivity {

    public static final String KEY_PROFILE = "key_data";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_route_fragment);

                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_fragment_container, NewRouteFragment.newInstance())
                    .addToBackStack(null)
                    .commit();

    }




}
