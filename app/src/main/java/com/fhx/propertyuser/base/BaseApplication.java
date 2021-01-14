package com.fhx.propertyuser.base;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.multidex.MultiDex;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.WebSocketBean;
import com.fhx.propertyuser.utils.JWebSocketClient;
import com.fhx.propertyuser.utils.NotificationClickReceiver;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.mmkv.MMKV;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.GsonDiskConverter;

import java.net.URI;

import static com.scwang.smartrefresh.layout.SmartRefreshLayout.setDefaultRefreshFooterCreator;
import static com.scwang.smartrefresh.layout.SmartRefreshLayout.setDefaultRefreshHeaderCreator;

public class BaseApplication extends Application {

    //推送
    private JWebSocketClient client;
    private URI uri;
    static {
        //设置全局的Header构建器
        setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, R.color.tv333);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //分包
        MultiDex.install(this);
        //网络请求
        EasyHttp.init(this);//默认初始化,必须调用

        EasyHttp.getInstance()

                //可以全局统一设置全局URL
                .setBaseUrl(AppUrl.BASEURL)//设置全局URL  url只能是域名 或者域名+端口号

                // 打开该调试开关并设置TAG,不需要就不要加入该行
                // 最后的true表示是否打印内部异常，一般打开方便调试错误
                .debug("EasyHttp", true)

                //如果使用默认的60秒,以下三行也不需要设置
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 100)
                .setConnectTimeout(60 * 100)
                .setCacheDiskConverter(new GsonDiskConverter())
                //可以全局统一设置超时重连次数,默认为3次,那么最差的情况会请求4次(一次原始请求,三次重连请求),
                //不需要可以设置为0
                .setRetryCount(3)//网络不好自动重试3次
                //可以全局统一设置超时重试间隔时间,默认为500ms,不需要可以设置为0
                .setRetryDelay(500)//每次延时500ms重试
                //可以全局统一设置超时重试间隔叠加时间,默认为0ms不叠加
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setCertificates();                                 //方法一：信任所有证书,不安全有风险


        //MMKV 本地存取数据 代替sp
        String initMMKV = MMKV.initialize(this);
        MMKV mmkv = MMKV.defaultMMKV();
        Log.e("MMKV 初始化", initMMKV);

        //设置通知类型
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "chat";
            String channelName = "聊天消息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);

            channelId = "subscribe";
            channelName = "订阅消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);
        }

        //推送 也可以做即时通讯
        uri= URI.create("ws://192.168.10.219:8083/websocket/"+mmkv.decodeString("customerId"));
        client= new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                //message就是接收到的消息
                Log.e("JWebSClientService", message);
                sendChatMsg(message);
            }
        };
        connect();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }


    //WebSocket开启连接
    private void connect(){
        try {
            client.connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private  int  requestCode=0;
    public void sendChatMsg(String msg) {
        WebSocketBean webSocketBean = JSON.parseObject(msg, WebSocketBean.class);
        requestCode++;
        Intent intent = new Intent(this, NotificationClickReceiver.class);
        Log.e("fhxx","这是我准备发送的"+msg +" -----  >"+requestCode);
        intent.putExtra("msg",msg);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "chat")
                .setContentTitle(webSocketBean.getType())
                .setContentText(webSocketBean.getContent())
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.icon_logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_logo))
                .setDefaults(Notification.GROUP_ALERT_ALL) //设置默认的提示音，振动方式，灯光
                .setAutoCancel(true)
                .setContentIntent(broadcast)
                .build();
        manager.notify(requestCode, notification);

    }

}
