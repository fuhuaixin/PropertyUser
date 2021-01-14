package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.ComplainBean;

import java.util.List;

public class ComplainAdapter extends BaseQuickAdapter<ComplainBean.DataBean.RecordsBean, BaseViewHolder> {

    public ComplainAdapter(@Nullable List<ComplainBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_complain, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ComplainBean.DataBean.RecordsBean item) {
        if (item.getStatus().equals("4")) {

            helper.setVisible(R.id.image_no_repair, true);
            helper.setImageResource(R.id.image_no_repair,R.mipmap.icon_complain_no_repair);
        }else if (item.getUrgeTimes()>0){
            helper.setVisible(R.id.image_no_repair, true);
            helper.setImageResource(R.id.image_no_repair,R.mipmap.icon_complain_urge);
        } else {
            helper.setVisible(R.id.image_no_repair, false);
        }

        helper.setText(R.id.tv_title, item.getContent())
                .setText(R.id.tv_msg, item.getComplaintTypeName())
                .setText(R.id.tv_time, item.getCreateTime());

        helper.addOnClickListener(R.id.ll_item);
    }
}
