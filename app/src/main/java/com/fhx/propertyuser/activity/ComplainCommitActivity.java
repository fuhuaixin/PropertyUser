package com.fhx.propertyuser.activity;

import android.app.DatePickerDialog;
import android.text.TextUtils;
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
import com.fhx.propertyuser.bean.ComplainTypeBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.ListDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.PostRequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 我要投诉
 */
public class ComplainCommitActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private LinearLayout ll_complain_type;
    private TextView tv_complain_type, tv_happen_time, tv_hope_Time, tv_toPay;
    private EditText et_room, et_name, et_number, et_content, et_hope_result;

    private List<String> mEventTypeList = new ArrayList<>();
    private List<String> mEventTypeIdList = new ArrayList<>();
    private ListDialog listDialog;
    private String mEventTypeId;

    private Calendar c;//获取当前时间
    int year;
    int mouth;
    int day;

    @Override
    protected int initLayout() {
        return R.layout.activity_complain_commit;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_complain_type = (TextView) findViewById(R.id.tv_complain_type);
        tv_happen_time = (TextView) findViewById(R.id.tv_happen_time);
        tv_hope_Time = (TextView) findViewById(R.id.tv_hope_Time);
        tv_toPay = (TextView) findViewById(R.id.tv_toPay);
        ll_complain_type = (LinearLayout) findViewById(R.id.ll_complain_type);
        et_room = (EditText) findViewById(R.id.et_room);
        et_name = (EditText) findViewById(R.id.et_name);
        et_number = (EditText) findViewById(R.id.et_number);
        et_content = (EditText) findViewById(R.id.et_content);
        et_hope_result = (EditText) findViewById(R.id.et_hope_result);
    }

    @Override
    protected void initData() {
        tvTitle.setText("提交投诉");
        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        year = c.get(Calendar.YEAR);
        mouth = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        getType();//获取类型
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        ll_complain_type.setOnClickListener(this);
        tv_happen_time.setOnClickListener(this);
        tv_hope_Time.setOnClickListener(this);
        tv_toPay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_happen_time:
                new DatePickerDialog(ComplainCommitActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_happen_time.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, year, mouth, day).show();
                break;
            case R.id.tv_hope_Time:
                new DatePickerDialog(ComplainCommitActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_hope_Time.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, year, mouth, day).show();
                break;
            case R.id.ll_complain_type:
                listDialog = new ListDialog(this, mEventTypeList, new ListDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        tv_complain_type.setText(mEventTypeList.get(position));
                        mEventTypeId = mEventTypeIdList.get(position);
                        listDialog.dismiss();
                    }
                });
                listDialog.show();
                break;
            case R.id.tv_toPay:

                if (TextUtils.isEmpty(et_room.getText())) {
                    ToastShort("请填写房间号");
                    return;
                }
                if (TextUtils.isEmpty(et_name.getText())) {
                    ToastShort("请填写上报人姓名");
                    return;
                }
                if (TextUtils.isEmpty(et_number.getText())) {
                    ToastShort("请填写上报人电话");
                    return;
                }
                if (tv_complain_type.getText().toString().equals("请选择 >")) {
                    ToastShort("请选择投诉类型");
                    return;
                }
                if (TextUtils.isEmpty(et_content.getText())) {
                    ToastShort("请填写投诉内容");
                    return;
                }
                if (TextUtils.isEmpty(et_hope_result.getText())) {
                    ToastShort("请填写希望解决方案或结果");
                    return;
                }

                commit();
                break;
        }
    }

    /**
     * 获取投诉类型
     */
    private void getType() {
        EasyHttp.get(AppUrl.ComplaintType)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "50")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        ComplainTypeBean complainTypeBean = JSON.parseObject(s, ComplainTypeBean.class);
                        if (complainTypeBean.isSuccess()) {
                            List<ComplainTypeBean.DataBean.RecordsBean> records = complainTypeBean.getData().getRecords();
                            for (int i = 0; i < records.size(); i++) {
                                mEventTypeList.add(records.get(i).getComplaintTypeName());
                                mEventTypeIdList.add(records.get(i).getComplaintTypeId());
                            }
                        } else {
                            ToastShort(complainTypeBean.getMsg());
                        }
                    }
                });
    }




    /**
     * 提交投诉表单
     */
    private void commit() {
        PostRequest post = EasyHttp.post(AppUrl.ComplaintAdd);
        if (!tv_hope_Time.getText().toString().equals("请选择 >")) {
            post.params("hopeTime", tv_hope_Time.getText().toString());
        }
        if (!tv_happen_time.getText().toString().equals("请选择 >")) {
            post.params("happenTime", tv_happen_time.getText().toString());
        }
        post.syncRequest(false)
                .params("customerId", mmkv.decodeString("customerId"))
                .params("complainTypeId", mEventTypeId)
                .params("complainTypeName", tv_complain_type.getText().toString())
                .params("spaceNo", et_room.getText().toString())
                .params("customerPhone", et_number.getText().toString())
                .params("content", et_content.getText().toString())
                .params("hopeResult", et_hope_result.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("提交成功");
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });

    }


}
