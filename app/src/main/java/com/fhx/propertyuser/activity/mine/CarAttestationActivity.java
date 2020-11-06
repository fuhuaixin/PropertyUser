package com.fhx.propertyuser.activity.mine;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.CarMsgBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.CutToUtils;
import com.fhx.propertyuser.utils.ListDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆认证
 */
public class CarAttestationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private TextView tv_car_type;
    private TextView tv_commit;
    private EditText et_car_number, et_car_name, et_owner_phone, et_parking_no;
    private LinearLayout ll_car_type;

    private ListDialog listDialog;
    private List<String> carTypeList = new ArrayList<>();//车辆类型

    private String carId;

    @Override
    protected int initLayout() {
        return R.layout.activity_car_attestation;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_commit = (TextView) findViewById(R.id.tv_commit);
        tv_car_type = (TextView) findViewById(R.id.tv_car_type);
        ll_car_type = (LinearLayout) findViewById(R.id.ll_car_type);
        et_car_number = (EditText) findViewById(R.id.et_car_number);
        et_car_name = (EditText) findViewById(R.id.et_car_name);
        et_owner_phone = (EditText) findViewById(R.id.et_owner_phone);
        et_parking_no = (EditText) findViewById(R.id.et_parking_no);
    }

    @Override
    protected void initData() {
        carId = getIntent().getStringExtra("jumpOne");
        tvTitle.setText("车辆认证");

        if (!carId.equals("-1")) {
            getCarMsg();
        }

        carTypeList.add("签约车辆");
        carTypeList.add("认证车辆");
        carTypeList.add("临时车辆");
        listDialog = new ListDialog(this, carTypeList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                tv_car_type.setText(carTypeList.get(position));
                listDialog.dismiss();
            }
        });
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        ll_car_type.setOnClickListener(this);
        tv_commit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finishActivity();
                break;
            case R.id.ll_car_type:
                listDialog.show();
                break;
            case R.id.tv_commit:
                if (TextUtils.isEmpty(et_car_number.getText().toString())) {
                    ToastShort("请输入车牌号");
                    return;
                }
                if (TextUtils.isEmpty(et_car_name.getText().toString())) {
                    ToastShort("请输入车主姓名");
                    return;
                }
                if (TextUtils.isEmpty(et_owner_phone.getText().toString())) {
                    ToastShort("请输入车主电话");
                    return;
                }

                if (!carId.equals("-1")) {
                    EditCarMsg(); //修改提交
                } else {
                    upCar();//添加车辆
                }
                break;

        }
    }

    /**
     * 提交车辆信息
     */
    private void upCar() {
        EasyHttp.post(AppUrl.CarAdd)
                .syncRequest(false)
                .params("carNo", et_car_number.getText().toString())
                .params("customerId", mmkv.decodeString("customerId"))
                .params("carOwner", et_car_name.getText().toString())
                .params("ownerPhone", et_owner_phone.getText().toString())
                .params("parkingNo", et_parking_no.getText().toString())
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
                            finishActivity();
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }


    /**
     * 获取车辆信息
     */
    private void getCarMsg() {
        EasyHttp.get(AppUrl.CarDetail)
                .syncRequest(false)
                .params("id", carId)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        CarMsgBean carMsgBean = JSON.parseObject(s, CarMsgBean.class);
                        if (carMsgBean.isSuccess()) {
                            et_car_number.setText(carMsgBean.getData().getCarNo());
                            et_car_name.setText(carMsgBean.getData().getCarOwner());
                            et_owner_phone.setText(carMsgBean.getData().getOwnerPhone());
                            switch (carMsgBean.getData().getCarType()) {
                                case "0":
                                    tv_car_type.setText("临时车");
                                    break;
                                case "1":
                                    tv_car_type.setText("登记车");
                                    break;
                                case "2":
                                    tv_car_type.setText("认证签约车");
                                    break;
                                default:
                                    tv_car_type.setText("未知");
                                    break;
                            }
                            et_parking_no.setText(carMsgBean.getData().getParkingNo());
                        } else {
                            ToastShort(carMsgBean.getMsg());
                        }
                    }
                });
    }


    /**
     * 修改车辆信息
     */
    private void EditCarMsg() {
        EasyHttp.post(AppUrl.CarEdit)
                .syncRequest(false)
                .params("carId", carId)
                .params("carNo", et_car_number.getText().toString())
                .params("customerId", mmkv.decodeString("customerId"))
                .params("carOwner", et_car_name.getText().toString())
                .params("ownerPhone", et_owner_phone.getText().toString())
                .params("parkingNo", et_parking_no.getText().toString())
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
                            finishActivity();
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }

}
