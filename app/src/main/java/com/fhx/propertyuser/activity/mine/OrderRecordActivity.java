package com.fhx.propertyuser.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.OrderRecordAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.OrderRecordBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 账单消费记录
 */
public class OrderRecordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_order;
    private OrderRecordAdapter recordAdapter;
    private List<OrderRecordBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_order = (RecyclerView) findViewById(R.id.recycle_order);
    }

    @Override
    protected void initData() {
        tvTitle.setText("账单服务");
        mList.add(new OrderRecordBean("7月物业费","2020.8.10","物业费",100));
        mList.add(new OrderRecordBean("8月物业费","2020.9.10","物业费",120));
        mList.add(new OrderRecordBean("9月物业费","2020.9.10","物业费",190));
        recordAdapter = new OrderRecordAdapter(mList);
        recycle_order.setLayoutManager(new LinearLayoutManager(this));
        recycle_order.setAdapter(recordAdapter);


    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        recordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(OrderRecordActivity.this,OrderMsgActivity.class,"read");
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
}
