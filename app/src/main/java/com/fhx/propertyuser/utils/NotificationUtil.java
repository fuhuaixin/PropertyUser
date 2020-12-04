package com.fhx.propertyuser.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

/**
 * 通知栏开启util
 */
public class NotificationUtil {



    //调用该方法获取是否开启通知栏权限
    public void goToNotificationSetting(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
            try {
                Intent intent = new Intent();
                String action  = Settings.ACTION_APP_NOTIFICATION_SETTINGS;
                intent.setAction(action);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID, context.getApplicationInfo().uid);
                context.startActivity(intent);
            } catch (Exception e) {
                toPermissionSetting(context);
            }
        } else {
            toPermissionSetting(context);
        }
    }
    /**
     * 跳转到权限设置
     *
     * @param activity
     */
    private void toPermissionSetting(Context activity) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            toSystemConfig(activity);
        } else {
            try {
                toApplicationInfo(activity);
            } catch (java.lang.Exception e) {
//                L.printStackTrace(e)
                toSystemConfig(activity);
            }
        }
    }
    /**
     * 应用信息界面
     *
     * @param activity
     */
    private void toApplicationInfo( Context activity) {
        try {
            Intent localIntent = new Intent();
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            String action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS;
            localIntent.setAction(action);
            Uri url = Uri.fromParts("package", activity.getPackageName(), null);
            localIntent.setDataAndNormalize(url) ;
            activity.startActivity(localIntent);
        } catch ( java.lang.Exception e) {
            Log.e("exception",e.toString());
        }
    }

    /**
     * 系统设置界面
     *
     * @param activity
     */
    private void toSystemConfig( Context activity) {
        try {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            activity.startActivity(intent);
        } catch (java.lang.Exception e) {
           Log.e("exception",e.toString());
        }
    }

}
