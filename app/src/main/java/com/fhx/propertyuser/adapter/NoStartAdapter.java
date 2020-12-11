package com.fhx.propertyuser.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.RepairListBean;

import java.util.List;

public class NoStartAdapter extends BaseQuickAdapter<RepairListBean.DataBean.RecordsBean, BaseViewHolder> {

    public NoStartAdapter(@Nullable List<RepairListBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_no_start, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairListBean.DataBean.RecordsBean item) {

        helper.setText(R.id.tv_name, item.getCustomerName())
                .setText(R.id.tv_eventType, item.getRepairTypeName())
                .setText(R.id.tv_reserveTime, item.getReserveTime())
                .setText(R.id.tv_describe, item.getContent())
                .setText(R.id.tv_notes, item.getNotes());

        LinearLayout ll_two = helper.getView(R.id.ll_two);
        LinearLayout ll_three = helper.getView(R.id.ll_three);
        ImageView image_no_repair = helper.getView(R.id.image_no_repair);
        switch (item.getStatus()) {
            case "0":
                ll_two.setVisibility(View.GONE);
                image_no_repair.setVisibility(View.VISIBLE);
                image_no_repair.setImageResource(R.mipmap.icon_repair_recall);
                ll_three.setVisibility(View.GONE);
                break;
            case "1":
            case "2":
            case "3":
                ll_two.setVisibility(View.GONE);
                ll_three.setVisibility(View.GONE);
                image_no_repair.setVisibility(View.GONE);
                break;

            case "4":
                ll_two.setVisibility(View.VISIBLE);
                image_no_repair.setVisibility(View.VISIBLE);
                image_no_repair.setImageResource(R.mipmap.icon_no_repair);
                ll_three.setVisibility(View.GONE);

                break;
            case "5":
                image_no_repair.setVisibility(View.GONE);
                ll_two.setVisibility(View.GONE);
                ll_three.setVisibility(View.VISIBLE);
                break;

        }

        if (item.getUrgeTimes()>0){
            ll_two.setVisibility(View.GONE);
            image_no_repair.setVisibility(View.VISIBLE);
            image_no_repair.setImageResource(R.mipmap.icon_repair_urge);
            ll_three.setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.ll_item);
    }
}
