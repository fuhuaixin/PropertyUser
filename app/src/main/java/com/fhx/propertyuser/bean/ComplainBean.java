package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class ComplainBean extends BaseBean {


    /**
     * success : true
     * data : {"records":[{"complainId":"b48b9c3eff4b18334a074b382765b955","customerId":"c398c9ba5eb7e189bdd4c215132d8276","complaintTypeId":"2193a1a45f15527e43510f5f9c1eaaef","complainTypeName":"物业管理","spaceId":null,"spaceNo":null,"customerPhone":null,"createTime":"2020-10-22T07:01:36.000+00:00","content":"这是我的投诉内容","hopeResult":null,"hopeTime":null,"notes":null,"updateTime":null,"happenTime":null,"status":"0"},{"complainId":"d6cf37310512aa455f01e0a070bc4b31","customerId":"c398c9ba5eb7e189bdd4c215132d8276","complaintTypeId":"2193a1a45f15527e43510f5f9c1eaaef","complainTypeName":"物业管理","spaceId":null,"spaceNo":"101","customerPhone":"15738531698","createTime":"2020-10-22T07:01:29.000+00:00","content":"我的投诉","hopeResult":"希望处理结果","hopeTime":"2020-10-23T16:00:00.000+00:00","notes":null,"updateTime":null,"happenTime":"2020-10-22T16:00:00.000+00:00","status":"0"}],"total":2,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"complainId":"b48b9c3eff4b18334a074b382765b955","customerId":"c398c9ba5eb7e189bdd4c215132d8276","complaintTypeId":"2193a1a45f15527e43510f5f9c1eaaef","complainTypeName":"物业管理","spaceId":null,"spaceNo":null,"customerPhone":null,"createTime":"2020-10-22T07:01:36.000+00:00","content":"这是我的投诉内容","hopeResult":null,"hopeTime":null,"notes":null,"updateTime":null,"happenTime":null,"status":"0"},{"complainId":"d6cf37310512aa455f01e0a070bc4b31","customerId":"c398c9ba5eb7e189bdd4c215132d8276","complaintTypeId":"2193a1a45f15527e43510f5f9c1eaaef","complainTypeName":"物业管理","spaceId":null,"spaceNo":"101","customerPhone":"15738531698","createTime":"2020-10-22T07:01:29.000+00:00","content":"我的投诉","hopeResult":"希望处理结果","hopeTime":"2020-10-23T16:00:00.000+00:00","notes":null,"updateTime":null,"happenTime":"2020-10-22T16:00:00.000+00:00","status":"0"}]
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
        private String  countId;
        private String  maxLimit;
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

        public String  getCountId() {
            return countId;
        }

        public void setCountId(String  countId) {
            this.countId = countId;
        }

        public String  getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(String  maxLimit) {
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
             * complainId : b48b9c3eff4b18334a074b382765b955
             * customerId : c398c9ba5eb7e189bdd4c215132d8276
             * complaintTypeId : 2193a1a45f15527e43510f5f9c1eaaef
             * complainTypeName : 物业管理
             * spaceId : null
             * spaceNo : null
             * customerPhone : null
             * createTime : 2020-10-22T07:01:36.000+00:00
             * content : 这是我的投诉内容
             * hopeResult : null
             * hopeTime : null
             * notes : null
             * updateTime : null
             * happenTime : null
             * status : 0
             */

            private String complainId;
            private String customerId;
            private String complaintTypeId;
            private String complainTypeName;
            private String spaceId;
            private String spaceNo;
            private String customerPhone;
            private String createTime;
            private String content;
            private String hopeResult;
            private String hopeTime;
            private String notes;
            private String updateTime;
            private String happenTime;
            private String status;

            public String getComplainId() {
                return complainId;
            }

            public void setComplainId(String complainId) {
                this.complainId = complainId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getComplaintTypeId() {
                return complaintTypeId;
            }

            public void setComplaintTypeId(String complaintTypeId) {
                this.complaintTypeId = complaintTypeId;
            }

            public String getComplainTypeName() {
                return complainTypeName;
            }

            public void setComplainTypeName(String complainTypeName) {
                this.complainTypeName = complainTypeName;
            }

            public String  getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(String  spaceId) {
                this.spaceId = spaceId;
            }

            public String  getSpaceNo() {
                return spaceNo;
            }

            public void setSpaceNo(String  spaceNo) {
                this.spaceNo = spaceNo;
            }

            public String  getCustomerPhone() {
                return customerPhone;
            }

            public void setCustomerPhone(String  customerPhone) {
                this.customerPhone = customerPhone;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String  getHopeResult() {
                return hopeResult;
            }

            public void setHopeResult(String  hopeResult) {
                this.hopeResult = hopeResult;
            }

            public String  getHopeTime() {
                return hopeTime;
            }

            public void setHopeTime(String  hopeTime) {
                this.hopeTime = hopeTime;
            }

            public String  getNotes() {
                return notes;
            }

            public void setNotes(String  notes) {
                this.notes = notes;
            }

            public String  getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String  updateTime) {
                this.updateTime = updateTime;
            }

            public String  getHappenTime() {
                return happenTime;
            }

            public void setHappenTime(String  happenTime) {
                this.happenTime = happenTime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
