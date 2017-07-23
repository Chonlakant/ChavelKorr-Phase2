package com.chavel.chavel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.chavel.chavel.R;

public class FindFacebookFriendsActivity extends AppCompatActivity {

    LinearLayout ls_findfacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_facebook);

        ls_findfacebook = (LinearLayout) findViewById(R.id.ls_follow);


        ls_findfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(getApplicationContext(),FindContactFacebookFriendsActivity.class);
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
