package com.fhx.propertyuser.bean;

public class SuccessBean {

    /**
     * success : true
     * msg : 注册成功
     */

    private boolean success;
    private Object data;
    private String msg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
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
