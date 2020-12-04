package com.fhx.propertyuser.activity;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.InformListAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.InformListBean;
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
 * 通知公告列表
 */
public class InformListActivity extends BaseActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_inform;
    private SmartRefreshLayout refresh;

    private InformListAdapter informListAdapter;
    private List<InformListBean> mList = new ArrayList<>();
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
        tvTitle.setText("通知公告");

        informListAdapter = new InformListAdapter(mList);
        recycle_inform.setLayoutManager(new LinearLayoutManager(this));
        recycle_inform.setAdapter(informListAdapter);
        page = 1;
        newList();
    }

    @Override
    protected void initListen() {

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                page = 1;
                newList();
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                newList();
            }
        });

        informListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToTwo(InformListActivity.this, WebActivity.class, "通知公告",
                        AppUrl.NEWSTITLEURL + mList.get(position).getNewId());
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
     * 获取列表
     */
    private void newList() {
        EasyHttp.get(AppUrl.NewsList)
                .params("pageNum", String.valueOf(page))
                .params("pageSize", "10")
                .params("target", "userAnnounce")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                        NewsListBean newsListBean = JSON.parseObject(s, NewsListBean.class);
                        if (newsListBean.isSuccess()) {
                            List<NewsListBean.DataBean.RecordsBean> records = newsListBean.getData().getRecords();
                            for (int i = 0; i < records.size(); i++) {
                                mList.add(new InformListBean(0,
                                        records.get(i).getTitle(),
                                        records.get(i).getModifyTime(),
                                        records.get(i).getNewsId()));
                            }
                            informListAdapter.notifyDataSetChanged();
                        } else {
                            ToastShort(newsListBean.getMsg());
                        }
                    }
                });
    }
}
