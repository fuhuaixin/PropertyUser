package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.ContactsListAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.EmployeeListBean;
import com.fhx.propertyuser.utils.CutToUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 子部门联系人列表
 */
public class ContactsListActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_contacts;
    private String id;
    private ContactsListAdapter listAdapter;
    private List<EmployeeListBean.DataBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_contacts_list;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_contacts = (RecyclerView) findViewById(R.id.recycle_contacts);
    }

    @Override
    protected void initData() {
        tvTitle.setText("联系人列表");
        id =getIntent().getStringExtra("jumpOne");
        listAdapter =new ContactsListAdapter(mList);
        recycle_contacts.setLayoutManager(new LinearLayoutManager(this));
        recycle_contacts.setAdapter(listAdapter);

        EmployeeFindDept();
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(ContactsListActivity.this, ContactsMsgActivity.class,mList.get(position).getEmployeeId());

            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }

    /**
     * 根据部门id 查部门成员
     */
    private void EmployeeFindDept(){
        EasyHttp.get(AppUrl.EmployeeFindDept)
                .syncRequest(false)
                .params("id",id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        EmployeeListBean employeeListBean = JSON.parseObject(s, EmployeeListBean.class);
                        if (employeeListBean.isSuccess()){
                            mList.clear();
                            mList.addAll(employeeListBean.getData());
                            listAdapter.notifyDataSetChanged();
                        }else {
                            ToastShort(employeeListBean.getMsg());
                        }
                    }
                });
    }
}
