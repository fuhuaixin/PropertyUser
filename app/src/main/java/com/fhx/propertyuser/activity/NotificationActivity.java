package com.fhx.propertyuser.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.NotifiListAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.NotificationListBean;
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
 * 推送消息列表页
 */
public class NotificationActivity extends BaseActivity {
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle;
    private SmartRefreshLayout refresh;

    private NotifiListAdapter notifiListAdapter;
    private List<NotificationListBean.DataBean.RecordsBean> mList =new ArrayList<>();
    private int page;
    @Override
    protected int initLayout() {
        return R.layout.activity_notification;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        refresh = (SmartRefreshLayout) findViewById(R.id.refresh);
    }

    @Override
    protected void initData() {
        tvTitle.setText("推送消息");

        recycle.setLayoutManager(new LinearLayoutManager(this));
        notifiListAdapter =new NotifiListAdapter(mList);
        recycle.setAdapter(notifiListAdapter);
        page=1;
        getList();
    }

    @Override
    protected void initListen() {

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                page =1;
                getList();
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getList();
            }
        });

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });

    }

    private void getList(){
        EasyHttp.get(AppUrl.MessageList)
                .params("pageNum", String.valueOf(page))
                .params("pageSize","5")
//                .params("accepter",mmkv.decodeString("userPhone"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        refresh.finishLoadMore();
                        refresh.finishRefresh();
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh.finishLoadMore();
                        refresh.finishRefresh();

                        NotificationListBean notificationListBean = JSON.parseObject(s, NotificationListBean.class);
                        if (notificationListBean.isSuccess()){
                            mList.addAll(notificationListBean.getData().getRecords());
                            notifiListAdapter.notifyDataSetChanged();
                        }else {
                            ToastShort(notificationListBean.getMsg());
                        }
                    }
                });
    }
}
