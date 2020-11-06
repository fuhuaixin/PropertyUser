package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class CarMsgBean extends BaseBean {


    /**
     * success : true
     * data : {"carId":"12bc744ace970960f27759a26de896d7","carNo":"赣b22222","customerId":"c398c9ba5eb7e189bdd4c215132d8276","carOwner":"Wode ","ownerPhone":"15825802580","parkingNo":"4578946","isBaned":"0","carType":"1","updateTime":null,"createTime":"2020-11-06 11:57:42","isDeleted":"0"}
     */

    private boolean success;
    private DataBean data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * carId : 12bc744ace970960f27759a26de896d7
         * carNo : 赣b22222
         * customerId : c398c9ba5eb7e189bdd4c215132d8276
         * carOwner : Wode
         * ownerPhone : 15825802580
         * parkingNo : 4578946
         * isBaned : 0
         * carType : 1
         * updateTime : null
         * createTime : 2020-11-06 11:57:42
         * isDeleted : 0
         */

        private String carId;
        private String carNo;
        private String customerId;
        private String carOwner;
        private String ownerPhone;
        private String parkingNo;
        private String isBaned;
        private String carType;
        private Object updateTime;
        private String createTime;
        private String isDeleted;

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCarOwner() {
            return carOwner;
        }

        public void setCarOwner(String carOwner) {
            this.carOwner = carOwner;
        }

        public String getOwnerPhone() {
            return ownerPhone;
        }

        public void setOwnerPhone(String ownerPhone) {
            this.ownerPhone = ownerPhone;
        }

        public String getParkingNo() {
            return parkingNo;
        }

        public void setParkingNo(String parkingNo) {
            this.parkingNo = parkingNo;
        }

        public String getIsBaned() {
            return isBaned;
        }

        public void setIsBaned(String isBaned) {
            this.isBaned = isBaned;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }
    }
}
