package com.fhx.propertyuser.adapter;

import android.widget.BaseAdapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.CarManageBean;

import java.util.List;

public class CarManageAdapter extends BaseQuickAdapter<CarManageBean, BaseViewHolder> {
    public CarManageAdapter( @Nullable List<CarManageBean> data) {
        super(R.layout.adapter_car_manage, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarManageBean item) {
        helper.setText(R.id.tv_number,item.getCarNumber());
    }
}
