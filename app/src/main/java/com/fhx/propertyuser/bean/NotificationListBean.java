package com.fhx.propertyuser.bean;

import java.util.List;

public class NotificationListBean {

    /**
     * success : true
     * data : {"records":[{"messageid":"002","messageType":"repaire","targetId":"345","messageContent":"ceshiceshi ","accepter":"18538323050","isAccept":"0","createTime":"2020-12-04 16:31:17"},{"messageid":"001","messageType":"repaire","targetId":"123","messageContent":"你接收到了这条消息哦","accepter":"15515505285","isAccept":"1","createTime":"2020-12-04 16:26:52"}],"total":2,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"messageid":"002","messageType":"repaire","targetId":"345","messageContent":"ceshiceshi ","accepter":"18538323050","isAccept":"0","createTime":"2020-12-04 16:31:17"},{"messageid":"001","messageType":"repaire","targetId":"123","messageContent":"你接收到了这条消息哦","accepter":"15515505285","isAccept":"1","createTime":"2020-12-04 16:26:52"}]
         * total : 2
         * size : 10
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 1
         */

        private int total;
        private int size;
        private int current;
        private boolean optimizeCountSql;
        private boolean hitCount;
        private Object countId;
        private Object maxLimit;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Object getCountId() {
            return countId;
        }

        public void setCountId(Object countId) {
            this.countId = countId;
        }

        public Object getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(Object maxLimit) {
            this.maxLimit = maxLimit;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean {
            /**
             * messageid : 002
             * messageType : repaire
             * targetId : 345
             * messageContent : ceshiceshi
             * accepter : 18538323050
             * isAccept : 0
             * createTime : 2020-12-04 16:31:17
             */

            private String messageid;
            private String messageType;
            private String targetId;
            private String messageContent;
            private String accepter;
            private String isAccept;
            private String createTime;

            public String getMessageid() {
                return messageid;
            }

            public void setMessageid(String messageid) {
                this.messageid = messageid;
            }

            public String getMessageType() {
                return messageType;
            }

            public void setMessageType(String messageType) {
                this.messageType = messageType;
            }

            public String getTargetId() {
                return targetId;
            }

            public void setTargetId(String targetId) {
                this.targetId = targetId;
            }

            public String getMessageContent() {
                return messageContent;
            }

            public void setMessageContent(String messageContent) {
                this.messageContent = messageContent;
            }

            public String getAccepter() {
                return accepter;
            }

            public void setAccepter(String accepter) {
                this.accepter = accepter;
            }

            public String getIsAccept() {
                return isAccept;
            }

            public void setIsAccept(String isAccept) {
                this.isAccept = isAccept;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
