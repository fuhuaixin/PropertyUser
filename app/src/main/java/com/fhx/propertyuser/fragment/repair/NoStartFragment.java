package com.fhx.propertyuser.fragment.repair;

import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.RepairMsgActivity;
import com.fhx.propertyuser.adapter.NoStartAdapter;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.RepairListBean;
import com.fhx.propertyuser.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class NoStartFragment extends BaseFragment {
    private LinearLayout ll_null;
    private RecyclerView recycle_invite;
    private NoStartAdapter noStartAdapter ;
    private List<RepairListBean> mList =new ArrayList<>();
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
                mList.add(new RepairListBean("张三","空调漏水","2020.8.10","漏水了","9.12",0));
                mList.add(new RepairListBean("里斯","空调漏水2","2020.9.10","漏水了","9.15",0));
                mList.add(new RepairListBean("张慌三","空调漏水3","2020.9.19","漏水了","9.18",0));
                break;
            case "进行中":
                mList.add(new RepairListBean("张三","空调漏水1进行中","2020.8.10","漏水了","9.12",1));
                mList.add(new RepairListBean("里斯","空调漏水2进行中","2020.9.10","漏水了","9.15",1));
                mList.add(new RepairListBean("张慌三","空调漏水3进行中","2020.9.19","漏水了","9.18",1));
                break;
            case "已完成":
                mList.add(new RepairListBean("张三","空调漏水1未评价","2020.8.10","漏水了","9.12",2));
                mList.add(new RepairListBean("里斯","空调漏水2未评价","2020.9.10","漏水了","9.15",2));
                mList.add(new RepairListBean("张慌三","空调漏水3已完成","2020.9.19","漏水了","9.18",3));
                mList.add(new RepairListBean("张慌三","空调漏水3已完成","2020.9.19","漏水了","9.18",3));

                break;
        }


        if (mList.size()>0){
            ll_null.setVisibility(View.GONE);
        }else {
            ll_null.setVisibility(View.VISIBLE);
        }
        noStartAdapter =new NoStartAdapter(mList);
        recycle_invite.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_invite.setAdapter(noStartAdapter);
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        noStartAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (mList.get(position).getProgress()){
                    case 0:
                        CutToUtils.getInstance().JumpToOne(getActivity(), RepairMsgActivity.class,"one");
                        break;
                    case 1:
                        CutToUtils.getInstance().JumpToOne(getActivity(), RepairMsgActivity.class,"two");

                        break;
                    case 2:
                        CutToUtils.getInstance().JumpToOne(getActivity(), RepairMsgActivity.class,"three");

                        break;
                    case 3:
                        CutToUtils.getInstance().JumpToOne(getActivity(), RepairMsgActivity.class,"four");
                        break;
                }
            }
        });
    }

}
