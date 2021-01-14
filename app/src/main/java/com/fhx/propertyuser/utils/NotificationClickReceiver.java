package com.fhx.propertyuser.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.MainActivity;
import com.fhx.propertyuser.activity.ComplainMsgActivity;
import com.fhx.propertyuser.activity.NotificationActivity;
import com.fhx.propertyuser.activity.RepairMsgActivity;
import com.fhx.propertyuser.activity.WebActivity;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseApplication;
import com.fhx.propertyuser.bean.WebSocketBean;

public class NotificationClickReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
//
        if (!SystemUtils.isAppAlive(context, context.getPackageName())) {
            Intent intentInit = context.getPackageManager()
                    .getLaunchIntentForPackage(context.getPackageName());
            context.startActivity(intentInit);
        }

        String msg = intent.getStringExtra("msg");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.e("fhxx", "这是我收到的-" + msg);
        WebSocketBean webSocketBean = JSON.parseObject(msg, WebSocketBean.class);
        switch (webSocketBean.getType()) {
            case "repaire":
                Intent intentRepair = new Intent(context, RepairMsgActivity.class);
                intentRepair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentRepair.putExtra("jumpOne", "0");
                intentRepair.putExtra("jumpTwo", webSocketBean.getId());
                context.startActivity(intentRepair);
                break;
            case "complain":
                Intent intentComp = new Intent(context, ComplainMsgActivity.class);
                intentComp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentComp.putExtra("jumpOne", "0");
                intentComp.putExtra("jumpTwo", webSocketBean.getId());
                context.startActivity(intentComp);
                break;
            case "news":
                Intent intentNews = new Intent(context, WebActivity.class);
                intentNews.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentNews.putExtra("jumpOne", "新闻");
                intentNews.putExtra("jumpTwo", AppUrl.NEWSTITLEURL + webSocketBean.getId());
                context.startActivity(intentNews);
                break;
        }
    }
}
