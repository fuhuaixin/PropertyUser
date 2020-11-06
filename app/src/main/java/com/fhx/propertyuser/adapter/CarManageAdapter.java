package com.fhx.propertyuser.adapter;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.CarManageBean;

import java.util.List;

public class CarManageAdapter extends BaseQuickAdapter<CarManageBean.DataBean.RecordsBean, BaseViewHolder> {
    public CarManageAdapter( @Nullable List<CarManageBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_car_manage, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarManageBean.DataBean.RecordsBean item) {
        helper.setText(R.id.tv_number,item.getCarNo());
        switch (item.getCarType()){
            case "0":
                helper.setText(R.id.tv_car_type,"临时车");
                break;
            case "1":
                helper.setText(R.id.tv_car_type,"登记车");
                break;
            case "2":
                helper.setText(R.id.tv_car_type,"认证签约车");
                break;
            default:
                helper.setText(R.id.tv_car_type,"未知");
                break;
        }

        helper.addOnClickListener(R.id.ll_item,R.id.tv_del,R.id.tv_change);
//
    }
}
