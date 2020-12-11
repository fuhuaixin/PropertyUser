package com.fhx.propertyuser.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationClickReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("msg");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.e("fhxx","这是我收到的-"+msg);
    }
}
