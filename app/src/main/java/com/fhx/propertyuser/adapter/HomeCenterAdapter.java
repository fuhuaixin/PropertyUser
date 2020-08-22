package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.HomeCenterBean;

import java.util.List;

public class HomeCenterAdapter extends BaseQuickAdapter<HomeCenterBean, BaseViewHolder> {
    public HomeCenterAdapter(@Nullable List<HomeCenterBean> data) {
        super(R.layout.adapter_home_center, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeCenterBean item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setImageResource(R.id.image_header,item.getImage());
        if (item.getIfNew()==0){
            helper.setVisible(R.id.image_new,false);
        }else if (item.getIfNew()==1){
            helper.setVisible(R.id.image_new,true);
        }

        helper.addOnClickListener(R.id.rl_item);
    }
}
