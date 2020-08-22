package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.fragment.invite.ReceiveFragment;
import com.fhx.propertyuser.fragment.invite.SendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 邀约列表
 */
public class InviteListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private TabLayout tablayout;
    private List<Fragment> fragments =new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_invite_list;
    }

    @Override
    protected void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        tvTitle.setText("邀约列表");
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.addTab(tablayout.newTab().setText("发出邀约"));
        tablayout.addTab(tablayout.newTab().setText("收到邀约"));

        fragments.add(new SendFragment());
        fragments.add(new ReceiveFragment());
        SwitchFragment(0);
    }

    @Override
    protected void initListen() {

        imageBack.setOnClickListener(this);

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
        fragmentTransaction.replace(R.id.frameLayout_invite,fragments.get(i));
        fragmentTransaction.commit();
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
