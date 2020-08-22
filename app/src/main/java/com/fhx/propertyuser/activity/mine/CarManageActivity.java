package com.fhx.propertyuser.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.CarManageAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.CarManageBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆管理
 */
public class CarManageActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle,tv_add_car;
    private RecyclerView recycle_car;
    private CarManageAdapter carManageAdapter;
    private List<CarManageBean> manageList =new ArrayList<>();

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
    protected void initData() {
        tvTitle.setText("车辆管理");
        for (int i = 0; i < 4; i++) {
            manageList.add(new CarManageBean("豫A8888"+i,"红旗F"+i,"","","车主"+i,"","",""));
        }
        carManageAdapter =new CarManageAdapter(manageList);
        recycle_car.setLayoutManager(new LinearLayoutManager(this));
        recycle_car.setAdapter(carManageAdapter);

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_add_car.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_add_car:
                CutToUtils.getInstance().JumpTo(CarManageActivity.this,CarAttestationActivity.class);
                break;
        }
    }
}
