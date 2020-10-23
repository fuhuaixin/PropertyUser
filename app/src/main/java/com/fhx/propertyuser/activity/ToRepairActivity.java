package com.fhx.propertyuser.activity;

import android.app.DatePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.RepairTypeListBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.ListDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 我要报修
 */
public class ToRepairActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private LinearLayout ll_event_type,ll_reserveTime;
    private TextView tv_eventType,tv_reserveTime,tv_toPay;
    private ListDialog listDialog;
    private EditText et_user_number,et_user_name,et_content,et_notes;

    private List<String> mEventTypeList = new ArrayList<>();
    private List<String> mEventTypeIdList = new ArrayList<>();
    private Calendar c;//获取当前时间
    private String eventTypeId;

    @Override
    protected int initLayout() {
        return R.layout.activity_ro_repair;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_eventType = (TextView) findViewById(R.id.tv_eventType);
        tv_reserveTime = (TextView) findViewById(R.id.tv_reserveTime);
        tv_toPay = (TextView) findViewById(R.id.tv_toPay);
        ll_event_type = (LinearLayout) findViewById(R.id.ll_event_type);
        ll_reserveTime = (LinearLayout) findViewById(R.id.ll_reserveTime);
        et_user_number = (EditText) findViewById(R.id.et_user_number);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_content = (EditText) findViewById(R.id.et_content);
        et_notes = (EditText) findViewById(R.id.et_notes);

    }

    @Override
    protected void initData() {
        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        tvTitle.setText("我要报修");
        getEventType();

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        ll_event_type.setOnClickListener(this);
        ll_reserveTime.setOnClickListener(this);
        tv_toPay.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.ll_event_type:
                listDialog = new ListDialog(this, mEventTypeList, new ListDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        tv_eventType.setText(mEventTypeList.get(position));
                        eventTypeId =mEventTypeIdList.get(position);
                        listDialog.dismiss();
                    }
                });
                listDialog.show();
                break;
            case R.id.ll_reserveTime:
                int year = c.get(Calendar.YEAR);
                int mouth = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(ToRepairActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tv_reserveTime.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                            }
                        },year,mouth,day).show();
                break;
            case R.id.tv_toPay:
                if (et_user_name.getText().toString().equals("")){
                    ToastShort("请输入报修人姓名");
                    return;
                }
                if (et_user_number.getText().toString().equals("")){
                    ToastShort("请输入报修人电话");
                    return;
                }
                if (tv_eventType.getText().toString().equals("请输入")){
                    ToastShort("请选择事件类型");
                    return;
                }
                if (et_notes.getText().toString().equals("")){
                    ToastShort("请选择事件地址");
                    return;
                }
                if (et_content.getText().toString().equals("")){
                    ToastShort("请输入问题描述");
                    return;
                }
                postRepair();
                break;
        }
    }

    /**
     * 获取时间类型
     */
    private void getEventType(){
        EasyHttp.get(AppUrl.RepairType)
                .syncRequest(false)
                .params("pageNum","1")
                .params("pageSize","50")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        RepairTypeListBean repairTypeListBean = JSON.parseObject(s, RepairTypeListBean.class);
                        if (repairTypeListBean.isSuccess()){
                            List<RepairTypeListBean.DataBean.RecordsBean> records = repairTypeListBean.getData().getRecords();
                            for (int i = 0; i < records.size(); i++) {
                                mEventTypeList.add(records.get(i).getRepairTypeName());
                                mEventTypeIdList.add(records.get(i).getRepairTypeId());
                            }

                        }else {
                            ToastShort(repairTypeListBean.getMsg());
                        }
                    }
                });
    }

    /**
     * 提交报修表单
     */
    private void postRepair(){
        EasyHttp.post(AppUrl.RepairAdd)
                .syncRequest(false)
                .params("originType","1")//区分用户端还是物业端 0物业  1用户
                .params("repairTypeId",eventTypeId)
                .params("repairTypeName",tv_eventType.getText().toString())
                .params("customerPhone",et_user_number.getText().toString())
                .params("customerName",et_user_name.getText().toString())
                .params("content",et_content.getText().toString())//描述
                .params("notes",et_notes.getText().toString())//地址
                .params("customerId",mmkv.decodeString("customerId")) //用户id
                .params("reserveTime",tv_reserveTime.getText().toString())//预约事件
                .execute(new SimpleCallBack<String >() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("提交成功");
                            finish();
                            overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });

    }

}
