package com.ajk.douch;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahnju on 2016-10-03.
 */
public class RegisterActivity extends AppCompatActivity{

    Usr usr;
    Call<Usr> usrReigser, usrPw, usrApi, usrName;
    String apikey;
    NetworkInterface networkInterface;
    Retrofit retrofit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        retrofit = new Retrofit.Builder().baseUrl("http://5ymphony.com:5413/").addConverterFactory(GsonConverterFactory.create()).build();
        networkInterface = retrofit.create(NetworkInterface.class);
    }

    private void doRegi(){
        EditText idField = (EditText) findViewById(R.id.register_id);
        EditText pwField = (EditText) findViewById(R.id.register_pw);
        EditText chkpwField = (EditText) findViewById(R.id.register_checkpw);
        EditText nameField = (EditText) findViewById(R.id.register_name);
        String idText = idField.getText().toString().trim();
        String pwText = pwField.getText().toString().trim();
        String chkpwText = chkpwField.getText().toString().trim();
        String nameText = nameField.getText().toString().trim();
        if (idText.equals("")){idField.setError("전화번호를 입력하세요");}
        else if (pwText.equals("")){pwField.setError("pw를 입력하세요");}
        else if (chkpwText.equals("")){chkpwField.setError("pw를 다시 입력해주세요");}
        else if (nameField.equals("")){nameField.setError("이름을 입력해주세요");}
        else if (!pwText.equals(chkpwText)){
            Toast.makeText(RegisterActivity.this, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();;}
        else{
            usrReigser = networkInterface.userRegister(idText, pwText, nameText);
            usrReigser.enqueue(new Callback<Usr>() {
                @Override
                public void onResponse(Call<Usr> call, Response<Usr> response) {
                    switch (response.code()){
                        case 200:
                            Toast.makeText(RegisterActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        case 402:
                            Toast.makeText(RegisterActivity.this, "중복된 전화번호입니다", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onFailure(Call<Usr> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "ConnectionError", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void onClickRegi(View v){
        doRegi();
    }

}
