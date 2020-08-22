package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.base.BaseBean;

public class InformListBean extends BaseBean {

    private int ifRead;
    private String title;
    private String time;
    private String pageView; //浏览量

    public InformListBean(int ifRead, String title, String time, String pageView) {
        this.ifRead = ifRead;
        this.title = title;
        this.time = time;
        this.pageView = pageView;
    }

    public int getIfRead() {
        return ifRead;
    }

    public void setIfRead(int ifRead) {
        this.ifRead = ifRead;
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

    public String getPageView() {
        return pageView;
    }

    public void setPageView(String pageView) {
        this.pageView = pageView;
    }
}
