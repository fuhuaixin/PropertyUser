package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.OrderListBean;

import java.util.List;

public class OrderListAdapter extends BaseQuickAdapter<OrderListBean, BaseViewHolder> {
    public OrderListAdapter( @Nullable List<OrderListBean> data) {
        super(R.layout.adapter_order_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderListBean item) {
        helper.setText(R.id.tv_order_title,item.getTitle())
                .setText(R.id.tv_order_time,item.getTime())
                .setText(R.id.tv_total,"￥"+item.getTotal());


        if (item.getIfPay()==0){ //0未支付 1 已支付
            helper.setVisible(R.id.tv_toPay,true);
            helper.setVisible(R.id.image_pay_suc,false);
        }else {
            helper.setVisible(R.id.tv_toPay,false);
            helper.setVisible(R.id.image_pay_suc,true);
        }

        helper.addOnClickListener(R.id.rl_item);
    }
}
