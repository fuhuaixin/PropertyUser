package com.fhx.propertyuser.bean;

import java.util.List;

public class RepairTypeListBean {

    /**
     * success : true
     * data : {"records":[{"repairTypeId":"05a8922d99024d7ddc879220089225dc","repairTypeName":"龙头洁具","parentId":"3b7feffe2ab355920b1525e3e993c365"},{"repairTypeId":"13068998b3ae1665478111a85d9b40f5","repairTypeName":"门窗类","parentId":"77afe6521f591ff1be75b89e75a184b1"},{"repairTypeId":"20d91870ecc7d2fd758cc4b30add92b8","repairTypeName":"路面类","parentId":"b9cd922d53c3cd81ba7566fadf7c4e4a"},{"repairTypeId":"2a46dd776db4ed9f9eaed339cc9f741a","repairTypeName":"墙面类","parentId":"b9cd922d53c3cd81ba7566fadf7c4e4a"},{"repairTypeId":"3593f9ac9ddbe5fc8e1ac5605ed58191","repairTypeName":"其他","parentId":""},{"repairTypeId":"35c70fde99d49d7e634fa044cfdf87a0","repairTypeName":"电","parentId":""},{"repairTypeId":"3b51bb0bf60d725645fc82ed9d2f9c39","repairTypeName":"报事","parentId":"3593f9ac9ddbe5fc8e1ac5605ed58191"},{"repairTypeId":"3b7feffe2ab355920b1525e3e993c365","repairTypeName":"水","parentId":""},{"repairTypeId":"6b79d2b3c81b3a7a97c7475641b9d5d3","repairTypeName":"线路","parentId":"35c70fde99d49d7e634fa044cfdf87a0"},{"repairTypeId":"72d0d3cd9624c7755be2637f154f04ff","repairTypeName":"壁柜类","parentId":"77afe6521f591ff1be75b89e75a184b1"},{"repairTypeId":"745b1a7f6288a6812d341c10cfde57f5","repairTypeName":"家具类","parentId":"cb37fe048199f4f03b45250f84c43f9b"},{"repairTypeId":"77afe6521f591ff1be75b89e75a184b1","repairTypeName":"木","parentId":""},{"repairTypeId":"818b72d445803924d7dac4b0cc5d0b4f","repairTypeName":"墙面类","parentId":"cb37fe048199f4f03b45250f84c43f9b"},{"repairTypeId":"821eccd2e48450bdf0d018d7e8a7c249","repairTypeName":"求助","parentId":"3593f9ac9ddbe5fc8e1ac5605ed58191"},{"repairTypeId":"b9761bc0709447fca7c39180ee12c593","repairTypeName":"灯具","parentId":"35c70fde99d49d7e634fa044cfdf87a0"},{"repairTypeId":"b9cd922d53c3cd81ba7566fadf7c4e4a","repairTypeName":"泥","parentId":""},{"repairTypeId":"c9d72ce6492913826443899ddb4b1c3d","repairTypeName":"水暖管道","parentId":"3b7feffe2ab355920b1525e3e993c365"},{"repairTypeId":"cb37fe048199f4f03b45250f84c43f9b","repairTypeName":"漆","parentId":""},{"repairTypeId":"fd45b86383a813d4077db15df9d2543f","repairTypeName":"下水道","parentId":"3b7feffe2ab355920b1525e3e993c365"}],"total":19,"size":100,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"repairTypeId":"05a8922d99024d7ddc879220089225dc","repairTypeName":"龙头洁具","parentId":"3b7feffe2ab355920b1525e3e993c365"},{"repairTypeId":"13068998b3ae1665478111a85d9b40f5","repairTypeName":"门窗类","parentId":"77afe6521f591ff1be75b89e75a184b1"},{"repairTypeId":"20d91870ecc7d2fd758cc4b30add92b8","repairTypeName":"路面类","parentId":"b9cd922d53c3cd81ba7566fadf7c4e4a"},{"repairTypeId":"2a46dd776db4ed9f9eaed339cc9f741a","repairTypeName":"墙面类","parentId":"b9cd922d53c3cd81ba7566fadf7c4e4a"},{"repairTypeId":"3593f9ac9ddbe5fc8e1ac5605ed58191","repairTypeName":"其他","parentId":""},{"repairTypeId":"35c70fde99d49d7e634fa044cfdf87a0","repairTypeName":"电","parentId":""},{"repairTypeId":"3b51bb0bf60d725645fc82ed9d2f9c39","repairTypeName":"报事","parentId":"3593f9ac9ddbe5fc8e1ac5605ed58191"},{"repairTypeId":"3b7feffe2ab355920b1525e3e993c365","repairTypeName":"水","parentId":""},{"repairTypeId":"6b79d2b3c81b3a7a97c7475641b9d5d3","repairTypeName":"线路","parentId":"35c70fde99d49d7e634fa044cfdf87a0"},{"repairTypeId":"72d0d3cd9624c7755be2637f154f04ff","repairTypeName":"壁柜类","parentId":"77afe6521f591ff1be75b89e75a184b1"},{"repairTypeId":"745b1a7f6288a6812d341c10cfde57f5","repairTypeName":"家具类","parentId":"cb37fe048199f4f03b45250f84c43f9b"},{"repairTypeId":"77afe6521f591ff1be75b89e75a184b1","repairTypeName":"木","parentId":""},{"repairTypeId":"818b72d445803924d7dac4b0cc5d0b4f","repairTypeName":"墙面类","parentId":"cb37fe048199f4f03b45250f84c43f9b"},{"repairTypeId":"821eccd2e48450bdf0d018d7e8a7c249","repairTypeName":"求助","parentId":"3593f9ac9ddbe5fc8e1ac5605ed58191"},{"repairTypeId":"b9761bc0709447fca7c39180ee12c593","repairTypeName":"灯具","parentId":"35c70fde99d49d7e634fa044cfdf87a0"},{"repairTypeId":"b9cd922d53c3cd81ba7566fadf7c4e4a","repairTypeName":"泥","parentId":""},{"repairTypeId":"c9d72ce6492913826443899ddb4b1c3d","repairTypeName":"水暖管道","parentId":"3b7feffe2ab355920b1525e3e993c365"},{"repairTypeId":"cb37fe048199f4f03b45250f84c43f9b","repairTypeName":"漆","parentId":""},{"repairTypeId":"fd45b86383a813d4077db15df9d2543f","repairTypeName":"下水道","parentId":"3b7feffe2ab355920b1525e3e993c365"}]
         * total : 19
         * size : 100
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
             * repairTypeId : 05a8922d99024d7ddc879220089225dc
             * repairTypeName : 龙头洁具
             * parentId : 3b7feffe2ab355920b1525e3e993c365
             */

            private String repairTypeId;
            private String repairTypeName;
            private String parentId;

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

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }
        }
    }
}
