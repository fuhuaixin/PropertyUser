package com.fhx.propertyuser.bean;

import java.util.List;

public class ComplainTypeBean  {

    /**
     * success : true
     * data : {"records":[{"complaintTypeId":"0de3ca516a4ab97074bc19c91c143135","complaintTypeName":"公共空间","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"2193a1a45f15527e43510f5f9c1eaaef","complaintTypeName":"物业管理","parentId":"edcb203bc9e1bf5ea14789565e44a3a6","parentName":"物业投诉"},{"complaintTypeId":"26ac0be521e2191d4c2f8911cad8517a","complaintTypeName":"其他","parentId":"edcb203bc9e1bf5ea14789565e44a3a6","parentName":"物业投诉"},{"complaintTypeId":"2a5a3a994c8dbaf81d324024f2b1eea9","complaintTypeName":"添加测试2","parentId":"2d996dc2998165c4c451d3fc9707e9d7","parentName":"添加1测试"},{"complaintTypeId":"2bf1adabb5c5925a00a5daac07d951fc","complaintTypeName":"公共场地","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"2d996dc2998165c4c451d3fc9707e9d7","complaintTypeName":"添加1测试","parentId":"","parentName":null},{"complaintTypeId":"36aa16b6c11f5ab8035d711e4a21eeef","complaintTypeName":"设备设施","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"4b2982f50c664f38c2549ac5c6063ee2","complaintTypeName":"物业服务","parentId":"edcb203bc9e1bf5ea14789565e44a3a6","parentName":"物业投诉"},{"complaintTypeId":"541dc9cf220487c73854f001c0794b02","complaintTypeName":"房屋质量","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","complaintTypeName":"公共投诉","parentId":"","parentName":null}],"total":15,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":2}
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
         * records : [{"complaintTypeId":"0de3ca516a4ab97074bc19c91c143135","complaintTypeName":"公共空间","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"2193a1a45f15527e43510f5f9c1eaaef","complaintTypeName":"物业管理","parentId":"edcb203bc9e1bf5ea14789565e44a3a6","parentName":"物业投诉"},{"complaintTypeId":"26ac0be521e2191d4c2f8911cad8517a","complaintTypeName":"其他","parentId":"edcb203bc9e1bf5ea14789565e44a3a6","parentName":"物业投诉"},{"complaintTypeId":"2a5a3a994c8dbaf81d324024f2b1eea9","complaintTypeName":"添加测试2","parentId":"2d996dc2998165c4c451d3fc9707e9d7","parentName":"添加1测试"},{"complaintTypeId":"2bf1adabb5c5925a00a5daac07d951fc","complaintTypeName":"公共场地","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"2d996dc2998165c4c451d3fc9707e9d7","complaintTypeName":"添加1测试","parentId":"","parentName":null},{"complaintTypeId":"36aa16b6c11f5ab8035d711e4a21eeef","complaintTypeName":"设备设施","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"4b2982f50c664f38c2549ac5c6063ee2","complaintTypeName":"物业服务","parentId":"edcb203bc9e1bf5ea14789565e44a3a6","parentName":"物业投诉"},{"complaintTypeId":"541dc9cf220487c73854f001c0794b02","complaintTypeName":"房屋质量","parentId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","parentName":"公共投诉"},{"complaintTypeId":"63812e99ad1e1bb1fb2d7e6b77eb9e4b","complaintTypeName":"公共投诉","parentId":"","parentName":null}]
         * total : 15
         * size : 10
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 2
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
             * complaintTypeId : 0de3ca516a4ab97074bc19c91c143135
             * complaintTypeName : 公共空间
             * parentId : 63812e99ad1e1bb1fb2d7e6b77eb9e4b
             * parentName : 公共投诉
             */

            private String complaintTypeId;
            private String complaintTypeName;
            private String parentId;
            private String parentName;

            public String getComplaintTypeId() {
                return complaintTypeId;
            }

            public void setComplaintTypeId(String complaintTypeId) {
                this.complaintTypeId = complaintTypeId;
            }

            public String getComplaintTypeName() {
                return complaintTypeName;
            }

            public void setComplaintTypeName(String complaintTypeName) {
                this.complaintTypeName = complaintTypeName;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getParentName() {
                return parentName;
            }

            public void setParentName(String parentName) {
                this.parentName = parentName;
            }
        }
    }
}
