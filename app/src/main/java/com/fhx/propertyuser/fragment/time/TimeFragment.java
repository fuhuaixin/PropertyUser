package com.fhx.propertyuser.fragment.time;

import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseFragment;

public class TimeFragment extends BaseFragment {
    TimePicker timePacker;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_time;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        timePacker =view.findViewById(R.id.timePacker);
    }

    @Override
    public void setViewData(View view)    {
        super.setViewData(view);
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        timePacker.setIs24HourView(true);
        timePacker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (minute==0){
                    mmkv.encode("chooseTime",hourOfDay+":00:00");
                }else if (hourOfDay==0){
                    mmkv.encode("chooseTime","00"+":"+minute+":00");
                }else {
                    mmkv.encode("chooseTime",hourOfDay+":"+minute+":00");
                }
            }
        });
    }
}
