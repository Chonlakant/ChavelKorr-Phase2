package com.twentyfour.chavel.activity.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.activity.LoginRegister.FindContactFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.LoginActivity;
import com.twentyfour.chavel.activity.LoginRegister.RegisterActivity;
import com.twentyfour.chavel.service.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandingActivity extends BaseActivity {

    @Bind(R.id.txt_conti)
    TextView txt_conti;

    @Bind(R.id.login)
    LinearLayout login;

    @Bind(R.id.sign_up)
    LinearLayout sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        String styledText = "<u><font color='#395997'>Login</font></u>";
        txt_conti.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogin();
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRegister();
            }
        });

        txt_conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toFindContact();
            }
        });

    }

}
