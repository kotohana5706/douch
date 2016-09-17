package com.ajk.douch;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by ahnju on 2016-09-14.
 */
public class LockscreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lockscreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

    }
}
