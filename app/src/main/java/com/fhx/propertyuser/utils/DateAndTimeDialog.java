package com.fhx.propertyuser.utils;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.event.EventLeaveComBean;
import com.fhx.propertyuser.fragment.time.DateFragment;
import com.fhx.propertyuser.fragment.time.TimeFragment;
import com.tencent.mmkv.MMKV;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期时间选择工具
 */
public class DateAndTimeDialog extends DialogFragment {
    private TextView tv_sure;
    private RadioGroup rg_time;
    private List<Fragment> fragments = new ArrayList<>();
    private MMKV mmkv;
    private String tag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0,0,0,0);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;

        window.setWindowAnimations(R.style.dialogAnimations);

        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setBackgroundDrawable(new ColorDrawable());
        window.setAttributes(lp);
        View view = inflater.inflate(R.layout.dialog_date_time, container, false);
        return view;

    }

    public DateAndTimeDialog(String tag) {
        this.tag = tag;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //设置dialog的大小
        mmkv = MMKV.defaultMMKV();

        rg_time = view.findViewById(R.id.rg_time);
        tv_sure = view.findViewById(R.id.tv_sure);
        //设置dialog的大小
        initData();
        initListener();
    }


    private void initData() {
        fragments.add(new DateFragment());
        fragments.add(new TimeFragment());
        SwitchFragment(0);

        DateTimeChange.setFragmentSelected(new ChangeFragment() {
            @Override
            public void change(int postion) {
                switch (postion){
                    case 0:
                        rg_time.check(R.id.rb_date);
                        SwitchFragment(0);
                        break;
                    case 1:
                        rg_time.check(R.id.rb_time);
                        SwitchFragment(1);
                        break;
                }
            }
        });
    }

    private void initListener() {
        rg_time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_date:
                        SwitchFragment(0);
                        break;
                    case R.id.rb_time:
                        SwitchFragment(1);
                        break;
                }
            }
        });
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mmkv.decodeString("chooseDate") + " " + mmkv.decodeString("chooseTime");

                EventLeaveComBean eventLeaveComBean = new EventLeaveComBean();
                eventLeaveComBean.setTag(tag);
                eventLeaveComBean.setTime(message);
                EventBus.getDefault().post(eventLeaveComBean);
                dismiss();
            }
        });
    }

    public void SwitchFragment(int i) {
        FragmentManager supportFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_date, fragments.get(i));
        fragmentTransaction.commit();
    }
}
