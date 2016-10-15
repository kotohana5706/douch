package com.ajk.douch;

import android.app.ActionBar;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.usage.NetworkStats;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {

    Usr usr;
    Call<Usr> usrLogin, usrPw, usrApi, usrName;
    String apikey;
    NetworkInterface networkInterface;
    Retrofit retrofit;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    private long backPressed;
    public List<Usr> usrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,SplashActivity.class));
        setContentView(R.layout.activity_login);
        retrofit = new Retrofit.Builder().baseUrl("http://5ymphony.com:5413/").addConverterFactory(GsonConverterFactory.create()).build();
        networkInterface = retrofit.create(NetworkInterface.class);
    }


    private void doLogin(){
        EditText idField = (EditText) findViewById(R.id.login_id);
        EditText pwField = (EditText) findViewById(R.id.login_pw);
        String idText = idField.getText().toString().trim();
        String pwText = pwField.getText().toString().trim();
        if (idText.equals("")){ idField.setError("전화번호를 입력하세요");}
        if (pwText.equals("")){ idField.setError("pw를 입력하세요");}
        if (!idText.equals("") && !pwText.equals("")){
        usrLogin = networkInterface.userLogin(idText, pwText);
        usrLogin.enqueue(new Callback<Usr>() {
                @Override
                public void onResponse(Call<Usr> call, Response<Usr> response) {
                    switch (response.code()){
                        case 200:
                            String getName = response.body().name;
                            String getNum = response.body().num;
                            String getApi = response.body().apikey;
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.putExtra("loginName", getName);
                            i.putExtra("loginApi", getApi);
                            i.putExtra("loginNum", getNum);
                            startActivity(i);
                            finish();
                            break;
                        default :
                            Toast.makeText(login.this, "휴대전화 번호, PW를 확인해 주십시오", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Usr> call, Throwable t) {
                    Toast.makeText(login.this, "ServerError", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



    public void onClickReg(View v){
        startActivity(new Intent(this, RegisterActivity.class));
    }
    public void onClickLogin(View v){
        doLogin();
    }
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - backPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(getApplicationContext(), "뒤로가기를 두번 누르면 종료합니다.", Toast.LENGTH_LONG).show();
        backPressed = System.currentTimeMillis();
    }
}
