package com.fhx.propertyuser.fragment.invite;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.InviteSendAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.InviteSendBean;
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
 * 发出邀约
 */
public class SendFragment extends BaseFragment {

    private LinearLayout ll_null;
    private RecyclerView recycle_invite;
    private SmartRefreshLayout refresh;

    private InviteSendAdapter sendAdapter;
    private List<InviteSendBean.DataBean.RecordsBean> mList =new ArrayList<>();
    private int page;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_invite_send;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        ll_null =view.findViewById(R.id.ll_null);
        recycle_invite =view.findViewById(R.id.recycle_invite);
        refresh =view.findViewById(R.id.refresh);

    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        sendAdapter =new InviteSendAdapter(mList);
        recycle_invite.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_invite.setAdapter(sendAdapter);
        page=1;
        mList.clear();
        getList();

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                mList.clear();
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
    }


    private void getList(){
        EasyHttp.get(AppUrl.Visitorlist)
                .syncRequest(false)
                .params("pageNum", String.valueOf(page))
                .params("pageSize","5")
                .params("promoter",mmkv.decodeString("userPhone"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        InviteSendBean inviteSendBean = JSON.parseObject(s, InviteSendBean.class);

                        refresh.finishRefresh();
                        refresh.finishLoadMore();

                        if (inviteSendBean.isSuccess()){
                            mList.addAll(inviteSendBean.getData().getRecords());
                            if (mList.size()>0){
                                ll_null.setVisibility(View.GONE);
                            }else {
                                ll_null.setVisibility(View.VISIBLE);
                            }
                            sendAdapter.notifyDataSetChanged();
                        }else {
                            Toast.makeText(mActivity, inviteSendBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
