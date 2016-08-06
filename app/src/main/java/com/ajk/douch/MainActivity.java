package com.ajk.douch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

/**
 * Created by ahnju on 2016-08-02.
 */
public class MainActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;
    private Toolbar toolbar;
    private long backPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,login.class));
        setContentView(R.layout.activity_main);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        setTitle("");

        toolbar = mViewPager.getToolbar();
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position %4){
                    default: return MainViewFragments.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Main";
                    case 1:
                        return "Group";
                    case 2:
                        return "Settings";
                    case 3:
                        return "About Me";
                }
                return "";
            }

        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "");
                }
                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null){
            logo.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "NOPE", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public void onBackPressed(){
        if (System.currentTimeMillis() - backPressed < 1500){
            finish();
            return;
        }
        Toast.makeText(getApplicationContext(), "뒤로가기를 두번 누르면 종료합니다.", Toast.LENGTH_LONG).show();
        backPressed = System.currentTimeMillis();
    }
}
