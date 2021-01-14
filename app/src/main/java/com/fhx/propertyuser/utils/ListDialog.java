package com.fhx.propertyuser.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.ChooseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * 图片选择 和 照片选择dialog
 */
public class ListDialog extends Dialog implements View.OnClickListener, BaseQuickAdapter.OnItemChildClickListener {


    private Context mContext;
    private TextView tv_cancel, tv_camera, tv_choose;
    private LeaveMyDialogListener listener;
    private RecyclerView recycle_choose;
    private LinearLayout ll_all;
    private ChooseAdapter adapter;
    private List<String > chooseList = new ArrayList<>();

    public ListDialog(@NonNull Context context) {
        super(context, R.style.ListDialog);

    }

    public ListDialog(@NonNull Context context, List<String> chooseList, LeaveMyDialogListener listener) {
        super(context, R.style.ListDialog);
        this.mContext =context;
        this.chooseList =chooseList;
        this.listener =listener;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        listener.onClick(adapter,view,position);
    }

    public interface LeaveMyDialogListener{
        public void onClick(BaseQuickAdapter adapter, View view, int position);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_camera_choose);

        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialogAnimations);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        initViews();
        initData();
    }

    private void initViews() {
        tv_cancel = findViewById(R.id.tv_cancel);
        recycle_choose  =findViewById(R.id.recycle_choose);
        ll_all  =findViewById(R.id.ll_all);
        tv_cancel.setOnClickListener(this);
    }

    private void initData() {

        adapter = new ChooseAdapter(chooseList);
        recycle_choose.setLayoutManager(new LinearLayoutManager(mContext));
        recycle_choose.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
        ViewGroup.LayoutParams layoutParams = ll_all.getLayoutParams();

        ll_all.setLayoutParams(layoutParams);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
        }
    }

}
