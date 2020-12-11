package com.fhx.propertyuser.bean;

public class EvaMsgBean {

    /**
     * success : true
     * data : {"evaluteId":"9fd3f2fe7ebd1505422ef82dfdf7beac","createTime":"2020-10-20T02:47:25.000+00:00","originId":"c942e1100dd5af302612240f4d3ba984","originType":"0","rateScore":5,"customerId":"1","content":"你好么 我很好"}
     */

    private boolean success;
    private DataBean data;

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
         * evaluteId : 9fd3f2fe7ebd1505422ef82dfdf7beac
         * createTime : 2020-10-20T02:47:25.000+00:00
         * originId : c942e1100dd5af302612240f4d3ba984
         * originType : 0
         * rateScore : 5
         * customerId : 1
         * content : 你好么 我很好
         */

        private String evaluteId;
        private String createTime;
        private String originId;
        private String originType;
        private int rateScore;
        private String customerId;
        private String content;

        public String getEvaluteId() {
            return evaluteId;
        }

        public void setEvaluteId(String evaluteId) {
            this.evaluteId = evaluteId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getOriginId() {
            return originId;
        }

        public void setOriginId(String originId) {
            this.originId = originId;
        }

        public String getOriginType() {
            return originType;
        }

        public void setOriginType(String originType) {
            this.originType = originType;
        }

        public int getRateScore() {
            return rateScore;
        }

        public void setRateScore(int rateScore) {
            this.rateScore = rateScore;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
