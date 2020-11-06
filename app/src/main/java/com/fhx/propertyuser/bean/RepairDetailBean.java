package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class RepairDetailBean extends BaseBean {

    /**
     * success : true
     * data : {"orderDetails":[],"evaluteInfo":null,"self":{"repairId":"841a5a4b409636e8e6a5f1d0e0acf608","createTime":"2020-11-05T06:15:29.000+00:00","customerId":"c398c9ba5eb7e189bdd4c215132d8276","repairTypeId":"05a8922d99024d7ddc879220089225dc","repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":"15786465485","reserveTime":"2020-11-05T16:00:00.000+00:00","notes":"地址","updatetime":null,"floor":null,"customerName":"营养液","content":"哦新一中是我一共哦1魔攻倪敏去洗洗额敏苏我","status":"0","originType":"1"},"order":{"workOrderId":"5b1f3a4db1062043def38407c037f8ea","workOrderType":"1","relationId":"841a5a4b409636e8e6a5f1d0e0acf608","orderStatus":"0","creator":null,"createTime":"2020-11-05 14:15:29","priority":null,"executor":null,"notes":null,"endTime":null,"floor":null,"updateTime":null,"relationTableName":"t_repair","contactNum":null}}
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
         * orderDetails : []
         * evaluteInfo : null
         * self : {"repairId":"841a5a4b409636e8e6a5f1d0e0acf608","createTime":"2020-11-05T06:15:29.000+00:00","customerId":"c398c9ba5eb7e189bdd4c215132d8276","repairTypeId":"05a8922d99024d7ddc879220089225dc","repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":"15786465485","reserveTime":"2020-11-05T16:00:00.000+00:00","notes":"地址","updatetime":null,"floor":null,"customerName":"营养液","content":"哦新一中是我一共哦1魔攻倪敏去洗洗额敏苏我","status":"0","originType":"1"}
         * order : {"workOrderId":"5b1f3a4db1062043def38407c037f8ea","workOrderType":"1","relationId":"841a5a4b409636e8e6a5f1d0e0acf608","orderStatus":"0","creator":null,"createTime":"2020-11-05 14:15:29","priority":null,"executor":null,"notes":null,"endTime":null,"floor":null,"updateTime":null,"relationTableName":"t_repair","contactNum":null}
         */

        private Object evaluteInfo;
        private SelfBean self;
        private OrderBean order;
        private List<?> orderDetails;

        public Object getEvaluteInfo() {
            return evaluteInfo;
        }

        public void setEvaluteInfo(Object evaluteInfo) {
            this.evaluteInfo = evaluteInfo;
        }

        public SelfBean getSelf() {
            return self;
        }

        public void setSelf(SelfBean self) {
            this.self = self;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<?> getOrderDetails() {
            return orderDetails;
        }

        public void setOrderDetails(List<?> orderDetails) {
            this.orderDetails = orderDetails;
        }

        public static class SelfBean {
            /**
             * repairId : 841a5a4b409636e8e6a5f1d0e0acf608
             * createTime : 2020-11-05T06:15:29.000+00:00
             * customerId : c398c9ba5eb7e189bdd4c215132d8276
             * repairTypeId : 05a8922d99024d7ddc879220089225dc
             * repairTypeName : null
             * spaceId : null
             * spaceNo : null
             * customerPhone : 15786465485
             * reserveTime : 2020-11-05T16:00:00.000+00:00
             * notes : 地址
             * updatetime : null
             * floor : null
             * customerName : 营养液
             * content : 哦新一中是我一共哦1魔攻倪敏去洗洗额敏苏我
             * status : 0
             * originType : 1
             */

            private String repairId;
            private String createTime;
            private String customerId;
            private String repairTypeId;
            private Object repairTypeName;
            private Object spaceId;
            private Object spaceNo;
            private String customerPhone;
            private String reserveTime;
            private String notes;
            private Object updatetime;
            private Object floor;
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

            public Object getRepairTypeName() {
                return repairTypeName;
            }

            public void setRepairTypeName(Object repairTypeName) {
                this.repairTypeName = repairTypeName;
            }

            public Object getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(Object spaceId) {
                this.spaceId = spaceId;
            }

            public Object getSpaceNo() {
                return spaceNo;
            }

            public void setSpaceNo(Object spaceNo) {
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

            public Object getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Object updatetime) {
                this.updatetime = updatetime;
            }

            public Object getFloor() {
                return floor;
            }

            public void setFloor(Object floor) {
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

        public static class OrderBean {
            /**
             * workOrderId : 5b1f3a4db1062043def38407c037f8ea
             * workOrderType : 1
             * relationId : 841a5a4b409636e8e6a5f1d0e0acf608
             * orderStatus : 0
             * creator : null
             * createTime : 2020-11-05 14:15:29
             * priority : null
             * executor : null
             * notes : null
             * endTime : null
             * floor : null
             * updateTime : null
             * relationTableName : t_repair
             * contactNum : null
             */

            private String workOrderId;
            private String workOrderType;
            private String relationId;
            private String orderStatus;
            private Object creator;
            private String createTime;
            private Object priority;
            private Object executor;
            private Object notes;
            private Object endTime;
            private Object floor;
            private Object updateTime;
            private String relationTableName;
            private Object contactNum;

            public String getWorkOrderId() {
                return workOrderId;
            }

            public void setWorkOrderId(String workOrderId) {
                this.workOrderId = workOrderId;
            }

            public String getWorkOrderType() {
                return workOrderType;
            }

            public void setWorkOrderType(String workOrderType) {
                this.workOrderType = workOrderType;
            }

            public String getRelationId() {
                return relationId;
            }

            public void setRelationId(String relationId) {
                this.relationId = relationId;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public Object getCreator() {
                return creator;
            }

            public void setCreator(Object creator) {
                this.creator = creator;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getPriority() {
                return priority;
            }

            public void setPriority(Object priority) {
                this.priority = priority;
            }

            public Object getExecutor() {
                return executor;
            }

            public void setExecutor(Object executor) {
                this.executor = executor;
            }

            public Object getNotes() {
                return notes;
            }

            public void setNotes(Object notes) {
                this.notes = notes;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
            }

            public Object getFloor() {
                return floor;
            }

            public void setFloor(Object floor) {
                this.floor = floor;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getRelationTableName() {
                return relationTableName;
            }

            public void setRelationTableName(String relationTableName) {
                this.relationTableName = relationTableName;
            }

            public Object getContactNum() {
                return contactNum;
            }

            public void setContactNum(Object contactNum) {
                this.contactNum = contactNum;
            }
        }
    }
}
