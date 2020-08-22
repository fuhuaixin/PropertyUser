package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;

/**
 * 访客邀约
 */
public class VisitorInviteActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageBack;
    private TextView tvTitle;
    @Override
    protected int initLayout() {
        return R.layout.activity_visitor_invite;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        tvTitle.setText("访客邀约");
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
