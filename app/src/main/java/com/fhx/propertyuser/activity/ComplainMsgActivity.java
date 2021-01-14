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
 * 投诉详情
 */
public class ComplainMsgActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvTitle, tv_commit;
    private TextView tv_urge;//催办
    private TextView tv_del;//删除
    private TextView tv_number;//电话
    private TextView tv_name,tv_deal_name;//
    private TextView tv_eva;//评论
    private TextView tv_eventType;//投诉类型
    private TextView tv_content;//投诉内容
    private TextView tv_eventTime;//时间事件
    private TextView tv_hope_msg;//希望处理
    private TextView tv_hope_time;//希望处理时间
    private ImageView imageBack;
    private LinearLayout ll_one_two,ll_four;
    private RelativeLayout rl_three;
    private AndRatingBar rating_three, rating_four;
    private EditText edit_eva;//输入评论

    private String type, complainId;
    private ComplainDetailBean complainDetailBean;

    @Override
    protected int initLayout() {
        return R.layout.activity_complain_msg;
    }

    @Override
    protected void initView() {
//        type = getIntent().getStringExtra("jumpOne");
        complainId = getIntent().getStringExtra("jumpTwo");
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_commit = (TextView) findViewById(R.id.tv_toPay);
        tv_urge = (TextView) findViewById(R.id.tv_urge);
        tv_del = (TextView) findViewById(R.id.tv_del);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_deal_name = (TextView) findViewById(R.id.tv_deal_name);
        tv_eva = (TextView) findViewById(R.id.tv_eva);
        tv_eventType = (TextView) findViewById(R.id.tv_eventType);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_eventTime = (TextView) findViewById(R.id.tv_eventTime);
        tv_hope_msg = (TextView) findViewById(R.id.tv_hope_msg);
        tv_hope_time = (TextView) findViewById(R.id.tv_hope_time);
        imageBack = (ImageView) findViewById(R.id.image_back);
        ll_one_two = (LinearLayout) findViewById(R.id.ll_one_two);
        ll_four = (LinearLayout) findViewById(R.id.ll_four);
        rl_three = (RelativeLayout) findViewById(R.id.rl_three);
        rating_three = (AndRatingBar) findViewById(R.id.rating_three);
        rating_four = (AndRatingBar) findViewById(R.id.rating_four);
        edit_eva = (EditText) findViewById(R.id.edit_eva);
    }

    @Override
    protected void initData() {
        tvTitle.setText("投诉详情");
        getMsg();

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_del.setOnClickListener(this);
        tv_urge.setOnClickListener(this);
        tv_commit.setOnClickListener(this);

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
                if (urgeTimes>0){
                    ToastShort("已催办，请耐心等待");
                }else {
                    urge();
                }
                break;
            case R.id.tv_toPay:
                EvaluteSubmit();
                break;
        }
    }

    /**
     * 获取列表详情
     */
    int urgeTimes=-1;
    private void getMsg() {
        EasyHttp.get(AppUrl.ComplaintDetail)
                .syncRequest(false)
                .params("id", complainId)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        complainDetailBean = JSON.parseObject(s, ComplainDetailBean.class);
                        if (complainDetailBean.isSuccess()) {
                            type =complainDetailBean.getData().getSelf().getStatus();
                            switch (type) {
                                case "0":
                                case "1":
                                    ll_one_two.setVisibility(View.VISIBLE);
                                    tv_urge.setVisibility(View.VISIBLE);
                                    tv_del.setVisibility(View.VISIBLE);
                                    break;

                                case "2":
                                case "3":
                                    rl_three.setVisibility(View.VISIBLE);
//                                    tv_deal_name.setText(complainDetailBean);
                                    break;
                                case "4":
                                    rl_three.setVisibility(View.VISIBLE);
                                    ll_four.setVisibility(View.VISIBLE);
                                    tv_commit.setVisibility(View.VISIBLE);
                                    rating_three.setVisibility(View.VISIBLE);
                                    edit_eva.setVisibility(View.VISIBLE);
                                    break;

                                case "5":
                                    ll_four.setVisibility(View.VISIBLE);
                                    rl_three.setVisibility(View.VISIBLE);
                                    rating_four.setVisibility(View.VISIBLE);
                                    tv_eva.setVisibility(View.VISIBLE);
                                    break;
                            }


                            tv_eventType.setText(complainDetailBean.getData().getSelf().getComplaintTypeName());
                            tv_content.setText(complainDetailBean.getData().getSelf().getContent());
                            tv_eventTime.setText(complainDetailBean.getData().getSelf().getHappenTime());
                            tv_hope_msg.setText(complainDetailBean.getData().getSelf().getHopeResult());
                            tv_hope_time.setText(complainDetailBean.getData().getSelf().getHopeTime());
                            urgeTimes =complainDetailBean.getData().getSelf().getUrgeTimes();
                            if (urgeTimes>0){
                                tv_urge.setText("已催办");
                            }
                            if (complainDetailBean.getData().getEvaluteInfo()!=null){
                                rating_four.setRating((float) complainDetailBean.getData().getEvaluteInfo().getRateScore());
                                tv_eva.setText(complainDetailBean.getData().getEvaluteInfo().getContent());
                            }

                        } else {
                            ToastShort(complainDetailBean.getMsg());
                        }
                    }
                });

    }

    /**
     * 未开始时可以删除
     */
    private void Del() {
        EasyHttp.delete(AppUrl.ComplaintDel)
                .syncRequest(false)
                .params("id", complainId)
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
                        }else {
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
                .params("id",complainId)
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

    /**
     * 提交评价
     */
    private void EvaluteSubmit(){
        EasyHttp.post(AppUrl.EvaluteSubmit)
                .syncRequest(false)
                .params("originType","1")
                .params("originId",complainId)
                .params("rateScore",rating_three.getNumStars()+"")
                .params("customerId",mmkv.decodeString("customerId"))
                .params("content",edit_eva.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            ToastShort("提交成功");
                            finish();
                            overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                        }else {
                            successBean.getMsg();
                        }
                    }
                });
    }


}
