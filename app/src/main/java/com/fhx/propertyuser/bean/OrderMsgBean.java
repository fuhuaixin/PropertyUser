package com.fhx.propertyuser.bean;

public class OrderMsgBean  {

    private String payType;
    private String name;
    private String homeNo;
    private String address;
    private String unit; //单位
    private String time; //周期
    private int needPay; //欠费

    public OrderMsgBean(String payType, String name, String homeNo, String address, String unit, String time, int needPay) {
        this.payType = payType;
        this.name = name;
        this.homeNo = homeNo;
        this.address = address;
        this.unit = unit;
        this.time = time;
        this.needPay = needPay;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNeedPay() {
        return needPay;
    }

    public void setNeedPay(int needPay) {
        this.needPay = needPay;
    }
}
