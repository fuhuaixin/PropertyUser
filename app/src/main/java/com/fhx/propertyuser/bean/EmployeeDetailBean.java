package com.fhx.propertyuser.bean;

public class EmployeeDetailBean {

    /**
     * success : true
     * data : {"employeeId":"f7e725ffbe9d96f452327e7fc5910912","employeeName":"客服","employeeNo":"NO-0000044","sex":"1","phone":"187371354","phoneBackup":"16608831825","mail":"1621700974@qq.com","birthday":"1980-09-02","nation":"汉族","dutyName":"员工","deptId":"129a334b6006e21433b3c30eb2a8f525","deptName":null,"address":null,"inDate":"2019-08-02 12:32:45","outDate":null,"status":"1","systemEnable":"0","notes":"这里是备注","createTime":null,"updateTime":"2020-11-09 11:41:52"}
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
         * employeeId : f7e725ffbe9d96f452327e7fc5910912
         * employeeName : 客服
         * employeeNo : NO-0000044
         * sex : 1
         * phone : 187371354
         * phoneBackup : 16608831825
         * mail : 1621700974@qq.com
         * birthday : 1980-09-02
         * nation : 汉族
         * dutyName : 员工
         * deptId : 129a334b6006e21433b3c30eb2a8f525
         * deptName : null
         * address : null
         * inDate : 2019-08-02 12:32:45
         * outDate : null
         * status : 1
         * systemEnable : 0
         * notes : 这里是备注
         * createTime : null
         * updateTime : 2020-11-09 11:41:52
         */

        private String employeeId;
        private String employeeName;
        private String employeeNo;
        private String sex;
        private String phone;
        private String phoneBackup;
        private String mail;
        private String birthday;
        private String nation;
        private String dutyName;
        private String deptId;
        private Object deptName;
        private Object address;
        private String inDate;
        private Object outDate;
        private String status;
        private String systemEnable;
        private String notes;
        private Object createTime;
        private String updateTime;

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeNo() {
            return employeeNo;
        }

        public void setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoneBackup() {
            return phoneBackup;
        }

        public void setPhoneBackup(String phoneBackup) {
            this.phoneBackup = phoneBackup;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getDutyName() {
            return dutyName;
        }

        public void setDutyName(String dutyName) {
            this.dutyName = dutyName;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public Object getDeptName() {
            return deptName;
        }

        public void setDeptName(Object deptName) {
            this.deptName = deptName;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public String getInDate() {
            return inDate;
        }

        public void setInDate(String inDate) {
            this.inDate = inDate;
        }

        public Object getOutDate() {
            return outDate;
        }

        public void setOutDate(Object outDate) {
            this.outDate = outDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSystemEnable() {
            return systemEnable;
        }

        public void setSystemEnable(String systemEnable) {
            this.systemEnable = systemEnable;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
