package com.fhx.propertyuser.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.ComplainDetailBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import per.wsj.library.AndRatingBar;

/**
 * 报修详情
 */
public class RepairMsgActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvTitle, tv_commit;
    private TextView tv_urge;//催办
    private TextView tv_del;//催办
    private TextView tv_number;//电话
    private TextView tv_name;//
    private TextView tv_eva;//评论
    private TextView tv_eventType;//
    private TextView tv_content;//
    private TextView tv_upTime;//
    private ImageView imageBack;
    private LinearLayout ll_one_two;
    private RelativeLayout rl_three_four;
    private AndRatingBar rating_three, rating_four;
    private EditText edit_eva;//输入评论

    private String type, repairId;

    @Override
    protected int initLayout() {
        return R.layout.activity_repair_msg;
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("jumpOne");
        repairId = getIntent().getStringExtra("jumpTwo");
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_commit = (TextView) findViewById(R.id.tv_toPay);
        tv_urge = (TextView) findViewById(R.id.tv_urge);
        tv_del = (TextView) findViewById(R.id.tv_del);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_eva = (TextView) findViewById(R.id.tv_eva);
        tv_eventType = (TextView) findViewById(R.id.tv_eventType);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_upTime = (TextView) findViewById(R.id.tv_upTime);
        imageBack = (ImageView) findViewById(R.id.image_back);
        ll_one_two = (LinearLayout) findViewById(R.id.ll_one_two);
        rl_three_four = (RelativeLayout) findViewById(R.id.rl_three_four);
        rating_three = (AndRatingBar) findViewById(R.id.rating_three);
        rating_four = (AndRatingBar) findViewById(R.id.rating_four);
        edit_eva = (EditText) findViewById(R.id.edit_eva);
    }

    @Override
    protected void initData() {
        tvTitle.setText("报修详情");
        getRepairMsg();
        switch (type) {
            case "0":
                ll_one_two.setVisibility(View.VISIBLE);
                tv_urge.setVisibility(View.VISIBLE);
                tv_del.setVisibility(View.VISIBLE);
                tv_urge.setText("催办");
                break;
            case "6":
                ll_one_two.setVisibility(View.VISIBLE);
                tv_urge.setVisibility(View.VISIBLE);
                tv_del.setVisibility(View.VISIBLE);
                tv_urge.setText("已催办");
                break;
            case "3":
                ll_one_two.setVisibility(View.GONE);
                tv_urge.setVisibility(View.GONE);
                tv_del.setVisibility(View.GONE);

                break;
            case "1":
                tv_name.setText("wangShiFu");
                ll_one_two.setVisibility(View.VISIBLE);
                tv_number.setVisibility(View.VISIBLE);
                break;
            case "4":
                rl_three_four.setVisibility(View.VISIBLE);
                tv_commit.setVisibility(View.VISIBLE);
                rating_three.setVisibility(View.VISIBLE);
                edit_eva.setVisibility(View.VISIBLE);
                break;
            case "2":
            case "5":
                rl_three_four.setVisibility(View.VISIBLE);
                rating_four.setVisibility(View.VISIBLE);
                tv_eva.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_del.setOnClickListener(this);
        tv_urge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finishActivity();
                break;
            case R.id.tv_del:
                Del();
                break;
            case R.id.tv_urge:
                //催办
                if (type.equals("6")){
                    ToastShort("已催办，请耐心等待");
                }else {
                    urge();
                }
                break;
        }
    }

    private void getRepairMsg() {
        EasyHttp.get(AppUrl.RepairDetail)
                .syncRequest(false)
                .params("id", repairId)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        ComplainDetailBean complainDetailBean = JSON.parseObject(s, ComplainDetailBean.class);
                        if (complainDetailBean.isSuccess()) {
                            tv_eventType.setText(complainDetailBean.getData().getSelf().getComplainTypeName());
                            tv_content.setText(complainDetailBean.getData().getSelf().getContent());
                            tv_upTime.setText(complainDetailBean.getData().getSelf().getUpdateTime());
                        } else {
                            ToastShort(complainDetailBean.getMsg());
                        }
                    }
                });
    }


    /**
     * 未开始时 删除订单
     */

    private void Del() {
        EasyHttp.delete(AppUrl.RepairDel)
                .syncRequest(false)
                .params("id", repairId)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("删除成功");
                            finishActivity();
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }



    /**
     * 催办
     */
    private void urge(){
        EasyHttp.put(AppUrl.OrderUrge)
                .syncRequest(false)
                .params("id",repairId)
                .execute(new SimpleCallBack<String >() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("催办成功");
                            finishActivity();
                        }else {
                            ToastShort(successBean.getMsg());

                        }
                    }
                });
    }
}
