package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.ComplainBean;

import java.util.List;

public class ComplainAdapter extends BaseQuickAdapter<ComplainBean, BaseViewHolder> {

    public ComplainAdapter(@Nullable List<ComplainBean> data) {
        super(R.layout.adapter_complain, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ComplainBean item) {
        if (item.getProgress() == 2) {
            helper.setVisible(R.id.image_no_repair, true);
        } else {
            helper.setVisible(R.id.image_no_repair, false);
        }
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_msg, item.getMsg())
                .setText(R.id.tv_time, item.getTime());

        helper.addOnClickListener(R.id.ll_item);
    }
}
