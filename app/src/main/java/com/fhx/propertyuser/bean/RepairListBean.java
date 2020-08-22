package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class RepairListBean extends BaseBean {

    private String name;
    private String eventType; //时间类型
    private String repairTime;//报修时间
    private String describe; //描述
    private String appointmentTime; //预约时间
    private int progress; //维修进度 0 未开始 1进行中 2 未评价  3 已评价

    public RepairListBean(String name, String eventType, String repairTime, String describe, String appointmentTime, int progress) {
        this.name = name;
        this.eventType = eventType;
        this.repairTime = repairTime;
        this.describe = describe;
        this.appointmentTime = appointmentTime;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
