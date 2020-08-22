package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class OrderListBean extends BaseBean {

    private String title;
    private int total;
    private String time;
    private int ifPay;

    public OrderListBean(String title, int total, String time, int ifPay) {
        this.title = title;
        this.total = total;
        this.time = time;
        this.ifPay = ifPay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIfPay() {
        return ifPay;
    }

    public void setIfPay(int ifPay) {
        this.ifPay = ifPay;
    }
}
