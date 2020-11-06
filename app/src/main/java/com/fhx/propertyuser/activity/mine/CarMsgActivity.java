package com.fhx.propertyuser.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.CarMsgBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 汽车详情界面
 */
public class CarMsgActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageView imageBack;
    private TextView tv_car_no, tv_owner_name, tv_owner_phone, tv_car_type, tv_parking_no;
    private String carId;

    @Override
    protected int initLayout() {
        return R.layout.activity_car_msg;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageBack = (ImageView) findViewById(R.id.image_back);
        tv_car_no = (TextView) findViewById(R.id.tv_car_no);
        tv_owner_name = (TextView) findViewById(R.id.tv_owner_name);
        tv_owner_phone = (TextView) findViewById(R.id.tv_owner_phone);
        tv_car_type = (TextView) findViewById(R.id.tv_car_type);
        tv_parking_no = (TextView) findViewById(R.id.tv_parking_no);
    }

    @Override
    protected void initData() {
        tvTitle.setText("车辆信息详情");
        carId = getIntent().getStringExtra("jumpOne");
        getCarMsg();
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finishActivity();
                break;
        }
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
                            tv_car_no.setText(carMsgBean.getData().getCarNo());
                            tv_owner_name.setText(carMsgBean.getData().getCarOwner());
                            tv_owner_phone.setText(carMsgBean.getData().getOwnerPhone());
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
                            tv_parking_no.setText(carMsgBean.getData().getParkingNo());
                        } else {
                            ToastShort(carMsgBean.getMsg());
                        }
                    }
                });
    }


}
