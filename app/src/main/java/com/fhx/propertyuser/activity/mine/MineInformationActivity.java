package com.fhx.propertyuser.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;

/**
 * 个人中心 个人信息编辑
 */
public class MineInformationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageBack;
    private TextView tvTitle;


    @Override
    protected int initLayout() {
        return R.layout.activity_mine_information;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        tvTitle.setText("个人信息");
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
