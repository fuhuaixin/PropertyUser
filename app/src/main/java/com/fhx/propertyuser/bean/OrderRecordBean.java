package com.fhx.propertyuser.bean;

public class OrderRecordBean {

    private String title;
    private String time;
    private String type;
    private int total;

    public OrderRecordBean(String title, String time, String type, int total) {
        this.title = title;
        this.time = time;
        this.type = type;
        this.total = total;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
