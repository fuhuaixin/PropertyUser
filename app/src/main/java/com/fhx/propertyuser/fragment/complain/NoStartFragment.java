package com.fhx.propertyuser.fragment.complain;

import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.ComplainMsgActivity;
import com.fhx.propertyuser.activity.RepairMsgActivity;
import com.fhx.propertyuser.adapter.ComplainAdapter;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.ComplainBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class NoStartFragment extends BaseFragment {

    private LinearLayout ll_null;
    private RecyclerView recycle_invite;

    private ComplainAdapter complainAdapter;
    private List<ComplainBean> mList =new ArrayList<>();
    private String type;

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
        ll_null =view.findViewById(R.id.ll_null);
        recycle_invite =view.findViewById(R.id.recycle_invite);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        mList.clear();
        switch (type){
            case "未开始":
                for (int i = 0; i < 10; i++) {
                    mList.add(new ComplainBean("隔壁房间噪音"+i,"噪音影响"+i,"8.20",0));
                }

                break;
            case "进行中":
                for (int i = 0; i < 10; i++) {
                    mList.add(new ComplainBean("空调漏水"+i,"空调漏水"+i,"8.10",1));
                }
                break;
            case "已完成":
                mList.add(new ComplainBean("空调漏水","空调漏水","8.10",2));
                mList.add(new ComplainBean("空调漏水","空调漏水","8.10",2));
                mList.add(new ComplainBean("空调漏水","空调漏水","8.10",2));
                mList.add(new ComplainBean("隔壁房间噪音","噪音影响","8.10",3));
                mList.add(new ComplainBean("隔壁房间噪音","噪音影响","8.10",3));
                mList.add(new ComplainBean("隔壁房间噪音","噪音影响","8.10",3));
                break;
        }

        if (mList.size()>0){
            ll_null.setVisibility(View.GONE);
        }else {
            ll_null.setVisibility(View.VISIBLE);
        }

        complainAdapter =new ComplainAdapter(mList);
        recycle_invite.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_invite.setAdapter(complainAdapter);

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        complainAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (mList.get(position).getProgress()){
                    case 0:
                        CutToUtils.getInstance().JumpToOne(getActivity(), ComplainMsgActivity.class,"one");
                        break;
                    case 1:
                        CutToUtils.getInstance().JumpToOne(getActivity(), ComplainMsgActivity.class,"two");

                        break;
                    case 2:
                        CutToUtils.getInstance().JumpToOne(getActivity(), ComplainMsgActivity.class,"three");

                        break;
                    case 3:
                        CutToUtils.getInstance().JumpToOne(getActivity(), ComplainMsgActivity.class,"four");
                        break;
                }
            }
        });
    }
}
