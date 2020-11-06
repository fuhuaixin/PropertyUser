package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class ComplainDetailBean extends BaseBean {


    /**
     * success : true
     * data : {"orderDetails":[],"evaluteInfo":null,"self":{"complainId":"35dd8845b70cefe46c14c70bbe76680a","customerId":"c398c9ba5eb7e189bdd4c215132d8276","complaintTypeId":null,"complainTypeName":null,"spaceId":null,"spaceNo":"202","customerPhone":"15738536995","createTime":"2020-11-05T06:10:13.000+00:00","content":"这是我的投诉没有声音","hopeResult":"我抑郁昂我想一","hopeTime":"2020-11-06T16:00:00.000+00:00","notes":null,"updateTime":null,"happenTime":"2020-11-03T16:00:00.000+00:00","status":"0"},"order":{"workOrderId":"cc05914c9e992681b48e15461a96d657","workOrderType":"1","relationId":"35dd8845b70cefe46c14c70bbe76680a","orderStatus":"0","creator":null,"createTime":"2020-11-05 14:10:13","priority":null,"executor":null,"notes":null,"endTime":null,"floor":null,"updateTime":null,"relationTableName":"t_complaint","contactNum":null}}
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
         * self : {"complainId":"35dd8845b70cefe46c14c70bbe76680a","customerId":"c398c9ba5eb7e189bdd4c215132d8276","complaintTypeId":null,"complainTypeName":null,"spaceId":null,"spaceNo":"202","customerPhone":"15738536995","createTime":"2020-11-05T06:10:13.000+00:00","content":"这是我的投诉没有声音","hopeResult":"我抑郁昂我想一","hopeTime":"2020-11-06T16:00:00.000+00:00","notes":null,"updateTime":null,"happenTime":"2020-11-03T16:00:00.000+00:00","status":"0"}
         * order : {"workOrderId":"cc05914c9e992681b48e15461a96d657","workOrderType":"1","relationId":"35dd8845b70cefe46c14c70bbe76680a","orderStatus":"0","creator":null,"createTime":"2020-11-05 14:10:13","priority":null,"executor":null,"notes":null,"endTime":null,"floor":null,"updateTime":null,"relationTableName":"t_complaint","contactNum":null}
         */

        private String evaluteInfo;
        private SelfBean self;
        private OrderBean order;
        private List<?> orderDetails;

        public String getEvaluteInfo() {
            return evaluteInfo;
        }

        public void setEvaluteInfo(String evaluteInfo) {
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
             * complainId : 35dd8845b70cefe46c14c70bbe76680a
             * customerId : c398c9ba5eb7e189bdd4c215132d8276
             * complaintTypeId : null
             * complainTypeName : null
             * spaceId : null
             * spaceNo : 202
             * customerPhone : 15738536995
             * createTime : 2020-11-05T06:10:13.000+00:00
             * content : 这是我的投诉没有声音
             * hopeResult : 我抑郁昂我想一
             * hopeTime : 2020-11-06T16:00:00.000+00:00
             * notes : null
             * updateTime : null
             * happenTime : 2020-11-03T16:00:00.000+00:00
             * status : 0
             */

            private String complainId;
            private String customerId;
            private String  complaintTypeId;
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

            public String getHopeResult() {
                return hopeResult;
            }

            public void setHopeResult(String hopeResult) {
                this.hopeResult = hopeResult;
            }

            public String getHopeTime() {
                return hopeTime;
            }

            public void setHopeTime(String hopeTime) {
                this.hopeTime = hopeTime;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getHappenTime() {
                return happenTime;
            }

            public void setHappenTime(String happenTime) {
                this.happenTime = happenTime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }

        public static class OrderBean {
            /**
             * workOrderId : cc05914c9e992681b48e15461a96d657
             * workOrderType : 1
             * relationId : 35dd8845b70cefe46c14c70bbe76680a
             * orderStatus : 0
             * creator : null
             * createTime : 2020-11-05 14:10:13
             * priority : null
             * executor : null
             * notes : null
             * endTime : null
             * floor : null
             * updateTime : null
             * relationTableName : t_complaint
             * contactNum : null
             */

            private String workOrderId;
            private String workOrderType;
            private String relationId;
            private String orderStatus;
            private String creator;
            private String createTime;
            private String priority;
            private String executor;
            private String notes;
            private String endTime;
            private String floor;
            private String updateTime;
            private String relationTableName;
            private String contactNum;

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

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getPriority() {
                return priority;
            }

            public void setPriority(String priority) {
                this.priority = priority;
            }

            public String getExecutor() {
                return executor;
            }

            public void setExecutor(String executor) {
                this.executor = executor;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getRelationTableName() {
                return relationTableName;
            }

            public void setRelationTableName(String relationTableName) {
                this.relationTableName = relationTableName;
            }

            public String getContactNum() {
                return contactNum;
            }

            public void setContactNum(String contactNum) {
                this.contactNum = contactNum;
            }
        }
    }
}
