package com.fhx.propertyuser.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.login.LoginActivity;
import com.fhx.propertyuser.adapter.CarManageAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.CarManageBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.CommonDialog;
import com.fhx.propertyuser.utils.CutToUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆管理
 */
public class CarManageActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle, tv_add_car;
    private RecyclerView recycle_car;
    private CarManageAdapter carManageAdapter;
    private List<CarManageBean.DataBean.RecordsBean> manageList = new ArrayList<>();
    private CommonDialog commonDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_car_manage;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_add_car = (TextView) findViewById(R.id.tv_add_car);
        recycle_car = (RecyclerView) findViewById(R.id.recycle_car);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getCarList();
    }

    @Override
    protected void initData() {
        tvTitle.setText("车辆管理");

        carManageAdapter = new CarManageAdapter(manageList);
        recycle_car.setLayoutManager(new LinearLayoutManager(this));
        recycle_car.setAdapter(carManageAdapter);
        commonDialog = new CommonDialog(this);

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_add_car.setOnClickListener(this);
        carManageAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_item://车辆信息
                        CutToUtils.getInstance().JumpToOne(CarManageActivity.this, CarMsgActivity.class, manageList.get(position).getCarId());
                        break;
                    case R.id.tv_del://解除绑定
                        initDialog(manageList.get(position).getCarId());
                        break;
                    case R.id.tv_change://修改车辆信息
                        CutToUtils.getInstance().JumpToOne(CarManageActivity.this, CarAttestationActivity.class, manageList.get(position).getCarId());

                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_add_car:
                CutToUtils.getInstance().JumpToOne(CarManageActivity.this, CarAttestationActivity.class, "-1");
                break;
        }
    }

    /**
     * 获取车辆列表
     */
    private void getCarList() {
        EasyHttp.get(AppUrl.CarList)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "50")
                .params("customerId", mmkv.decodeString("customerId"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        CarManageBean carManageBean = JSON.parseObject(s, CarManageBean.class);
                        if (carManageBean.isSuccess()) {
                            manageList.clear();
                            manageList.addAll(carManageBean.getData().getRecords());
                            carManageAdapter.notifyDataSetChanged();
                        } else {
                            ToastShort(carManageBean.getMsg());
                        }
                    }
                });
    }

    /**
     * 解除车辆绑定
     */
    private void delCar(String id) {
        EasyHttp.delete(AppUrl.CarDel)
                .syncRequest(false)
                .params("id", id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("解除成功");
                            getCarList();
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }
    /**
     * 单双按钮弹窗
     */
    private void initDialog(final String id) {
        final CommonDialog dialog = new CommonDialog(CarManageActivity.this);
        dialog.setMessage("确定解除绑定么？")
                .setImageResId(-1)
                .setTitle("系统提示")
                .setSingle(false).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                delCar(id);
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
            }
        }).show();
    }
}
