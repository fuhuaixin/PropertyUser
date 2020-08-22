package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.fragment.complain.NoStartFragment;
import com.fhx.propertyuser.utils.CutToUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 投诉建议
 */
public class ComplainListActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageBack;
    private TextView tvTitle,tv_title_right;
    private TabLayout tablayout;
    private List<Fragment> fragments =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_repair_list;
    }

    @Override
    protected void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
    }

    @Override
    protected void initData() {
        tvTitle.setText("投诉列表");
        tv_title_right.setText("我要投诉");
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.addTab(tablayout.newTab().setText("未开始"));
        tablayout.addTab(tablayout.newTab().setText("进行中"));
        tablayout.addTab(tablayout.newTab().setText("已完成"));

        fragments.add(new NoStartFragment("未开始"));
        fragments.add(new NoStartFragment("进行中"));
        fragments.add(new NoStartFragment("已完成"));

        SwitchFragment(0);
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_title_right.setOnClickListener(this);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                SwitchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void SwitchFragment(int i){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_repair,fragments.get(i));
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_title_right:
                CutToUtils.getInstance().JumpTo(ComplainListActivity.this,ComplainCommitActivity.class);
                break;
        }
    }
}
