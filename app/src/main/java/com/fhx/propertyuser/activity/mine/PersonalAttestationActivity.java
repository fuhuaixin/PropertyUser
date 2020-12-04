package com.fhx.propertyuser.activity.mine;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.AuditListBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.PostRequest;

/**
 * 个人认证
 */
public class PersonalAttestationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle, tv_commit,tv_msg,tv_phone;
    private RadioGroup rg_house, rg_sex;
    private EditText et_name, et_floor, et_roomNo;
    private LinearLayout ll_null;
    private NestedScrollView scrollView;
    private String auditId;
    private int ifAudit;
    private int chooseHouse = 1; //判断那个人员类型被选中 1业主2物业职员3其他职员4访客]
    private int chooseSex = 0; //判断性别  0男 1女

    @Override
    protected int initLayout() {
        return R.layout.activity_personal_attestation;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_commit = (TextView) findViewById(R.id.tv_commit);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        et_name = (EditText) findViewById(R.id.et_name);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        et_floor = (EditText) findViewById(R.id.et_floor);
        et_roomNo = (EditText) findViewById(R.id.et_roomNo);

        rg_house = (RadioGroup) findViewById(R.id.rg_house);
        scrollView = (NestedScrollView) findViewById(R.id.scrollView);
        ll_null = (LinearLayout) findViewById(R.id.ll_null);

    }

    @Override
    protected void initData() {
        ifAudit = getIntent().getIntExtra("ifAudit", 0);
        if (ifAudit == 0) {
            ll_null.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        } else if (ifAudit==1) {
            ll_null.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            getInfo();
        }else if (ifAudit==2) {
            ll_null.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
            tv_msg.setText("审核不通过 点击重新上传");
            tv_msg.setOnClickListener(this);
        }else if (ifAudit==3) {
            ll_null.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
            tv_msg.setText("审核中，请耐心等待");
        }
        tvTitle.setText("个人认证");
        tv_phone.setText(mmkv.decodeString("userPhone"));
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_commit.setOnClickListener(this);
        rg_house.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_house_one:
                        chooseHouse = 1;
                        break;
                    case R.id.rb_house_two:
                        chooseHouse = 2;
                        break;
                    case R.id.rb_house_three:
                        chooseHouse = 3;
                        break;
                    case R.id.rb_house_four:
                        chooseHouse = 4;
                        break;
                }
            }
        });
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_sex_one:
                        chooseSex = 0;
                        break;
                    case R.id.rb_sex_two:
                        chooseSex = 1;
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finishActivity();
                break;
            case R.id.tv_commit:
                if (TextUtils.isEmpty(et_name.getText().toString())){
                    ToastShort("请输入姓名");
                    return;
                }
                if (TextUtils.isEmpty(et_roomNo.getText().toString())){
                    ToastShort("请输入房间号");
                    return;
                }
                commit();
                break;
            case R.id.tv_msg:
                ll_null.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 提交参数
     */
    private void commit() {
        PostRequest post = null;
        switch (ifAudit) {
            case 0:
                post = EasyHttp.post(AppUrl.AuditAdd);
                break;
            case 1:
                post = EasyHttp.post(AppUrl.AuditReAdd);
                post.params("auditId", auditId);
                break;
        }

        post.params("name", et_name.getText().toString())
                .params("sex", String.valueOf(chooseSex))
                .params("phone", tv_phone.getText().toString())
                .params("floor", et_floor.getText().toString())
                .params("roomNo", et_roomNo.getText().toString())
                .params("type", String.valueOf(chooseHouse))
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("提交成功");
                            finishActivity();
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }


    /**
     * 请求个人信息
     */
    private void getInfo() {
        EasyHttp.get(AppUrl.AuditList)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "1")
                .params("info", mmkv.decodeString("userPhone"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        AuditListBean bean = JSON.parseObject(s, AuditListBean.class);
                        if (bean.isSuccess()) {
                            if (bean.getData().getRecords() != null && bean.getData().getRecords().size() > 0) {
                                AuditListBean.DataBean.RecordsBean recordsBean = bean.getData().getRecords().get(0);
                                et_name.setText(recordsBean.getName());
                                tv_phone.setText(recordsBean.getPhone());
                                et_floor.setText(recordsBean.getFloor());
                                et_roomNo.setText(recordsBean.getRoomNo());
                                auditId = recordsBean.getAuditId();
                                if (recordsBean.getSex()!=null){
                                    switch (recordsBean.getSex()) {
                                        case "0":
                                            rg_sex.check(R.id.rb_sex_one);
                                            break;
                                        case "1":
                                            rg_sex.check(R.id.rb_sex_two);
                                            break;
                                    }
                                }


                                switch (recordsBean.getType()) {
                                    case "1":
                                        rg_house.check(R.id.rb_house_one);
                                        break;
                                    case "2":
                                        rg_house.check(R.id.rb_house_two);
                                        break;
                                    case "3":
                                        rg_house.check(R.id.rb_house_three);
                                        break;
                                    case "4":
                                        rg_house.check(R.id.rb_house_four);
                                        break;
                                }
                            }
                        } else {
                            ToastShort(bean.getMsg());
                        }
                    }
                });
    }
}
