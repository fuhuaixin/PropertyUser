package com.fhx.propertyuser.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.InviteSendBean;
import com.fhx.propertyuser.bean.RepairListBean;

import java.util.List;

public class NoStartAdapter extends BaseQuickAdapter<RepairListBean, BaseViewHolder> {

    public NoStartAdapter(@Nullable List<RepairListBean> data) {
        super(R.layout.adapter_no_start, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairListBean item) {

        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_eventType, item.getEventType())
                .setText(R.id.tv_repairTime, item.getRepairTime())
                .setText(R.id.tv_describe, item.getDescribe())
        .setText(R.id.tv_appointmentTime,item.getAppointmentTime());

        LinearLayout ll_two =  helper.getView(R.id.ll_two);
        LinearLayout ll_three =  helper.getView(R.id.ll_three);
        ImageView image_no_repair =  helper.getView(R.id.image_no_repair);
        switch (item.getProgress()){
            case 0:
            case 1:
                ll_two.setVisibility(View.GONE);
                ll_three.setVisibility(View.GONE);
                image_no_repair.setVisibility(View.GONE);
                break;
            case 2:
                ll_two.setVisibility(View.VISIBLE);
                image_no_repair.setVisibility(View.VISIBLE);
                ll_three.setVisibility(View.GONE);
                break;
            case 3:
                image_no_repair.setVisibility(View.GONE);
                ll_two.setVisibility(View.GONE);
                ll_three.setVisibility(View.VISIBLE);
                break;
        }

        helper.addOnClickListener(R.id.ll_item);
    }
}
