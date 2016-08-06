package com.ajk.douch;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * Created by ahnju on 2016-08-01.
 */
public class SplashActivity extends AppCompatActivity

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler hd = new Handler() {
            public void handleMessage(Message msg){
                finish();
            }
        };hd.sendEmptyMessageDelayed(0, 3000);
    }
}