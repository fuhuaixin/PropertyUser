package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.InviteSendBean;

import java.util.List;

public class InviteReceiveAdapter extends BaseQuickAdapter<InviteSendBean, BaseViewHolder> {
    public InviteReceiveAdapter(@Nullable List<InviteSendBean> data) {
        super(R.layout.adapter_invite_receive, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InviteSendBean item) {

//        helper.setText(R.id.tv_time, item.getTime())
//                .setText(R.id.tv_msg, "尊敬的"+item.getInviteName()+"\n您好，我司邀请您于"+item.getTime()+"到本公司"+item.getReason()+",望准时到达。");

    }
}
