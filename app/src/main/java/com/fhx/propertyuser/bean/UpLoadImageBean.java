package com.fhx.propertyuser.bean;

public class UpLoadImageBean {

    /**
     * data : {"name":"20201207171029761small.jpg","url":"http://192.168.10.50:8055/sqzhly-img/20201207171029761small.jpg"}
     * success : true
     */

    private DataBean data;
    private boolean success;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * name : 20201207171029761small.jpg
         * url : http://192.168.10.50:8055/sqzhly-img/20201207171029761small.jpg
         */

        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
