package com.fhx.propertyuser.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.CutToUtils;
import com.fhx.propertyuser.utils.ListDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 充值详情
 */
public class RechargeMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle,tv_toPay;
    private EditText edit_recharge;
    private ListDialog listDialog;

    private List<String > diaList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_recharge_msg;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_toPay = (TextView) findViewById(R.id.tv_toPay);
        edit_recharge = (EditText) findViewById(R.id.edit_recharge);
    }

    @Override
    protected void initData() {
        tvTitle.setText("充值缴费");
        diaList.add("支付宝");
        diaList.add("微信");
        diaList.add("其他");
        listDialog = new ListDialog(this, diaList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                listDialog.dismiss();
            }
        });
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_toPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_toPay:
               if (!TextUtils.isEmpty(edit_recharge.getText().toString())){
                   listDialog.show();
               }else {
                   ToastShort("请输入金额");
               }
                break;
        }
    }
}
