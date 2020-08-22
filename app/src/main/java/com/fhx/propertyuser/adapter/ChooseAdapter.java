package com.fhx.propertyuser.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.propertyuser.R;

import java.util.List;

public class ChooseAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ChooseAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_choose, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (helper.getPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }else {
            helper.setVisible(R.id.view_line,true);
        }

        helper.setText(R.id.tv_choose,item);

        helper.addOnClickListener(R.id.ll_item);
    }
}
