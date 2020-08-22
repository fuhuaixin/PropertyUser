package com.fhx.propertyuser.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.OrderMsgAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.OrderMsgBean;
import com.fhx.propertyuser.utils.ListDialog;
import com.fhx.propertyuser.utils.ResultTipDialog;

import java.util.ArrayList;
import java.util.List;

public class OrderMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle, tv_toPay, tv_msg_total;
    private RecyclerView recycle_msg;
    private OrderMsgAdapter orderMsgAdapter;
    private List<OrderMsgBean> orderMsgBeanList = new ArrayList<>();
    private List<String> payList = new ArrayList();

    private String type; //toPay  账单详情（去支付）  payMsg 缴费详情 不用支付

    private int total = 0;
    private ListDialog listDialog;
    private ResultTipDialog resultTipDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_order_msg;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_toPay = (TextView) findViewById(R.id.tv_toPay);
        tv_msg_total = (TextView) findViewById(R.id.tv_msg_total);
        recycle_msg = (RecyclerView) findViewById(R.id.recycle_msg);
    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("jumpOne");
        tvTitle.setText("账单详情");
        if (type.equals("toPay")) {
            tv_toPay.setVisibility(View.VISIBLE);
        } else if (type.equals("read")){
            tv_toPay.setVisibility(View.GONE);
        }

        resultTipDialog = new ResultTipDialog(this, "recharge");

        orderMsgBeanList.add(new OrderMsgBean("物业费", "张三", "1245689", "地址1111", "单位1111", "8.10-9.20", 100));
        orderMsgBeanList.add(new OrderMsgBean("制冷费", "张三", "12231389", "地址222", "单位222", "8.10-9.20", 53));
        orderMsgAdapter = new OrderMsgAdapter(orderMsgBeanList);

        recycle_msg.setLayoutManager(new LinearLayoutManager(this));
        recycle_msg.setAdapter(orderMsgAdapter);

        for (int i = 0; i < orderMsgBeanList.size(); i++) {
            total = total + orderMsgBeanList.get(i).getNeedPay();
        }

        tv_msg_total.setText("￥" + total);

        payList.add("支付宝");
        payList.add("微信");
        payList.add("其他");
        listDialog = new ListDialog(OrderMsgActivity.this, payList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        resultTipDialog.setImageHeader(R.mipmap.icon_big_true)
                                .setTitle("充值成功")
                                .setMsg("充值时间：2020/7/30  \n订单号：11226589541336")
                                .show();
                        break;
                    case 1:
                        resultTipDialog.setImageHeader(R.mipmap.icon_big_error)
                                .setTitle("充值失败")
                                .setMsg("失败原因：原因原因原因")
                                .show();
                        break;
                    case 2:
                        resultTipDialog.setImageHeader(R.mipmap.icon_big_cancal)
                                .setTitle("取消充值")
                                .setMsg("取消原因：原因原因原因")
                                .show();
                        break;

                }
                listDialog.dismiss();
            }
        });

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_toPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_toPay:
                listDialog.show();
                break;

        }
    }

}
