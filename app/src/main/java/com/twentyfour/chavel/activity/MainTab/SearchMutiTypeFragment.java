package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.adapter.ViewPagerAdapterNoti;
import com.twentyfour.chavel.fragment.FollowingFragment;
import com.twentyfour.chavel.fragment.YouFragment;


public class SearchMutiTypeFragment extends Fragment {


    Toolbar toolbar;
    TextView text_location;

    TabLayout tabLayoutSearch;
    ViewPager viewPagerSearch;
    LinearLayout ls_ad;
    EditText et_search;
    ImageView img_back;


    String[] iconsNoti = {"Top", "People", "Location", "RID"};


    public static SearchMutiTypeFragment newInstance() {
        return new SearchMutiTypeFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_muti_type_activity, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ls_ad = (LinearLayout) rootView.findViewById(R.id.ls_ad);
        et_search = (EditText) rootView.findViewById(R.id.et_search);
        img_back = (ImageView) rootView.findViewById(R.id.img_back);


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        tabLayoutSearch = (TabLayout) rootView.findViewById(R.id.tab_layout1);
        viewPagerSearch = (ViewPager) rootView.findViewById(R.id.main_tab_content1);
        viewPagerSearch.setOffscreenPageLimit(5);
        setupviewPagerSearch(viewPagerSearch);

        tabLayoutSearch.setupWithViewPager(viewPagerSearch);

        for (int i = 0; i < iconsNoti.length; i++) {
            tabLayoutSearch.getTabAt(i).setText(iconsNoti[i]);

        }
        tabLayoutSearch.getTabAt(0).select();

        viewPagerSearch.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutSearch));
        tabLayoutSearch.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        viewPagerSearch.setCurrentItem(0);
                        et_search.setText("Top");
                        break;
                    case 1:
                        viewPagerSearch.setCurrentItem(1);
                        et_search.setText("People");
                        break;
                    case 2:
                        viewPagerSearch.setCurrentItem(2);
                        et_search.setText("Location");
                        break;
                    case 3:
                        viewPagerSearch.setCurrentItem(3);
                        et_search.setText("RID");
                        break;

                    default:

                        viewPagerSearch.setCurrentItem(tab.getPosition());
                        et_search.setText("Search Location");
                        break;
                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ls_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdvanceSearchFragment profileFragment = new AdvanceSearchFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container6, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        return rootView;
    }

    private void setupviewPagerSearch(ViewPager viewPager1) {
        ViewPagerAdapterNoti adapter = new ViewPagerAdapterNoti(getFragmentManager());
        adapter.insertNewFragment(new SearchFragmentAdvance());
        adapter.insertNewFragment(new SearchFragmentAdvance());
        adapter.insertNewFragment(new SearchFragmentAdvance());
        adapter.insertNewFragment(new SearchFragmentAdvance());
        viewPager1.setAdapter(adapter);

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
