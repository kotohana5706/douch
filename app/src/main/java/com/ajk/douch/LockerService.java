package com.ajk.douch;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Created by ahnju on 2016-09-14.
 */
public class LockerService extends Service {

    private LockerReceiver mReceiver = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mReceiver = new LockerReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mReceiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if(intent != null){
            if(intent.getAction()==null){
                if(mReceiver == null){
                    mReceiver = new LockerReceiver();
                    IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
                    registerReceiver(mReceiver, filter);
                }
            }
        }
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        if(mReceiver !=null){
            unregisterReceiver(mReceiver);
        }
    }

}
