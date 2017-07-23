package com.chavel.chavel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.chavel.chavel.R;

public class WhatsYourEmailOrPhoneActivity extends AppCompatActivity {

    LinearLayout ls_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_address);
        ls_next = (LinearLayout) findViewById(R.id.ls_next);


        ls_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VertificationSendEnterEmailActivity.class);
                startActivity(intent);
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
