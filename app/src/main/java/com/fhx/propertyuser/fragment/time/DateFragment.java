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
                Toast.makeText(getContext(), year+"年"+month+"月"+dayOfMonth, Toast.LENGTH_SHORT).show();
                DateTimeChange.sChangeFragment.change(1);
            }
        });
    }
}
