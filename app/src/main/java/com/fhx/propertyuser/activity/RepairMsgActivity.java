package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;

import per.wsj.library.AndRatingBar;

/**
 * 报修详情
 */
public class RepairMsgActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvTitle,tv_commit;
    private TextView tv_urge;//催办
    private TextView tv_number;//电话
    private TextView tv_name;//
    private TextView tv_eva;//评论
    private ImageView imageBack;
    private LinearLayout ll_one_two;
    private RelativeLayout rl_three_four;
    private AndRatingBar rating_three,rating_four;
    private EditText edit_eva;//输入评论

    private String type;
    @Override
    protected int initLayout() {
        return R.layout.activity_repair_msg;
    }

    @Override
    protected void initView() {
        type =getIntent().getStringExtra("jumpOne");
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_commit = (TextView) findViewById(R.id.tv_toPay);
        tv_urge = (TextView) findViewById(R.id.tv_urge);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_eva = (TextView) findViewById(R.id.tv_eva);
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

        switch (type){
            case "one":
                ll_one_two.setVisibility(View.VISIBLE);
                tv_urge.setVisibility(View.VISIBLE);

                break;
            case "two":
                tv_name.setText("wangShiFu");
                ll_one_two.setVisibility(View.VISIBLE);
                tv_number.setVisibility(View.VISIBLE);
                break;
            case "three":
                rl_three_four.setVisibility(View.VISIBLE);
                tv_commit.setVisibility(View.VISIBLE);
                rating_three.setVisibility(View.VISIBLE);
                edit_eva.setVisibility(View.VISIBLE);
                break;
            case "four":
                rl_three_four.setVisibility(View.VISIBLE);
                rating_four.setVisibility(View.VISIBLE);
                tv_eva.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
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
