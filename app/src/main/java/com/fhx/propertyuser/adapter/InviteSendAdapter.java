package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.InviteSendBean;

import java.util.List;

public class InviteSendAdapter extends BaseQuickAdapter<InviteSendBean, BaseViewHolder> {
    public InviteSendAdapter(@Nullable List<InviteSendBean> data) {
        super(R.layout.adapter_invite_send, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InviteSendBean item) {

        helper.setText(R.id.tv_invite_name, item.getInviteName())
                .setText(R.id.tv_phone, item.getPhone())
                .setText(R.id.tv_time, item.getTime())
                .setText(R.id.tv_reason, item.getReason());

        helper.addOnClickListener(R.id.ll_item);
    }
}
