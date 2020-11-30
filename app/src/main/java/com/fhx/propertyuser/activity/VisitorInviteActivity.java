package com.fhx.propertyuser.activity;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.ListDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * 访客邀约
 */
public class VisitorInviteActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private EditText et_visitor_name, et_visitor_phone, et_room;
    private TextView tv_come_date, tv_reason,tv_commit;

    private Calendar c;//获取当前时间
    int year;
    int mouth;
    int day;

    private List<String> mEventTypeList = new ArrayList<>();
    private ListDialog listDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_visitor_invite;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_come_date = (TextView) findViewById(R.id.tv_come_date);
        tv_reason = (TextView) findViewById(R.id.tv_reason);
        tv_commit = (TextView) findViewById(R.id.tv_commit);
        et_visitor_name = (EditText) findViewById(R.id.et_visitor_name);
        et_visitor_phone = (EditText) findViewById(R.id.et_visitor_phone);
        et_room = (EditText) findViewById(R.id.et_room);
    }

    @Override
    protected void initData() {
        tvTitle.setText("访客邀约");

        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        year = c.get(Calendar.YEAR);
        mouth = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        mEventTypeList.add("面试");
        mEventTypeList.add("洽谈");
        mEventTypeList.add("会友");
        mEventTypeList.add("其他");
        listDialog = new ListDialog(this, mEventTypeList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {

                tv_reason.setText(mEventTypeList.get(position));
                listDialog.dismiss();

            }
        });

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_come_date.setOnClickListener(this);
        tv_reason.setOnClickListener(this);
        tv_commit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finishActivity();
                break;
            case R.id.tv_reason:
                listDialog.show();
                break;
            case R.id.tv_come_date:
                new DatePickerDialog(VisitorInviteActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_come_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, year, mouth, day).show();
                break;
            case R.id.tv_commit:
                if (TextUtils.isEmpty(et_visitor_name.getText().toString())){
                    ToastShort("请输入访客姓名");
                    return;
                }
                if (TextUtils.isEmpty(et_visitor_phone.getText().toString())){
                    ToastShort("请输入访客电话");
                    return;
                }
                if (tv_come_date.getText().toString().equals("请选择 >")){
                    ToastShort("请选择来访日期");
                    return;
                }
                if (tv_reason.getText().toString().equals("请选择 >")){
                    ToastShort("请选择来访事由");
                    return;
                }
                VisitorAdd();
                break;
        }
    }

    /**
     * 提交访客邀约
     */

    private void VisitorAdd(){
        HashMap<String, String> params = new HashMap<>();
        params.put("guestName", et_visitor_name.getText().toString());
        params.put("comeDay", tv_come_date.getText().toString());
        params.put("guestPhone", et_visitor_phone.getText().toString());
        params.put("room", et_room.getText().toString());
        params.put("origin", tv_reason.getText().toString());
        params.put("promoter",mmkv.decodeString("userPhone"));
        JSONObject jsonObject = new JSONObject(params);
        EasyHttp.post(AppUrl.VisitorAdd)
                .syncRequest(false)
                .upJson(jsonObject.toString())
                .execute(new SimpleCallBack<String >() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            ToastShort("提交成功"+successBean.getData().toString());
//                            finishActivity();
                        }else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });


    }
}
