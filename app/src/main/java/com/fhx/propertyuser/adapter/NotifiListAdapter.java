package com.fhx.propertyuser.adapter;

import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.InformListBean;
import com.fhx.propertyuser.bean.NotificationListBean;

import java.util.List;

public class NotifiListAdapter extends BaseQuickAdapter<NotificationListBean.DataBean.RecordsBean, BaseViewHolder> {
    public NotifiListAdapter(@Nullable List<NotificationListBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_inform_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NotificationListBean.DataBean.RecordsBean item) {
        TextView tv_title = helper.getView(R.id.tv_title);
        if (item.getIsAccept().equals("0")){ //0未读  1 已读
            helper.setImageResource(R.id.image_isRead,R.mipmap.icon_inform_unread);
            tv_title.setTextColor(mContext.getResources().getColor(R.color.tv333));
        }else {
            helper.setImageResource(R.id.image_isRead,R.mipmap.icon_inform_read);
            tv_title.setTextColor(mContext.getResources().getColor(R.color.tva6));
        }
        helper.setVisible(R.id.tv_page_view,true);
        helper.setText(R.id.tv_title,item.getMessageContent())
        .setText(R.id.tv_time,item.getCreateTime())
        .setText(R.id.tv_page_view,item.getMessageType());

        helper.addOnClickListener(R.id.ll_item);
    }
}
