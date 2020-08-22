package com.fhx.propertyuser.activity.login;

import android.os.Handler;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.CutToUtils;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable(){
            public void run(){
                CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
                finish();
            }
        },2000);
    }

    @Override
    protected void initData() {
        setSwipeBackEnable(false);
    }

    @Override
    protected void initListen() {

    }
}