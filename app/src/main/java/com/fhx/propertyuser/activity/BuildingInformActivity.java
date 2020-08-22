package com.fhx.propertyuser.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.BuildInformAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.BuildInformBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 楼宇资讯
 */
public class BuildingInformActivity extends BaseActivity {
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_inform;


    BuildInformAdapter buildInformAdapter;
    private List<BuildInformBean> mList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_inform_list;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_inform = (RecyclerView) findViewById(R.id.recycle_inform);
    }

    @Override
    protected void initData() {
        tvTitle.setText("楼宇资讯");
        mList.add(new BuildInformBean(1,"关于智慧建筑平台最新资讯","",""));
        mList.add(new BuildInformBean(2,"特斯拉推出自动驾驶汽车软件","特斯拉推出自动驾驶汽车软件特斯拉推出自动驾驶汽车软件特斯拉推出自动驾驶汽车软件","4.8"));
        mList.add(new BuildInformBean(2,"特斯拉推出自动驾驶汽车软件","特斯拉推出自动驾驶汽车软件特斯拉推出自动驾驶汽车软件特斯拉推出自动驾驶汽车软件","4.8"));
        mList.add(new BuildInformBean(2,"如何让农民工讨薪不再难","如何让农民工讨薪不再难 ...如何让农民工讨薪不再难 ...如何让农民工讨薪不再难 ...","5.2"));
        mList.add(new BuildInformBean(2,"如何让农民工讨薪不再难","如何让农民工讨薪不再难 ...如何让农民工讨薪不再难 ...如何让农民工讨薪不再难 ...","5.2"));
        mList.add(new BuildInformBean(2,"值不值？499元小米运动相机","值不值？499元小米运动相机 ...值不值？499元小米运动相机 ...值不值？499元小米运动相机 ...","4.1"));
        mList.add(new BuildInformBean(2,"值不值？499元小米运动相机","值不值？499元小米运动相机 ...值不值？499元小米运动相机 ...值不值？499元小米运动相机 ...","4.1"));
        buildInformAdapter = new BuildInformAdapter(mList);
        recycle_inform.setLayoutManager(new LinearLayoutManager(this));
        recycle_inform.setAdapter(buildInformAdapter);

    }

    @Override
    protected void initListen() {

        buildInformAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                        CutToUtils.getInstance().JumpToTwo(BuildingInformActivity.this,WebActivity.class,"资讯详情","https://www.baidu.com/");
                        break;
                    case R.id.image_header:
                        CutToUtils.getInstance().JumpToTwo(BuildingInformActivity.this,WebActivity.class,"资讯详情","https://hao.360.com/");
                        break;
                }
            }
        });

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });
    }
}
