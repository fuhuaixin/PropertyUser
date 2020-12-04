package com.fhx.propertyuser.bean;

public class AuditResultBean {

    /**
     * success : true
     * data : {"auditId":"35bda882656e4a2e60c5949f5dd611d2","result":"3","phone":"15738531698"}
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
         * auditId : 35bda882656e4a2e60c5949f5dd611d2
         * result : 3
         * phone : 15738531698
         */

        private String auditId;
        private String result;
        private String phone;

        public String getAuditId() {
            return auditId;
        }

        public void setAuditId(String auditId) {
            this.auditId = auditId;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
