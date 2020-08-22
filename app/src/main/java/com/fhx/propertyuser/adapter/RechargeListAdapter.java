package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.RechargeListBean;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class RechargeListAdapter extends BaseQuickAdapter<RechargeListBean, BaseViewHolder> {
    public RechargeListAdapter(@Nullable List<RechargeListBean> data) {
        super(R.layout.adapter_recharge_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RechargeListBean item) {

        helper.setText(R.id.tv_title,item.getTitle());

        helper.setImageResource(R.id.image_title,item.getImage());

        helper.addOnClickListener(R.id.ll_item);
    }
}
