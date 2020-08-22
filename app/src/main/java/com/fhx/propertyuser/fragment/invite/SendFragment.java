package com.fhx.propertyuser.fragment.invite;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.InviteSendAdapter;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.InviteSendBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 发出邀约
 */
public class SendFragment extends BaseFragment {

    private LinearLayout ll_null;
    private RecyclerView recycle_invite;
    private InviteSendAdapter sendAdapter;
    private List<InviteSendBean> mList =new ArrayList<>();

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
        mList.add(new InviteSendBean("张三","15875464564","2020.1.4","来访面试"));
        mList.add(new InviteSendBean("里斯","15875464564","2020.2.4","商务合作"));
        mList.add(new InviteSendBean("万物","15875464564","2020.3.4","来访面试"));

        if (mList.size()>0){
            ll_null.setVisibility(View.GONE);
            sendAdapter =new InviteSendAdapter(mList);
            recycle_invite.setLayoutManager(new LinearLayoutManager(getContext()));
            recycle_invite.setAdapter(sendAdapter);

        }else {
            ll_null.setVisibility(View.VISIBLE);
        }



    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
    }
}
