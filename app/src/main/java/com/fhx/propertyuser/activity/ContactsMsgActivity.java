package com.fhx.propertyuser.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.EmployeeDetailBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 联系人详情
 */
public class ContactsMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private TextView tv_name,tv_dutyName,tv_employeeNo,tv_phone,tv_mail,tv_nation,tv_birthday;
    private String id;
    @Override
    protected int initLayout() {
        return R.layout.activity_contacts_msg;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_dutyName = (TextView) findViewById(R.id.tv_dutyName);
        tv_employeeNo = (TextView) findViewById(R.id.tv_employeeNo);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_mail = (TextView) findViewById(R.id.tv_mail);
        tv_nation = (TextView) findViewById(R.id.tv_nation);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
    }

    @Override
    protected void initData() {
        tvTitle.setText("联系人详情");
        id =getIntent().getStringExtra("jumpOne");

        getDetails();
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }

    /**
     * 获取成员详情信息
     */
    private void getDetails(){
        EasyHttp.get(AppUrl.EmployeeDetail)
                .syncRequest(false)
                .params("id",id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        EmployeeDetailBean employeeDetailBean = JSON.parseObject(s, EmployeeDetailBean.class);
                        if (employeeDetailBean.isSuccess()) {
                            EmployeeDetailBean.DataBean data = employeeDetailBean.getData();
                            tv_name.setText(data.getEmployeeName());
                            ;//0 =女  1=男
                          /*  switch (data.getSex()) {
                                case "0":
                                    tv_sex.setText("女");
                                    break;
                                case "1":
                                    tv_sex.setText("男");
                                    break;

                            }*/
                            tv_dutyName.setText(data.getDutyName());
                            tv_employeeNo.setText(data.getEmployeeNo());
                            tv_phone.setText(data.getPhone());
                            tv_nation.setText(data.getNation());
                            tv_birthday.setText(data.getBirthday());
                            tv_mail.setText(data.getMail());


                        } else {
                            ToastShort(employeeDetailBean.getMsg());
                        }
                    }
                });
    }
}
