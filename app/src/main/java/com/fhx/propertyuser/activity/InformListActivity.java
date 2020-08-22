package com.fhx.propertyuser.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.InformListAdapter;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.InformListBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知公告列表
 */
public class InformListActivity extends BaseActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_inform;
    private InformListAdapter informListAdapter;
    private List<InformListBean> mList =new ArrayList<>();

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
        tvTitle.setText("通知公告");
        mList.add(new InformListBean(0,"2020年第4季度物业费开始缴纳","08/05","805"));
        mList.add(new InformListBean(0,"2021年公摊费费开始缴纳","08/05","805"));
        mList.add(new InformListBean(0,"2020年第4季度物业费开始缴纳","08/05","805"));
        mList.add(new InformListBean(1,"关于停车场收费声明","08/05","805"));
        mList.add(new InformListBean(1,"关于元旦放假通知","08/05","805"));

        informListAdapter =new InformListAdapter(mList);
        recycle_inform.setLayoutManager(new LinearLayoutManager(this));
        recycle_inform.setAdapter(informListAdapter);
    }

    @Override
    protected void initListen() {
        informListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToTwo(InformListActivity.this, WebActivity.class,"通知公告","https://blog.csdn.net/u014743238/article/details/86715058");
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
