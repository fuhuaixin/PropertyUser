package com.fhx.propertyuser.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.fhx.propertyuser.MainActivity;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.login.LoginActivity;
import com.tencent.mmkv.MMKV;

public class ResultTipDialog extends Dialog {

    private ImageView image_header,image_close;
    private TextView tv_title,tv_login;

    private String title,msg;
    private int imageHeader =-1;

    private String type;
    private Activity activity;
    private MMKV mmkv;

    public ResultTipDialog(@NonNull Activity context, String type) {
        super(context, R.style.TipDialog);
        this.type =type;
        this.activity =context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_result_tip);
        mmkv =MMKV.defaultMMKV();
        setCancelable(false);
        initViews();
        initDatas();
        refreshView();
    }



    private void initViews() {
        image_header =findViewById(R.id.image_header);
        image_close =findViewById(R.id.image_close);
        tv_title =findViewById(R.id.tv_title);
        tv_login =findViewById(R.id.tv_login);
    }

    private void initDatas() {
        if (type.equals("login")){
            tv_login.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
            tv_login.getPaint().setAntiAlias(true);//抗锯齿);
            tv_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityControl.getInstance().closeAll();
                    mmkv.removeValueForKey("token");
                    mmkv.removeValueForKey("customerId");
                    mmkv.removeValueForKey("userPhone");
                    mmkv.removeValueForKey("password");
                    CutToUtils.getInstance().JumpTo(activity, LoginActivity.class);
                }
            });
            image_close.setVisibility(View.GONE);
        }else if (type.equals("recharge")){
            image_close.setVisibility(View.VISIBLE);
            tv_login.setTextColor(activity.getResources().getColor(R.color.tv666));
        }

        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();
        refreshView();
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void refreshView() {
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
            tv_title.setVisibility(View.VISIBLE);
        }else {
            tv_title.setVisibility(View.GONE);
        }
        if (imageHeader!=-1){
            image_header.setImageResource(imageHeader);
            image_header.setVisibility(View.VISIBLE);
        }else {
            image_header.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(msg)){
            tv_login.setText(msg);
            tv_login.setVisibility(View.VISIBLE);
        }else {
            tv_login.setVisibility(View.GONE);
        }
    }

    public String getTitle() {
        return title;
    }

    public ResultTipDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getImageHeader() {
        return imageHeader;
    }

    public ResultTipDialog setImageHeader(int imageHeader) {
        this.imageHeader = imageHeader;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultTipDialog setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
