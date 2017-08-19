package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.twentyfour.chavel.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import butterknife.Bind;


public class AddPinFragment extends Fragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    ImageView btn_expand_toggle;
    private ExpandableLayout expandableLayout0;

    ImageView img_next;


    public static AddPinFragment newInstance() {
        return new AddPinFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_pin_activity, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        img_next = (ImageView) rootView.findViewById(R.id.img_next);
        expandableLayout0 = (ExpandableLayout) rootView.findViewById(R.id.expandable_layout_0);
        btn_expand_toggle = (ImageView) rootView.findViewById(R.id.btn_expand_toggle);

        toolbar.setTitle("Add Pin");
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

        btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableLayout0.isExpanded()) {
                    expandableLayout0.collapse();
                    btn_expand_toggle.setImageResource(R.drawable.ic_down);
                } else {
                    expandableLayout0.expand();
                    btn_expand_toggle.setImageResource(R.drawable.ic_up);
                }
            }
        });

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditPinFragment editPinActivity = new EditPinFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container8, editPinActivity);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_pin_activity);
//        ButterKnife.bind(this);
//
//
//    }
//
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
