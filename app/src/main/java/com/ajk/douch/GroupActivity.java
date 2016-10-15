package com.ajk.douch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahnju on 2016-10-06.
 */
public class GroupActivity extends AppCompatActivity {

    public String usrName, usrNum, usrApi;
    public String[] groupMem;
    Call<ArrayList<Group>> usrGroup;
    NetworkInterface networkInterface;
    Retrofit retrofit;
    GroupListViewAdapter adapter;
    ListView listview;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent getData = getIntent();
        usrName = getData.getExtras().getString("groupName");
        usrNum = getData.getExtras().getString("groupNum");
        usrApi = getData.getExtras().getString("groupApi");
        retrofit = new Retrofit.Builder().baseUrl("http://5ymphony.com:5413/").addConverterFactory(GsonConverterFactory.create()).build();
        networkInterface = retrofit.create(NetworkInterface.class);
        setContentView(R.layout.activity_group);
        doListView();
    }

    private void doListView(){
        usrGroup = networkInterface.groupGet(usrApi);
        usrGroup.enqueue(new Callback<ArrayList<Group>>() {
            @Override
            public void onResponse(Call<ArrayList<Group>> call, Response<ArrayList<Group>> response) {
                Integer resSize = response.body().size();
                Log.e("douch_json_data" ,resSize.toString());
                adapter = new GroupListViewAdapter(GroupActivity.this, response.body());
                listview = (ListView) findViewById(R.id.groupList);
                listview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Group>> call, Throwable t) {
                Log.e("DouchServerErr", t.toString());
                Toast.makeText(GroupActivity.this, "ServerError", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
