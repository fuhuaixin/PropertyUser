package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.BranchMsgAdapter;
import com.fhx.propertyuser.adapter.ContactsBranchAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.ContactsBranchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 通讯录
 */
public class ContactsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_branch,recycle_collect;
    private ContactsBranchAdapter branchAdapter ;
    private List<ContactsBranchBean> branchList = new ArrayList<>();

    BranchMsgAdapter branchMsgAdapter;
    private List<ContactsBranchBean.MsgBean> msgBeanList1 =new ArrayList<>();
    private List<ContactsBranchBean.MsgBean> msgBeanList2 =new ArrayList<>();
    private List<ContactsBranchBean.MsgBean> msgBeanList3 =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_contacts;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_branch = (RecyclerView) findViewById(R.id.recycle_branch);
        recycle_collect = (RecyclerView) findViewById(R.id.recycle_collect);
    }

    @Override
    protected void initData() {
        tvTitle.setText("物业团队");
        msgBeanList1.clear();
        msgBeanList1.add(new ContactsBranchBean.MsgBean("name11","job11","157845645645"));
        msgBeanList1.add(new ContactsBranchBean.MsgBean("name11","job11","157845645645"));
        msgBeanList1.add(new ContactsBranchBean.MsgBean("name11","job11","157845645645"));
        branchList.add(new ContactsBranchBean(0,"标题1",10,msgBeanList1));
        msgBeanList2.clear();
        msgBeanList2.add(new ContactsBranchBean.MsgBean("name21","job21","157845645645"));
        msgBeanList2.add(new ContactsBranchBean.MsgBean("name21","job21","157845645645"));
        msgBeanList2.add(new ContactsBranchBean.MsgBean("name21","job21","157845645645"));
        branchList.add(new ContactsBranchBean(0,"标题2",11,msgBeanList2));
        msgBeanList3.clear();
        msgBeanList3.add(new ContactsBranchBean.MsgBean("name31","job21","157845645645"));
        msgBeanList3.add(new ContactsBranchBean.MsgBean("name31","job21","157845645645"));
        branchList.add(new ContactsBranchBean(0,"标题3",13,msgBeanList3));

        branchAdapter =new ContactsBranchAdapter(branchList,ContactsActivity.this);

        recycle_branch .setLayoutManager(new LinearLayoutManager(this));
        recycle_branch.setAdapter(branchAdapter);


        branchMsgAdapter= new BranchMsgAdapter(msgBeanList1);
        recycle_collect.setLayoutManager(new LinearLayoutManager(this));
        recycle_collect.setAdapter(branchMsgAdapter);

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        branchAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
               /* for (int i = 0; i < position; i++) {
                    branchList.get(position).setIsShow(0);
                }*/
                if (branchList.get(position).getIsShow()==0){
                    branchList.get(position).setIsShow(1);
                }else if(branchList.get(position).getIsShow()==1){
                    branchList.get(position).setIsShow(0);
                }
                branchAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }
}
