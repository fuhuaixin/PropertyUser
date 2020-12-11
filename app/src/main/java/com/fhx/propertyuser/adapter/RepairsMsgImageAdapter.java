package com.fhx.propertyuser.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;


import java.util.List;

public class RepairsMsgImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public RepairsMsgImageAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_repairs_msg_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView image_msg_describe  = helper.getView(R.id.image_msg_describe);

        Glide.with(mContext).load(item).into(image_msg_describe);
    }
}
