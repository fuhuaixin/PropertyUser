package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.mine.OrderListActivity;
import com.fhx.propertyuser.activity.mine.OrderRecordActivity;
import com.fhx.propertyuser.adapter.RechargeListAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.RechargeListBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 缴费充值列表页
 */
public class RechargeListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle,tv_title_right;
    private RecyclerView recycle_recharge;
    private RechargeListAdapter listAdapter ;
    private List<RechargeListBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_recharge_list;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
        recycle_recharge = (RecyclerView) findViewById(R.id.recycle_recharge);
    }

    @Override
    protected void initData() {
        tvTitle.setText("充值缴费");
        tv_title_right.setText("缴费记录");

        mList.add(new RechargeListBean("电费",R.mipmap.icon_energy));
        mList.add(new RechargeListBean("水费",R.mipmap.icon_water));
        mList.add(new RechargeListBean("物业费",R.mipmap.icon_property));
        mList.add(new RechargeListBean("取暖费",R.mipmap.icon_heating));
        mList.add(new RechargeListBean("制冷费",R.mipmap.icon_cool));
        recycle_recharge.setLayoutManager(new GridLayoutManager(this,3));

        listAdapter =new RechargeListAdapter(mList);
        recycle_recharge.setAdapter(listAdapter);


    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_title_right.setOnClickListener(this);
        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpTo(RechargeListActivity.this,RechargeMsgActivity.class);
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
            case R.id.tv_title_right:
                CutToUtils.getInstance().JumpTo(RechargeListActivity.this, OrderRecordActivity.class);
                break;
        }
    }
}
