package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.InviteSendBean;

import java.util.List;

public class InviteSendAdapter extends BaseQuickAdapter<InviteSendBean.DataBean.RecordsBean, BaseViewHolder> {
    public InviteSendAdapter(@Nullable List<InviteSendBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_invite_send, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InviteSendBean.DataBean.RecordsBean item) {

        helper.setText(R.id.tv_invite_name, item.getGuestName())
                .setText(R.id.tv_phone, item.getGuestPhone())
                .setText(R.id.tv_time, item.getComeDay())
                .setText(R.id.tv_reason, item.getOrigin());

        helper.addOnClickListener(R.id.ll_item);
    }
}
