package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class CarManageBean extends BaseBean {

    private String  carNumber;
    private String  carBrand; //品牌
    private String  VIN; //车辆识别代码
    private String  vinNo; // 发动机号
    private String  carOwner; // c车主
    private String  recordDate; // 注册日期
    private String  carType; // 车辆类型
    private String  function; // 使用性质

    public CarManageBean(String carNumber, String carBrand, String VIN, String vinNo, String carOwner, String recordDate, String carType, String function) {
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.VIN = VIN;
        this.vinNo = vinNo;
        this.carOwner = carOwner;
        this.recordDate = recordDate;
        this.carType = carType;
        this.function = function;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVinNo() {
        return vinNo;
    }

    public void setVinNo(String vinNo) {
        this.vinNo = vinNo;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
