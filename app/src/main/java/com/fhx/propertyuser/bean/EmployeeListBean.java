package com.fhx.propertyuser.bean;

import java.util.List;

public class EmployeeListBean  {

    /**
     * success : true
     * data : [{"employeeName":"客服","phone":"187371354","employeeId":"f7e725ffbe9d96f452327e7fc5910912","employeeNo":"NO-0000044"},{"employeeName":"部门经理","phone":"187354755","employeeId":"f7e725ffbe9d96f452327e7fc5910913","employeeNo":"NO-0000045"},{"employeeName":"部门领导","phone":"1875456555","employeeId":"f7e725ffbe9d96f452327e7fc5910914","employeeNo":"NO-0000046"},{"employeeName":"菲仕乐","phone":"18737144555","employeeId":"f7e725ffbe9d96f454327e7fc5910911","employeeNo":"NO-0000043"}]
     */

    private boolean success;
    private List<DataBean> data;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * employeeName : 客服
         * phone : 187371354
         * employeeId : f7e725ffbe9d96f452327e7fc5910912
         * employeeNo : NO-0000044
         */

        private String employeeName;
        private String phone;
        private String employeeId;
        private String employeeNo;

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeNo() {
            return employeeNo;
        }

        public void setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
        }
    }
}
