package com.fhx.propertyuser.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.OrderListAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.OrderListBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 账单服务
 */
public class OrderListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle,tv_title_right;
    private RecyclerView recycle_order;
    private OrderListAdapter listAdapter;
    private List<OrderListBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
        recycle_order = (RecyclerView) findViewById(R.id.recycle_order);
    }

    @Override
    protected void initData() {
        tvTitle.setText("账单服务");
        tv_title_right.setText("缴费记录");
        mList.add(new OrderListBean("费用1",200,"2020.8.8-2020.9.10",0));
        mList.add(new OrderListBean("费用2",100,"2020.8.8-2020.9.10",0));
        mList.add(new OrderListBean("费用3",220,"2020.8.8-2020.9.10",1));
        mList.add(new OrderListBean("费用4",220,"2020.8.8-2020.9.10",1));

        listAdapter =new OrderListAdapter(mList);
        recycle_order.setLayoutManager(new LinearLayoutManager(this));
        recycle_order.setAdapter(listAdapter);


    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_title_right.setOnClickListener(this);
        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.rl_item:
                        if (mList.get(position).getIfPay()==0){
                            CutToUtils.getInstance().JumpToOne(OrderListActivity.this,OrderMsgActivity.class,"toPay");
                        }else {
                            CutToUtils.getInstance().JumpToOne(OrderListActivity.this,OrderMsgActivity.class,"noPay");
                        }
                        break;
                }
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
                CutToUtils.getInstance().JumpTo(OrderListActivity.this,OrderRecordActivity.class);
                break;
        }
    }
}
