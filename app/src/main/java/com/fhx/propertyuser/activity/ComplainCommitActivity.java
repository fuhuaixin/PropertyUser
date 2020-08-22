package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.ListDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 我要投诉
 */
public class ComplainCommitActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private LinearLayout ll_complain_type;
    private List<String> mEventTypeList = new ArrayList<>();
    private ListDialog listDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_complain_commit;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ll_complain_type = (LinearLayout) findViewById(R.id.ll_complain_type);
    }

    @Override
    protected void initData() {
        tvTitle.setText("提交投诉");
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        ll_complain_type.setOnClickListener(this);
        mEventTypeList.add("类型1");
        mEventTypeList.add("类型2");
        mEventTypeList.add("类型3");
        listDialog = new ListDialog(this, mEventTypeList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                listDialog.dismiss();
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
            case R.id.ll_complain_type:
                listDialog.show();
                break;
        }
    }
}
