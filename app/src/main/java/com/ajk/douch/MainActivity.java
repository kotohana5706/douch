package com.ajk.douch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.ArrayList;

/**
 * Created by ahnju on 2016-08-02.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    private Toolbar toolbar;
    private long backPressed;
    private ArrayList<rcData> rcDataset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, login.class));
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.MainCard);
        mRecyclerView.setHasFixedSize(true);
        mLayout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayout);
        mAdapter = new rcAdapter(rcDataset);
        mRecyclerView.setAdapter(mAdapter);

        rcDataset.add(new rcData("NOPE", R.drawable.img_group_none));
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