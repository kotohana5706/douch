package com.ajk.douch;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahnju on 2016-10-07.j
 */
public class TodoActivity extends AppCompatActivity{

    public String usrName, usrNum, usrApi;
    ArrayList<Todo> todoArrayList;
    protected void onCreate(Bundle savedInstanceState){
        Intent getIntent = getIntent();
        usrName = getIntent.getExtras().getString("todoName");
        usrNum = getIntent.getExtras().getString("todoNum");
        usrApi = getIntent.getExtras().getString("todoApi");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

    }

}
