package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.NewsListBean;

import java.util.List;

public class HomeInformAdapter extends BaseQuickAdapter<NewsListBean.DataBean.RecordsBean, BaseViewHolder> {
    public HomeInformAdapter( @Nullable List<NewsListBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_home_inform, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsListBean.DataBean.RecordsBean item) {
        helper.setText(R.id.tv_type,item.getNewsType())
                .setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_time,item.getModifyTime())
                .setText(R.id.tv_msg,item.getContent());

        helper.addOnClickListener(R.id.ll_item);
    }
}
