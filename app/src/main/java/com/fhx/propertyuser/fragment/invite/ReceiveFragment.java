package com.fhx.propertyuser.fragment.invite;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.InviteReceiveAdapter;
import com.fhx.propertyuser.adapter.InviteSendAdapter;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.InviteSendBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 收到邀约
 */
public class ReceiveFragment extends BaseFragment {
    private LinearLayout ll_null;
    private RecyclerView recycle_invite;
    private InviteReceiveAdapter receiveAdapter;
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

        if (mList.size()>0){
            ll_null.setVisibility(View.GONE);
            receiveAdapter =new InviteReceiveAdapter(mList);
            recycle_invite.setLayoutManager(new LinearLayoutManager(getContext()));
            recycle_invite.setAdapter(receiveAdapter);

        }else {
            ll_null.setVisibility(View.VISIBLE);
        }
    }
}
