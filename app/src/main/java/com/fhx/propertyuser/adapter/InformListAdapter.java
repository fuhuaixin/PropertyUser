package com.fhx.propertyuser.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.InformListBean;

import java.util.List;

public class InformListAdapter extends BaseQuickAdapter<InformListBean, BaseViewHolder> {
    public InformListAdapter(@Nullable List<InformListBean> data) {
        super(R.layout.adapter_inform_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InformListBean item) {
        TextView tv_title = helper.getView(R.id.tv_title);
        if (item.getIfRead()==0){
            helper.setImageResource(R.id.image_isRead,R.mipmap.icon_inform_unread);
            tv_title.setTextColor(mContext.getResources().getColor(R.color.tv333));
        }else {
            helper.setImageResource(R.id.image_isRead,R.mipmap.icon_inform_read);
            tv_title.setTextColor(mContext.getResources().getColor(R.color.tva6));
        }

        helper.setText(R.id.tv_title,item.getTitle())
        .setText(R.id.tv_time,item.getTime())
        .setText(R.id.tv_page_view,item.getPageView());

        helper.addOnClickListener(R.id.ll_item);
    }
}
