package com.twentyfour.chavel.activity.LoginRegister;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;
import com.twentyfour.chavel.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class VerifySendEnterEmailAgainActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.txt_time)
    TextView txt_time;

    @Bind(R.id.ed_code)
    EditText ed_code;

    @Bind(R.id.ls_send_code_again)
    LinearLayout ls_send_code_again;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertifi_again);

        ButterKnife.bind(this);

        toolbar.setTitle("VertificationSendEnterEmail");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        long maxTimeInMilliseconds = 90000;// in your case

        startTimer(maxTimeInMilliseconds, 1000);

        ed_code.addTextChangedListener(new TextWatcher() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {


                    ls_send_code_again.setBackground(getResources().getDrawable(R.drawable.bg_unselected, null));
                } else {

                    ls_send_code_again.setBackground(getResources().getDrawable(R.drawable.bg_selected, null));

                }


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

    }

    public void startTimer(final long finish, long tick) {
        CountDownTimer t;
        t = new CountDownTimer(finish, tick) {

            public void onTick(long millisUntilFinished) {
                long remainedSecs = millisUntilFinished / 1000;
                txt_time.setText(""+(remainedSecs % 60));// manage it accordign to you
            }

            public void onFinish() {
                txt_time.setText("00");
                cancel();
            }
        }.start();
    }



}
