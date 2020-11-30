package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.ContactsBranchBean;

import java.util.List;

public class BranchMsgAdapter extends BaseQuickAdapter<ContactsBranchBean.MsgBean, BaseViewHolder> {
    public BranchMsgAdapter(@Nullable List<ContactsBranchBean.MsgBean> data) {
//        super(R.layout.adapter_branch_msg, data);
        super(R.layout.adapter_contacts_branch, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBranchBean.MsgBean item) {
        helper.setVisible(R.id.view_line,false);
        helper.setTextColor(R.id.tv_title,mContext.getResources().getColor(R.color.tv888));
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setImageResource(R.id.image_down,R.mipmap.icon_contacts_right);
        helper.addOnClickListener(R.id.ll_item);
    }
}
