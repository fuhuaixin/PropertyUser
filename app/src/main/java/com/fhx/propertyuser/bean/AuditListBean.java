package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class AuditListBean extends BaseBean {

    /**
     * success : true
     * data : {"records":[{"auditId":"a6a82fd061d6ebb1c45f343cc7b75de6","name":"我","sex":"0","phone":"15738531698","floor":"2","roomNo":"205","type":"2","submitTime":"2020-11-12 15:39:24","auditTime":null,"result":null,"auditorId":null,"reason":null,"notes":null}],"total":1,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"auditId":"a6a82fd061d6ebb1c45f343cc7b75de6","name":"我","sex":"0","phone":"15738531698","floor":"2","roomNo":"205","type":"2","submitTime":"2020-11-12 15:39:24","auditTime":null,"result":null,"auditorId":null,"reason":null,"notes":null}]
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
             * auditId : a6a82fd061d6ebb1c45f343cc7b75de6
             * name : 我
             * sex : 0
             * phone : 15738531698
             * floor : 2
             * roomNo : 205
             * type : 2
             * submitTime : 2020-11-12 15:39:24
             * auditTime : null
             * result : null
             * auditorId : null
             * reason : null
             * notes : null
             */

            private String auditId;
            private String name;
            private String sex;
            private String phone;
            private String floor;
            private String roomNo;
            private String type;
            private String submitTime;
            private String auditTime;
            private String result;
            private String auditorId;
            private String reason;
            private String notes;

            public String getAuditId() {
                return auditId;
            }

            public void setAuditId(String auditId) {
                this.auditId = auditId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getRoomNo() {
                return roomNo;
            }

            public void setRoomNo(String roomNo) {
                this.roomNo = roomNo;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSubmitTime() {
                return submitTime;
            }

            public void setSubmitTime(String submitTime) {
                this.submitTime = submitTime;
            }

            public String getAuditTime() {
                return auditTime;
            }

            public void setAuditTime(String auditTime) {
                this.auditTime = auditTime;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public String getAuditorId() {
                return auditorId;
            }

            public void setAuditorId(String auditorId) {
                this.auditorId = auditorId;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }
        }
    }
}
