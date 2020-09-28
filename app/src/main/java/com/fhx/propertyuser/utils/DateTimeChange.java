package com.fhx.propertyuser.utils;

import com.fhx.propertyuser.fragment.time.DateFragment;
import com.fhx.propertyuser.fragment.time.TimeFragment;

public class DateTimeChange {
    private static DateFragment dateFragment; //日期fragemnt
    private static TimeFragment timeFragment; //时间fragemnt
    public static ChangeFragment sChangeFragment;  //改变选中Frangment的接口
    /**
     * 获取主页Fragment
     *
     * @return
     */
    public static DateFragment getDateFragment() {
        if (dateFragment == null) {
            dateFragment = new DateFragment();
        }
        return dateFragment;
    }

    /**
     * 走势图fragemnt
     *
     * @return
     */
    public static TimeFragment getTimeFragment() {
        if (timeFragment == null) {
            timeFragment = new TimeFragment();
        }
        return timeFragment;
    }

    /**
     * 设置被选中的Fragment
     * @param changeFragment
     */
    public static void setFragmentSelected(ChangeFragment changeFragment) {
        sChangeFragment = changeFragment;
    }
}
