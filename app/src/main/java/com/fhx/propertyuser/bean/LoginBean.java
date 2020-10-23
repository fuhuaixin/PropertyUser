package com.fhx.propertyuser.bean;

public class LoginBean {

    /**
     * success : true
     * data : {"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMzk4YzliYTVlYjdlMTg5YmRkNGMyMTUxMzJkODI3NiJ9.QfYWN5xUYMbr92liCHWHIg5EGf28OMtWw8WsQGh2cic","customer":{"customerId":"c398c9ba5eb7e189bdd4c215132d8276","customerName":null,"phone":"15738531698","password":"e10adc3949ba59abbe56e057f20f883e","phoneBackup":null,"peopleId":null,"company":null,"logoUrl":null,"notes":null,"status":null,"updateTime":null,"registerType":null}}
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
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMzk4YzliYTVlYjdlMTg5YmRkNGMyMTUxMzJkODI3NiJ9.QfYWN5xUYMbr92liCHWHIg5EGf28OMtWw8WsQGh2cic
         * customer : {"customerId":"c398c9ba5eb7e189bdd4c215132d8276","customerName":null,"phone":"15738531698","password":"e10adc3949ba59abbe56e057f20f883e","phoneBackup":null,"peopleId":null,"company":null,"logoUrl":null,"notes":null,"status":null,"updateTime":null,"registerType":null}
         */

        private String token;
        private CustomerBean customer;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public CustomerBean getCustomer() {
            return customer;
        }

        public void setCustomer(CustomerBean customer) {
            this.customer = customer;
        }

        public static class CustomerBean {
            /**
             * customerId : c398c9ba5eb7e189bdd4c215132d8276
             * customerName : null
             * phone : 15738531698
             * password : e10adc3949ba59abbe56e057f20f883e
             * phoneBackup : null
             * peopleId : null
             * company : null
             * logoUrl : null
             * notes : null
             * status : null
             * updateTime : null
             * registerType : null
             */

            private String customerId;
            private Object customerName;
            private String phone;
            private String password;
            private Object phoneBackup;
            private Object peopleId;
            private Object company;
            private Object logoUrl;
            private Object notes;
            private Object status;
            private Object updateTime;
            private Object registerType;

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public Object getCustomerName() {
                return customerName;
            }

            public void setCustomerName(Object customerName) {
                this.customerName = customerName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getPhoneBackup() {
                return phoneBackup;
            }

            public void setPhoneBackup(Object phoneBackup) {
                this.phoneBackup = phoneBackup;
            }

            public Object getPeopleId() {
                return peopleId;
            }

            public void setPeopleId(Object peopleId) {
                this.peopleId = peopleId;
            }

            public Object getCompany() {
                return company;
            }

            public void setCompany(Object company) {
                this.company = company;
            }

            public Object getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(Object logoUrl) {
                this.logoUrl = logoUrl;
            }

            public Object getNotes() {
                return notes;
            }

            public void setNotes(Object notes) {
                this.notes = notes;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRegisterType() {
                return registerType;
            }

            public void setRegisterType(Object registerType) {
                this.registerType = registerType;
            }
        }
    }
}
