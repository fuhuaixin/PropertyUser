package com.fhx.propertyuser.fragment.repair;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.RepairMsgActivity;
import com.fhx.propertyuser.adapter.NoStartAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.RepairListBean;
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

public class NoStartFragment extends BaseFragment {
    private LinearLayout ll_null;
    private RecyclerView recycle_invite;
    private SmartRefreshLayout refresh;
    private NoStartAdapter noStartAdapter;
    private List<RepairListBean.DataBean.RecordsBean> mList = new ArrayList<>();
    private String type;
    private int page = 1; //第几页

    public NoStartFragment(String type) {
        this.type = type;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_invite_send;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        ll_null = view.findViewById(R.id.ll_null);
        recycle_invite = view.findViewById(R.id.recycle_invite);
        refresh = view.findViewById(R.id.refresh);
    }

    @Override
    public void onResume() {
        super.onResume();
        mList.clear();
        page = 1;
        switch (type) {
            case "未开始":
                getList(page, "0");
                break;
            case "进行中":
                getList(page, "1");
                break;
            case "已完成":
                getList(page, "-1");
                break;
        }


    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        noStartAdapter = new NoStartAdapter(mList);
        recycle_invite.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_invite.setAdapter(noStartAdapter);

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                page = 1;
                switch (type) {
                    case "未开始":
                        getList(page, "0");
                        break;
                    case "进行中":
                        getList(page, "1");
                        break;
                    case "已完成":
                        getList(page, "-1");
                        break;
                }
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                switch (type) {
                    case "未开始":
                        getList(page, "0");
                        break;
                    case "进行中":
                        getList(page, "1");
                        break;
                    case "已完成":
                        getList(page, "-1");
                        break;
                }
            }
        });
        noStartAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String repairId = mList.get(position).getRepairId();
                switch (mList.get(position).getStatus()) {
                    case "0":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "0",repairId);
                        break;
                    case "1":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "1",repairId);

                        break;
                    case "2":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "2",repairId);
                        break;
                    case "5":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "5",repairId);

                        break;
                    case "3":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "3",repairId);
                        break;
                    case "4":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "4",repairId);
                        break;
                    case "6":
                        CutToUtils.getInstance().JumpToTwo(getActivity(), RepairMsgActivity.class, "6",repairId);
                        break;
                }
            }
        });
    }

    /**
     * 获取报修列表
     *
     * @param page
     * @param status
     */
    private void getList(int page, String status) {
        EasyHttp.get(AppUrl.RepairList)
                .syncRequest(false)
                .params("pageNum", String.valueOf(page))
                .params("pageSize", "10")
                .params("customerId", mmkv.decodeString("customerId"))
                .params("status", status)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        RepairListBean repairListBean = JSON.parseObject(s, RepairListBean.class);
                        if (repairListBean.isSuccess()) {
                            refresh.finishRefresh();
                            refresh.finishLoadMore();
                            mList.addAll(repairListBean.getData().getRecords());

                            if (mList.size() > 0) {
                                ll_null.setVisibility(View.GONE);
                            } else {
                                ll_null.setVisibility(View.VISIBLE);
                            }
                            noStartAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(mActivity, repairListBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
