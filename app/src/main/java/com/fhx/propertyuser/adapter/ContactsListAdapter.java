package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.EmployeeListBean;

import java.util.List;

public class ContactsListAdapter extends BaseQuickAdapter<EmployeeListBean.DataBean, BaseViewHolder> {

    public ContactsListAdapter(@Nullable List<EmployeeListBean.DataBean> data) {
        super(R.layout.adapter_contacts_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EmployeeListBean.DataBean item) {

        helper.setText(R.id.tv_branch, item.getEmployeeName())
                .setText(R.id.tv_phone,"电话："+item.getPhone())
               .setText(R.id.tv_no, "员工编号："+item.getEmployeeNo());


        helper.addOnClickListener(R.id.ll_item);
    }
}
