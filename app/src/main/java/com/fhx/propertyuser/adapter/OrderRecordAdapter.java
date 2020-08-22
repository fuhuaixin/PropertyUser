package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.OrderListBean;
import com.fhx.propertyuser.bean.OrderRecordBean;

import java.util.List;

public class OrderRecordAdapter extends BaseQuickAdapter<OrderRecordBean, BaseViewHolder> {
    public OrderRecordAdapter(@Nullable List<OrderRecordBean> data) {
        super(R.layout.adapter_order_record, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderRecordBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_type, "(" + item.getType() + ")")
                .setText(R.id.tv_time, item.getTime())
                .setText(R.id.tv_total, "￥" + item.getTotal());

        helper.addOnClickListener(R.id.rl_item);
    }
}
