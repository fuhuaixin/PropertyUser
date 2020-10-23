package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class RepairListBean extends BaseBean {


    /**
     * success : true
     * data : {"records":[{"repairId":"31ff92f7054453a86b80f3c95c365ac7","createTime":"2020-10-22T01:18:30.000+00:00","customerId":"c398c9ba5eb7e189bdd4c215132d8276","repairTypeId":"2a46dd776db4ed9f9eaed339cc9f741a","repairTypeName":"墙面类","spaceId":null,"spaceNo":null,"customerPhone":"15738531698","reserveTime":null,"notes":"事实上地址","updatetime":null,"floor":null,"customerName":"这是我的名字","content":"这是我的问题描述","status":"0","originType":"1"}],"total":1,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"repairId":"31ff92f7054453a86b80f3c95c365ac7","createTime":"2020-10-22T01:18:30.000+00:00","customerId":"c398c9ba5eb7e189bdd4c215132d8276","repairTypeId":"2a46dd776db4ed9f9eaed339cc9f741a","repairTypeName":"墙面类","spaceId":null,"spaceNo":null,"customerPhone":"15738531698","reserveTime":null,"notes":"事实上地址","updatetime":null,"floor":null,"customerName":"这是我的名字","content":"这是我的问题描述","status":"0","originType":"1"}]
         * total : 1
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
        private String countId;
        private String maxLimit;
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

        public String getCountId() {
            return countId;
        }

        public void setCountId(String countId) {
            this.countId = countId;
        }

        public String getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(String maxLimit) {
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
             * repairId : 31ff92f7054453a86b80f3c95c365ac7
             * createTime : 2020-10-22T01:18:30.000+00:00
             * customerId : c398c9ba5eb7e189bdd4c215132d8276
             * repairTypeId : 2a46dd776db4ed9f9eaed339cc9f741a
             * repairTypeName : 墙面类
             * spaceId : null
             * spaceNo : null
             * customerPhone : 15738531698
             * reserveTime : null
             * notes : 事实上地址
             * updatetime : null
             * floor : null
             * customerName : 这是我的名字
             * content : 这是我的问题描述
             * status : 0
             * originType : 1
             */

            private String repairId;
            private String createTime;
            private String customerId;
            private String repairTypeId;
            private String repairTypeName;
            private String spaceId;
            private String spaceNo;
            private String customerPhone;
            private String reserveTime;
            private String notes;
            private String updatetime;
            private String floor;
            private String customerName;
            private String content;
            private String status;
            private String originType;

            public String getRepairId() {
                return repairId;
            }

            public void setRepairId(String repairId) {
                this.repairId = repairId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getRepairTypeId() {
                return repairTypeId;
            }

            public void setRepairTypeId(String repairTypeId) {
                this.repairTypeId = repairTypeId;
            }

            public String getRepairTypeName() {
                return repairTypeName;
            }

            public void setRepairTypeName(String repairTypeName) {
                this.repairTypeName = repairTypeName;
            }

            public String getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(String spaceId) {
                this.spaceId = spaceId;
            }

            public String getSpaceNo() {
                return spaceNo;
            }

            public void setSpaceNo(String spaceNo) {
                this.spaceNo = spaceNo;
            }

            public String getCustomerPhone() {
                return customerPhone;
            }

            public void setCustomerPhone(String customerPhone) {
                this.customerPhone = customerPhone;
            }

            public String getReserveTime() {
                return reserveTime;
            }

            public void setReserveTime(String reserveTime) {
                this.reserveTime = reserveTime;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getOriginType() {
                return originType;
            }

            public void setOriginType(String originType) {
                this.originType = originType;
            }
        }
    }
}
