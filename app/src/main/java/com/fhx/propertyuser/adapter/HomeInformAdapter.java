package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.HomeInformBean;

import java.util.List;

public class HomeInformAdapter extends BaseQuickAdapter<HomeInformBean, BaseViewHolder> {
    public HomeInformAdapter( @Nullable List<HomeInformBean> data) {
        super(R.layout.adapter_home_inform, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeInformBean item) {
        helper.setText(R.id.tv_type,item.getType())
                .setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_time,item.getTime())
                .setText(R.id.tv_msg,item.getMsg());

        helper.addOnClickListener(R.id.ll_item);
    }
}
