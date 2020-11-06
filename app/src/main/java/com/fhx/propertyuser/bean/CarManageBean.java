package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class CarManageBean extends BaseBean {


    /**
     * success : true
     * data : {"records":[{"carId":"34322dd5fb7335a0095d056e909cfb6e","carNo":"豫A88887","customerId":"c398c9ba5eb7e189bdd4c215132d8276","carOwner":"尤克里里","ownerPhone":"15785208520","parkingNo":"","isBaned":"0","carType":"1","updateTime":null,"createTime":"2020-11-06 11:35:09","isDeleted":"0"},{"carId":"9f83458f4e0228714fd234bd59b72104","carNo":"豫A88888","customerId":"c398c9ba5eb7e189bdd4c215132d8276","carOwner":"我","ownerPhone":"15738521563","parkingNo":null,"isBaned":"0","carType":"1","updateTime":null,"createTime":"2020-11-06 11:25:02","isDeleted":"0"}],"total":2,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"carId":"34322dd5fb7335a0095d056e909cfb6e","carNo":"豫A88887","customerId":"c398c9ba5eb7e189bdd4c215132d8276","carOwner":"尤克里里","ownerPhone":"15785208520","parkingNo":"","isBaned":"0","carType":"1","updateTime":null,"createTime":"2020-11-06 11:35:09","isDeleted":"0"},{"carId":"9f83458f4e0228714fd234bd59b72104","carNo":"豫A88888","customerId":"c398c9ba5eb7e189bdd4c215132d8276","carOwner":"我","ownerPhone":"15738521563","parkingNo":null,"isBaned":"0","carType":"1","updateTime":null,"createTime":"2020-11-06 11:25:02","isDeleted":"0"}]
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
             * carId : 34322dd5fb7335a0095d056e909cfb6e
             * carNo : 豫A88887
             * customerId : c398c9ba5eb7e189bdd4c215132d8276
             * carOwner : 尤克里里
             * ownerPhone : 15785208520
             * parkingNo :
             * isBaned : 0
             * carType : 1
             * updateTime : null
             * createTime : 2020-11-06 11:35:09
             * isDeleted : 0
             */

            private String carId;
            private String carNo;
            private String customerId;
            private String carOwner;
            private String ownerPhone;
            private String parkingNo;
            private String isBaned;
            private String carType;
            private Object updateTime;
            private String createTime;
            private String isDeleted;

            public String getCarId() {
                return carId;
            }

            public void setCarId(String carId) {
                this.carId = carId;
            }

            public String getCarNo() {
                return carNo;
            }

            public void setCarNo(String carNo) {
                this.carNo = carNo;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getCarOwner() {
                return carOwner;
            }

            public void setCarOwner(String carOwner) {
                this.carOwner = carOwner;
            }

            public String getOwnerPhone() {
                return ownerPhone;
            }

            public void setOwnerPhone(String ownerPhone) {
                this.ownerPhone = ownerPhone;
            }

            public String getParkingNo() {
                return parkingNo;
            }

            public void setParkingNo(String parkingNo) {
                this.parkingNo = parkingNo;
            }

            public String getIsBaned() {
                return isBaned;
            }

            public void setIsBaned(String isBaned) {
                this.isBaned = isBaned;
            }

            public String getCarType() {
                return carType;
            }

            public void setCarType(String carType) {
                this.carType = carType;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getIsDeleted() {
                return isDeleted;
            }

            public void setIsDeleted(String isDeleted) {
                this.isDeleted = isDeleted;
            }
        }
    }
}
