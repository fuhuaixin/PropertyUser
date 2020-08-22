package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.ContactsBranchBean;

import java.util.List;

public class BranchMsgAdapter extends BaseQuickAdapter<ContactsBranchBean.MsgBean, BaseViewHolder> {
    public BranchMsgAdapter(@Nullable List<ContactsBranchBean.MsgBean> data) {
        super(R.layout.adapter_branch_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBranchBean.MsgBean item) {
        if (helper.getPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }
        helper.setText(R.id.tv_name,item.getName())
                .setText(R.id.tv_job,item.getJob())
                .setText(R.id.tv_number,item.getPhone());

        helper.addOnClickListener(R.id.ll_item);
    }
}
