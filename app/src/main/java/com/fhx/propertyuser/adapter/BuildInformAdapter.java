package com.fhx.propertyuser.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.bean.BuildInformBean;

import java.util.List;

public class BuildInformAdapter extends BaseMultiItemQuickAdapter<BuildInformBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public BuildInformAdapter(List<BuildInformBean> data) {
        super(data);
        addItemType(1, R.layout.adapter_build_inform_one);
        addItemType(2, R.layout.adapter_build_inform_two);
    }

    @Override
    protected void convert(BaseViewHolder helper, BuildInformBean item) {
        switch (helper.getItemViewType()){
            case 1:
                helper.setText(R.id.tv_title,item.getTitle());
                helper.addOnClickListener(R.id.image_header);
                break;
            case 2:
                helper.setText(R.id.tv_title,item.getTitle())
                        .setText(R.id.tv_msg,item.getMsg())
                        .setText(R.id.tv_time,item.getTime());
                helper.addOnClickListener(R.id.ll_item);

                break;
        }
    }
}
