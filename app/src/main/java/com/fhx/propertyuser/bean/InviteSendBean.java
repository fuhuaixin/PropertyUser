package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class InviteSendBean extends BaseBean {


    /**
     * success : true
     * data : {"records":[{"inviteId":"8bb9fafafb560627698c44ea5ee1e342","promoter":"15738531698","guestName":"什么","guestPhone":"15808520852","comeDay":"2020-11-18","leaveDay":null,"room":"250","origin":"洽谈","isAccept":"0","visitTime":null,"createtime":"2020-11-16 09:47:26","updatetime":null},{"inviteId":"8d4725b38470dc5a53a9dfc8d81aec73","promoter":"15738531698","guestName":"1","guestPhone":"15738526985","comeDay":"2020-11-18","leaveDay":null,"room":"205","origin":"洽谈","isAccept":"0","visitTime":null,"createtime":"2020-11-16 09:43:07","updatetime":null},{"inviteId":"e986cb81baa7ba32bc6ea380a37a1dac","promoter":"15738531698","guestName":"好打卡机","guestPhone":"15808852580","comeDay":"2020-11-20","leaveDay":null,"room":"850","origin":"洽谈","isAccept":"0","visitTime":null,"createtime":"2020-11-16 09:41:42","updatetime":null}],"total":3,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"inviteId":"8bb9fafafb560627698c44ea5ee1e342","promoter":"15738531698","guestName":"什么","guestPhone":"15808520852","comeDay":"2020-11-18","leaveDay":null,"room":"250","origin":"洽谈","isAccept":"0","visitTime":null,"createtime":"2020-11-16 09:47:26","updatetime":null},{"inviteId":"8d4725b38470dc5a53a9dfc8d81aec73","promoter":"15738531698","guestName":"1","guestPhone":"15738526985","comeDay":"2020-11-18","leaveDay":null,"room":"205","origin":"洽谈","isAccept":"0","visitTime":null,"createtime":"2020-11-16 09:43:07","updatetime":null},{"inviteId":"e986cb81baa7ba32bc6ea380a37a1dac","promoter":"15738531698","guestName":"好打卡机","guestPhone":"15808852580","comeDay":"2020-11-20","leaveDay":null,"room":"850","origin":"洽谈","isAccept":"0","visitTime":null,"createtime":"2020-11-16 09:41:42","updatetime":null}]
         * total : 3
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
             * inviteId : 8bb9fafafb560627698c44ea5ee1e342
             * promoter : 15738531698
             * guestName : 什么
             * guestPhone : 15808520852
             * comeDay : 2020-11-18
             * leaveDay : null
             * room : 250
             * origin : 洽谈
             * isAccept : 0
             * visitTime : null
             * createtime : 2020-11-16 09:47:26
             * updatetime : null
             */

            private String inviteId;
            private String promoter;
            private String guestName;
            private String guestPhone;
            private String comeDay;
            private Object leaveDay;
            private String room;
            private String origin;
            private String isAccept;
            private Object visitTime;
            private String createtime;
            private Object updatetime;

            public String getInviteId() {
                return inviteId;
            }

            public void setInviteId(String inviteId) {
                this.inviteId = inviteId;
            }

            public String getPromoter() {
                return promoter;
            }

            public void setPromoter(String promoter) {
                this.promoter = promoter;
            }

            public String getGuestName() {
                return guestName;
            }

            public void setGuestName(String guestName) {
                this.guestName = guestName;
            }

            public String getGuestPhone() {
                return guestPhone;
            }

            public void setGuestPhone(String guestPhone) {
                this.guestPhone = guestPhone;
            }

            public String getComeDay() {
                return comeDay;
            }

            public void setComeDay(String comeDay) {
                this.comeDay = comeDay;
            }

            public Object getLeaveDay() {
                return leaveDay;
            }

            public void setLeaveDay(Object leaveDay) {
                this.leaveDay = leaveDay;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getIsAccept() {
                return isAccept;
            }

            public void setIsAccept(String isAccept) {
                this.isAccept = isAccept;
            }

            public Object getVisitTime() {
                return visitTime;
            }

            public void setVisitTime(Object visitTime) {
                this.visitTime = visitTime;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public Object getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Object updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
