package com.twentyfour.chavel.activity.MainTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.twentyfour.chavel.BusProvider.BusProvider;
import com.twentyfour.chavel.Event.Events_Route_Activity;
import com.twentyfour.chavel.Event.Events_Route_Suggestion;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.service.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SuggestionFragment extends Fragment {


    Toolbar toolbar;
    EditText edit2;
    String Suggestion;
    TextView txt_put_suggestion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getBus().register(this);
        setRetainInstance(true);

    }


    public static SuggestionFragment newInstance() {
        return new SuggestionFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_suggestion, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        txt_put_suggestion = (TextView) rootView.findViewById(R.id.txt_put_suggestion);
        edit2 = (EditText) rootView.findViewById(R.id.edit2);

        toolbar.setTitle("Suggestion");
        //  setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suggestion = txt_put_suggestion.getText() + edit2.getText().toString();
                Events_Route_Suggestion.Events_RoutSuggestionFragmentMessage fragmentActivityMessageEvent = new Events_Route_Suggestion.Events_RoutSuggestionFragmentMessage(Suggestion);
                BusProvider.getBus().post(fragmentActivityMessageEvent);
                getActivity().onBackPressed();
            }
        });
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        BusProvider.getBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getBus().unregister(this);
    }

}
