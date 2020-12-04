package com.fhx.propertyuser.fragment.time;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.utils.DateTimeChange;

public class DateFragment extends BaseFragment {
    CalendarView calendar;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_date;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        calendar =view.findViewById(R.id.calendar);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String mMonth = null;
                String day = null;
                if (month<9){
                    mMonth="0"+(month+1);
                }else {
                    mMonth = String.valueOf((month+1));
                }
                if (dayOfMonth<10){
                    day="0"+dayOfMonth;
                }else {
                    day = String.valueOf(dayOfMonth);
                }
                mmkv.encode("chooseDate",year+"-"+mMonth+"-"+day);

                DateTimeChange.sChangeFragment.change(1);
            }
        });
    }
}
