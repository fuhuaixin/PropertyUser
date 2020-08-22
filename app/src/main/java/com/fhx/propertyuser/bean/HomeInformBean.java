package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class HomeInformBean extends BaseBean {

    private String type; //
    private String title; //
    private String time; //
    private String msg; //

    public HomeInformBean(String type, String title, String time, String msg) {
        this.type = type;
        this.title = title;
        this.time = time;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
