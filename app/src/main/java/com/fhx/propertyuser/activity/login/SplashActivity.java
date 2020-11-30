package com.fhx.propertyuser.activity.login;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.MainActivity;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.LoginBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.CutToUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.lang.ref.WeakReference;

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
        new Handler().postDelayed(new Runnable() {
            public void run() {
//                finish();
                if (mmkv.decodeString("userPhone")!=null&& !TextUtils.isEmpty(mmkv.decodeString("userPhone"))
                &&mmkv.decodeString("password")!=null &&!TextUtils.isEmpty(mmkv.decodeString("password"))){
                    autoLogin();
                }else {
                    CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
                }
            }
        }, 2000);
    }

    @Override
    protected void initData() {
        setSwipeBackEnable(false);
    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void autoLogin(){
        EasyHttp.post(AppUrl.Login)
                .params("phone",mmkv.decodeString("userPhone"))
                .params("password",mmkv.decodeString("password"))
                .syncRequest(false)
                .execute(new SimpleCallBack<String >() {
                    @Override
                    public void onError(ApiException e) {
                        CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
                    }

                    @Override
                    public void onSuccess(String s) {
                        LoginBean successBean = JSON.parseObject(s, LoginBean.class);
                        if (successBean.isSuccess()){
                            CutToUtils.getInstance().JumpTo(SplashActivity.this, MainActivity.class);
                            mmkv.encode("token",successBean.getData().getToken());
                            mmkv.encode("customerId",successBean.getData().getPeople().getPeopleId());
                        }else {
                            CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);

                        }
                    }
                });
    }

}