package com.fhx.propertyuser.activity;

import android.graphics.Bitmap;
import android.view.View;
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


/**
 * web通用页
 */
public class WebActivity extends BaseActivity {
    private TextView tvTitle;
    private ImageView imageLeft;
    private WebView webView;

    private String title,url;
    private WebSettings settings;

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_back);
        webView = (WebView) findViewById(R.id.webview);
        title =getIntent().getStringExtra("jumpOne");
        url =getIntent().getStringExtra("jumpTwo");
    }

    @Override
    protected void initData() {
        dialog();
        tvTitle.setText(title);
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
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
            }
        });
        webView.loadUrl(url);
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
    }
}
