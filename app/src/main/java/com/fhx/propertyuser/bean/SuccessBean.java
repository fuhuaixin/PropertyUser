package com.fhx.propertyuser.bean;

public class SuccessBean {

    /**
     * success : true
     * msg : 注册成功
     */

    private boolean success;
    private boolean data;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
