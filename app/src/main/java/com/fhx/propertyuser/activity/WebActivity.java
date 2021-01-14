package com.fhx.propertyuser.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.UpdatePhotoAlbumUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * web通用页
 */
public class WebActivity extends BaseActivity {
    private TextView tvTitle;
    private ImageView imageLeft;
    private ImageView imageRight;
    private WebView webView;

    private String title, url;
    private WebSettings settings;

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_back);
        imageRight = (ImageView) findViewById(R.id.image_right);
        webView = (WebView) findViewById(R.id.webview);

    }

    @Override
    protected void initData() {
        //提示
        dialog();

        title = getIntent().getStringExtra("jumpOne");
        url = getIntent().getStringExtra("jumpTwo");
        Log.e("fhxx", url);
        if (title.equals("访客邀约")) {
            imageRight.setImageResource(R.mipmap.icon_share);
        }

        tvTitle.setText(title);
        webView.loadUrl(url);
//        webView.loadUrl("file:///android_asset/web.html");
        webView.addJavascriptInterface(WebActivity.this, "AndroidJs");
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                zLoadingDialog.show();
            }

            //WebView发起的WEB请求因为网络原因失败时回调
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                zLoadingDialog.dismiss();
            }

            //WebView发起的WEB请求收到服务器的错误消息时回调
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                zLoadingDialog.dismiss();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                zLoadingDialog.dismiss();
                webView.loadUrl("javascript:getAllPick()");
            }
        });

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });

        imageRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBitmap(bitmap);
            }
        });
    }

    Bitmap bitmap;

    @JavascriptInterface
    public void setImage(String str) {
        Log.e("fhxx", "网页获取 -----》" + str);

        byte[] decode = Base64.decode(str.split(",")[1], Base64.DEFAULT);
        bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);


    }

    /**
     * 保存至手机
     */
    FileOutputStream out;
    String bitmapName = "fenxiang.jpg";

    public void saveBitmap(Bitmap bmp) {

        try { // 获取SDCard指定目录下
            String sdCardDir = Environment.getExternalStorageDirectory() + "/downLoad/";
            File dirFile = new File(sdCardDir);  //目录转化成文件夹
            if (!dirFile.exists()) {              //如果不存在，那就建立这个文件夹
                dirFile.mkdirs();
            }                          //文件夹有啦，就可以保存图片啦
            File file = new File(sdCardDir, bitmapName);// 在SDcard的目录下创建图片文,以当前时间为其命名
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
            Log.e("saveBitMap", "saveBitmap: 图片保存到" + Environment.getExternalStorageDirectory() + "/downLoad/" + bitmapName);

            // 下载完成  刷新到图库
            UpdatePhotoAlbumUtil.updatePhotoAlbum(WebActivity.this, file);

            PullWX();
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Toast.makeText(HahItemActivity.this,"保存已经至"+Environment.getExternalStorageDirectory()+"/CoolImage/"+"目录文件夹下", Toast.LENGTH_SHORT).show();
    }


    /**
     * 拉起微信
     */
    private void PullWX() {
        Intent lan = getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(lan.getComponent());
        startActivity(intent);
    }
}
