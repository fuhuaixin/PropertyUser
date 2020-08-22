package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.OrderMsgBean;

import java.util.List;

public class OrderMsgAdapter extends BaseQuickAdapter<OrderMsgBean, BaseViewHolder> {

    public OrderMsgAdapter(@Nullable List<OrderMsgBean> data) {
        super(R.layout.adapter_order_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderMsgBean item) {
        helper.setText(R.id.tv_type,item.getPayType())
                .setText(R.id.tv_name,item.getName())
                .setText(R.id.tv_home_no,item.getHomeNo())
                .setText(R.id.tv_address,item.getAddress())
                .setText(R.id.tv_unit,item.getUnit())
                .setText(R.id.tv_time,item.getTime())
                .setText(R.id.tv_total,"￥"+item.getNeedPay());
    }
}
