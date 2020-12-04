package com.fhx.propertyuser.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.BuildInformAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.BuildInformBean;
import com.fhx.propertyuser.bean.NewsListBean;
import com.fhx.propertyuser.utils.CutToUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 楼宇资讯
 */
public class BuildingInformActivity extends BaseActivity {
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_inform;
    private SmartRefreshLayout refresh;

    BuildInformAdapter buildInformAdapter;
    private List<BuildInformBean> mList = new ArrayList<>();
    private int page;
    @Override
    protected int initLayout() {
        return R.layout.activity_inform_list;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_inform = (RecyclerView) findViewById(R.id.recycle_inform);
        refresh = (SmartRefreshLayout) findViewById(R.id.refresh);
    }

    @Override
    protected void initData() {
        tvTitle.setText("楼宇资讯");

        buildInformAdapter = new BuildInformAdapter(mList);
        recycle_inform.setLayoutManager(new LinearLayoutManager(this));
        recycle_inform.setAdapter(buildInformAdapter);
        page =1;
        newsList();
    }

    @Override
    protected void initListen() {

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                newsList();
            }
        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                page =1;
                newsList();
            }
        });

        buildInformAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                    case R.id.image_header:
                        CutToUtils.getInstance().JumpToTwo(BuildingInformActivity.this,WebActivity.class,"资讯详情",AppUrl.NEWSTITLEURL+mList.get(position).getNewsId());
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

    /**
     * 获取资讯列表
     */
    private void newsList(){
        EasyHttp.get(AppUrl.NewsList)
                .params("pageNum", String.valueOf(page))
                .params("pageSize","10")
                .params("target","userNews")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        refresh.finishLoadMore();
                        refresh.finishRefresh();
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        NewsListBean newsListBean = JSON.parseObject(s, NewsListBean.class);
                        if (newsListBean.isSuccess()){
                            refresh.finishLoadMore();
                            refresh.finishRefresh();
                            List<NewsListBean.DataBean.RecordsBean> records = newsListBean.getData().getRecords();
                            for (int i = 0; i < records.size(); i++) {
                                if (i==0&&mList.size()==0){
                                    mList.add(new BuildInformBean(1,records.get(i).getTitle(),
                                            records.get(i).getContent(),records.get(i).getModifyTime()
                                    ,records.get(i).getNewsId()));
                                }else {
                                    mList.add(new BuildInformBean(2,records.get(i).getTitle(),
                                            records.get(i).getContent(),records.get(i).getModifyTime()
                                            ,records.get(i).getNewsId()));
                                }

                            }

                            buildInformAdapter.notifyDataSetChanged();
                        }else {
                            ToastShort(newsListBean.getMsg());
                        }
                    }
                });
    }
}
