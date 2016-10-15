package com.ajk.douch;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ahnju on 2016-08-02.
 */
public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private long backPressed;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<mData> mDataset;
    NfcAdapter mNfcAdapter = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());
    private Date date = new Date();
    public String todayStr = dateFormat.format(date);
    public String usrApi, usrName, usrNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent authIntent = getIntent();
        usrApi = authIntent.getExtras().getString("loginApi");
        usrName = authIntent.getExtras().getString("loginName");
        usrNum = authIntent.getExtras().getString("loginNum");
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view) ;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mDataset = new ArrayList<>();
        recyclerViewAdapter = new rcAdapter(mDataset);
        recyclerView.setAdapter(recyclerViewAdapter);
        mDataset.add(new mData("2016-09-30", "05:00", "06:30", "R&E"));

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

    public void onClickMG(View v){
        Intent sendGroup = new Intent(this, GroupActivity.class);
        sendGroup.putExtra("groupName", usrName);
        sendGroup.putExtra("groupNum", usrNum);
        sendGroup.putExtra("groupApi", usrApi);
        startActivity(sendGroup);
    }
    public void onClickMT(View v){
        Intent sendTodo = new Intent(this, TodoActivity.class);
        sendTodo.putExtra("todoName", usrName);
        sendTodo.putExtra("todoNum", usrNum);
        sendTodo.putExtra("todoApi", usrApi);
        startActivity(sendTodo);
    }
    public void onClickMS(View v){
        startActivity(new Intent(this, AlterActivity.class));
    }

}