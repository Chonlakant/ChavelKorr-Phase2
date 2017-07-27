package com.twentyfour.chavel.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twentyfour.chavel.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class VertificationSendEnterActivity extends AppCompatActivity {

    EditText ed_code;
    LinearLayout ls_send_code_again;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.txt_send_count)
    TextView txt_send_count;

    @Bind(R.id.txt_time)
    TextView txt_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertifi_again);
        ButterKnife.bind(this);

        toolbar.setTitle("VertificationSendEnter");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        long maxTimeInMilliseconds = 30000;// in your case

        startTimer(maxTimeInMilliseconds, 1000);

        ls_send_code_again = (LinearLayout) findViewById(R.id.ls_send_code_again);

        ed_code = (EditText) findViewById(R.id.ed_code);

        Drawable drawable = ed_code.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if (Build.VERSION.SDK_INT > 16) {
            ed_code.setBackground(drawable); // set the new drawable to EditText

        } else {
            ed_code.setBackgroundDrawable(drawable);
        }

        ls_send_code_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), WhatsYourEmailActivity.class);
                startActivity(i);

            }
        });

        ed_code.addTextChangedListener(new TextWatcher() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {


                    txt_send_count.setText("Send Code Again");
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
