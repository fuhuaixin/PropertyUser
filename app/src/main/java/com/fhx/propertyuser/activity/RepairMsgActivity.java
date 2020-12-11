package com.fhx.propertyuser.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.RepairsMsgImageAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.ComplainDetailBean;
import com.fhx.propertyuser.bean.EvaMsgBean;
import com.fhx.propertyuser.bean.RepairDetailBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

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
    private RecyclerView recycle_image;
    private TextView tv_dealPerson_name,tv_dealPerson_phone;


    private RepairsMsgImageAdapter imageAdapter;
    private List<String > imageList =new ArrayList<>();

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
        tv_dealPerson_name = (TextView) findViewById(R.id.tv_dealPerson_name);
        tv_dealPerson_phone = (TextView) findViewById(R.id.tv_dealPerson_phone);
        imageBack = (ImageView) findViewById(R.id.image_back);
        ll_one_two = (LinearLayout) findViewById(R.id.ll_one_two);
        rl_three_four = (RelativeLayout) findViewById(R.id.rl_three_four);
        rating_three = (AndRatingBar) findViewById(R.id.rating_three);
        rating_four = (AndRatingBar) findViewById(R.id.rating_four);
        edit_eva = (EditText) findViewById(R.id.edit_eva);
        recycle_image = (RecyclerView) findViewById(R.id.recycle_image);
    }

    @Override
    protected void initData() {
        tvTitle.setText("报修详情");
        getRepairMsg();
        switch (type) {
            case "1":
                ll_one_two.setVisibility(View.VISIBLE);
                tv_urge.setVisibility(View.VISIBLE);
                tv_del.setVisibility(View.VISIBLE);
                tv_urge.setText("催办");
                break;

            case "2":
            case "3":
                tv_name.setText("wangShiFu");
                ll_one_two.setVisibility(View.VISIBLE);
                tv_number.setVisibility(View.VISIBLE);
                break;
         /*   case "6":
                ll_one_two.setVisibility(View.VISIBLE);
                tv_urge.setVisibility(View.VISIBLE);
                tv_del.setVisibility(View.VISIBLE);
                tv_urge.setText("已催办");
                break;
            case "0":

                ll_one_two.setVisibility(View.GONE);
                tv_urge.setVisibility(View.GONE);
                tv_del.setVisibility(View.GONE);

                break;*/

            case "4":
                rl_three_four.setVisibility(View.VISIBLE);
                tv_commit.setVisibility(View.VISIBLE);
                rating_three.setVisibility(View.VISIBLE);
                edit_eva.setVisibility(View.VISIBLE);
                break;

            case "5":
                rl_three_four.setVisibility(View.VISIBLE);
                rating_four.setVisibility(View.VISIBLE);
                tv_eva.setVisibility(View.VISIBLE);
                getEvaMsg(repairId);
                break;
        }

        recycle_image.setLayoutManager(new GridLayoutManager(this,3));
        imageAdapter =new RepairsMsgImageAdapter(imageList);
        recycle_image.setAdapter(imageAdapter);

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
                if (tv_urge.getText().toString().equals("已催办")){
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
     * 获取报修详情
     */
    RepairDetailBean repairDetailBean;
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
                        repairDetailBean = JSON.parseObject(s, RepairDetailBean.class);
                        if (repairDetailBean.isSuccess()) {
                            RepairDetailBean.DataBean data = repairDetailBean.getData();
                            tv_eventType.setText(data.getSelf().getRepairTypeName());
                            tv_content.setText(data.getSelf().getContent());
                            tv_upTime.setText(data.getSelf().getUpdatetime());
                            if (data.getDealPerson()!=null){
                                tv_dealPerson_name.setText(data.getDealPerson().getDutyName());
                                tv_dealPerson_phone.setText(data.getDealPerson().getPhone());
                            }

                            if (data.getSelf().getUrgeTimes()>0){
                                tv_urge.setText("已催办");
                            }

                            String imgs = data.getSelf().getImgs();
                            if (imgs!=null&&!imgs.equals("")){
                                String[] split = imgs.split(",");
                                for (int i = 0; i < split.length; i++) {
                                    imageList.add(split[i]);
                                }
                            }

                            imageAdapter.notifyDataSetChanged();
                        } else {
                            ToastShort(repairDetailBean.getMsg());
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

    /**
     * 提交评价
     */
    private void EvaluteSubmit(){
        EasyHttp.post(AppUrl.EvaluteSubmit)
                .syncRequest(false)
                .params("originType","0")
                .params("originId",repairId)
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

    /**
     * 获取评价内容
     */

    private void getEvaMsg(String id) {
        EasyHttp.get(AppUrl.EvaluteGet)
                .syncRequest(false)
                .params("id", id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        EvaMsgBean evaMsgBean = JSON.parseObject(s, EvaMsgBean.class);
                        if (evaMsgBean.isSuccess()) {
                            if (evaMsgBean.getData()==null){
                                return;
                            }
                            rating_four.setRating(evaMsgBean.getData().getRateScore());
                            tv_eva.setText(evaMsgBean.getData().getContent());
                        }
                    }
                });
    }

}
