package com.fhx.propertyuser.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.ContactsListActivity;
import com.fhx.propertyuser.activity.ContactsMsgActivity;
import com.fhx.propertyuser.bean.ContactsBranchBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.List;

public class ContactsBranchAdapter extends BaseQuickAdapter<ContactsBranchBean, BaseViewHolder> {
    private Activity activity;
    private List<ContactsBranchBean.MsgBean> msgBeanList ;
    public ContactsBranchAdapter( @Nullable List<ContactsBranchBean> data,Activity activity) {
        super(R.layout.adapter_contacts_branch, data);
        this.activity =activity;
    }

    public void setMsgBeanList( List<ContactsBranchBean.MsgBean> msgBeanList){
        this.msgBeanList =msgBeanList;
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBranchBean item) {

        RecyclerView recycle_msg  = helper.getView(R.id.recycle_msg);

        BranchMsgAdapter branchMsgAdapter = new BranchMsgAdapter(msgBeanList);
        recycle_msg.setLayoutManager(new LinearLayoutManager(mContext));
        recycle_msg.setAdapter(branchMsgAdapter);

        branchMsgAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(activity, ContactsListActivity.class,msgBeanList.get(position).getId());
            }
        });

        if (helper.getPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }
        if (item.getIsShow()==0){ //未展开
            helper.setImageResource(R.id.image_down,R.mipmap.icon_down);
            recycle_msg.setVisibility(View.GONE);
        }else if (item.getIsShow()==1){//展开
            helper.setImageResource(R.id.image_down,R.mipmap.icon_up);
            recycle_msg.setVisibility(View.VISIBLE);
        }
        helper.setText(R.id.tv_title,item.getTitle());

        helper.addOnClickListener(R.id.ll_item);
    }
}
