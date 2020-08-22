package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class ComplainBean extends BaseBean {

    private String title;

    private String msg;

    private String time;

    private int progress; //维修进度 0 未开始 1进行中 2 未评价  3 已评价

    public ComplainBean(String title, String msg, String time, int progress) {
        this.title = title;
        this.msg = msg;
        this.time = time;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
