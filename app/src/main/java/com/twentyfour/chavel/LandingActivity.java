package com.twentyfour.chavel;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.activity.LoginRegister.FindContactFriendsActivity;
import com.twentyfour.chavel.activity.LoginRegister.LoginActivity;
import com.twentyfour.chavel.activity.LoginRegister.RegisterActivity;
import com.twentyfour.chavel.service.BaseActivity;

public class LandingActivity extends BaseActivity {

    TextView txt_conti;
    LinearLayout login;
    LinearLayout sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        login = (LinearLayout) findViewById(R.id.login);
        sign_up = (LinearLayout) findViewById(R.id.sign_up);
        txt_conti = (TextView) findViewById(R.id.txt_conti);

        String styledText = "<u><font color='#395997'>Continue</font></u>.";
        txt_conti.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);

            }
        });

        txt_conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FindContactFriendsActivity.class);
                startActivity(i);
            }
        });

    }

    public static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            Log.e("sum", sum + "");
        }
        return sum;
    }
}
