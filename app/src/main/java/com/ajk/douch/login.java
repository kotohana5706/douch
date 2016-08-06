package com.ajk.douch;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private NfcAdapter mNfcAdapter;
    private PendingIntent pIntent;
    private IntentFilter[] iFilter;
    private String[][] mNfcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,SplashActivity.class));
        setContentView(R.layout.activity_login);
    }

    public void onClickF(View v){
        Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
        finish();
    }
}
