package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twentyfour.chavel.R;


public class SearchMutiTypeFragment extends Fragment {



    Toolbar toolbar;
    TextView text_location;


    public static SearchMutiTypeFragment newInstance() {
        return new SearchMutiTypeFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_muti_type_activity, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        text_location = (TextView) rootView.findViewById(R.id.text_location);

        toolbar.setTitle("Search Location");
      //  setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        String styledText = "<u><font color='#2F4F4F'>Location</font></u>.";
        text_location.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        return rootView;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_phone_email, menu);
//
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        return super.onOptionsItemSelected(item);
//    }

}
