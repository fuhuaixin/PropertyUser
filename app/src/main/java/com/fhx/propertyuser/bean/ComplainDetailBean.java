package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class ComplainDetailBean extends BaseBean {


    /**
     * success : true
     * data : {"orderDetails":[],"evaluteInfo":{"evaluteId":"e48e74fa37db7831f28f590ad4375460","createTime":"2020-12-15 15:32:00","originId":"d84aeaf388ba475a7809b6ecffdfcbf5","originType":"1","rateScore":5,"customerId":"d52e58e375d5146b1271de9bd93fd306","content":"我的意见"},"self":{"complainId":"d84aeaf388ba475a7809b6ecffdfcbf5","customerId":"d52e58e375d5146b1271de9bd93fd306","complaintTypeId":"26ac0be521e2191d4c2f8911cad8517a","complaintTypeName":null,"spaceId":null,"spaceNo":"4","customerPhone":"4","createTime":"2020-12-15 14:25:02","content":"4","hopeResult":"4","hopeTime":"2020-12-16 00:00:00","notes":null,"updateTime":"2020-12-15 15:31:57","happenTime":"2020-12-16 00:00:00","status":"5","processId":"307501","imgs":null,"urgeTimes":0},"order":{"workOrderId":"0e0d5fa1dfa828f7d6586412cfbc9908","workOrderType":"1","relationId":"d84aeaf388ba475a7809b6ecffdfcbf5","orderStatus":"4","creator":null,"createTime":"2020-12-15 14:25:02","priority":null,"executor":"f7e725ffbe9d96f452327e7fc5910915","notes":null,"endTime":null,"floor":null,"updateTime":"2020-12-15 15:01:13","relationTableName":"t_complaint","contactNum":null,"processId":"307501"}}
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
         * evaluteInfo : {"evaluteId":"e48e74fa37db7831f28f590ad4375460","createTime":"2020-12-15 15:32:00","originId":"d84aeaf388ba475a7809b6ecffdfcbf5","originType":"1","rateScore":5,"customerId":"d52e58e375d5146b1271de9bd93fd306","content":"我的意见"}
         * self : {"complainId":"d84aeaf388ba475a7809b6ecffdfcbf5","customerId":"d52e58e375d5146b1271de9bd93fd306","complaintTypeId":"26ac0be521e2191d4c2f8911cad8517a","complaintTypeName":null,"spaceId":null,"spaceNo":"4","customerPhone":"4","createTime":"2020-12-15 14:25:02","content":"4","hopeResult":"4","hopeTime":"2020-12-16 00:00:00","notes":null,"updateTime":"2020-12-15 15:31:57","happenTime":"2020-12-16 00:00:00","status":"5","processId":"307501","imgs":null,"urgeTimes":0}
         * order : {"workOrderId":"0e0d5fa1dfa828f7d6586412cfbc9908","workOrderType":"1","relationId":"d84aeaf388ba475a7809b6ecffdfcbf5","orderStatus":"4","creator":null,"createTime":"2020-12-15 14:25:02","priority":null,"executor":"f7e725ffbe9d96f452327e7fc5910915","notes":null,"endTime":null,"floor":null,"updateTime":"2020-12-15 15:01:13","relationTableName":"t_complaint","contactNum":null,"processId":"307501"}
         */

        private EvaluteInfoBean evaluteInfo;
        private SelfBean self;
        private OrderBean order;
        private List<?> orderDetails;

        public EvaluteInfoBean getEvaluteInfo() {
            return evaluteInfo;
        }

        public void setEvaluteInfo(EvaluteInfoBean evaluteInfo) {
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

        public static class EvaluteInfoBean {
            /**
             * evaluteId : e48e74fa37db7831f28f590ad4375460
             * createTime : 2020-12-15 15:32:00
             * originId : d84aeaf388ba475a7809b6ecffdfcbf5
             * originType : 1
             * rateScore : 5.0
             * customerId : d52e58e375d5146b1271de9bd93fd306
             * content : 我的意见
             */

            private String evaluteId;
            private String createTime;
            private String originId;
            private String originType;
            private double rateScore;
            private String customerId;
            private String content;

            public String getEvaluteId() {
                return evaluteId;
            }

            public void setEvaluteId(String evaluteId) {
                this.evaluteId = evaluteId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getOriginId() {
                return originId;
            }

            public void setOriginId(String originId) {
                this.originId = originId;
            }

            public String getOriginType() {
                return originType;
            }

            public void setOriginType(String originType) {
                this.originType = originType;
            }

            public double getRateScore() {
                return rateScore;
            }

            public void setRateScore(double rateScore) {
                this.rateScore = rateScore;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class SelfBean {
            /**
             * complainId : d84aeaf388ba475a7809b6ecffdfcbf5
             * customerId : d52e58e375d5146b1271de9bd93fd306
             * complaintTypeId : 26ac0be521e2191d4c2f8911cad8517a
             * complaintTypeName : null
             * spaceId : null
             * spaceNo : 4
             * customerPhone : 4
             * createTime : 2020-12-15 14:25:02
             * content : 4
             * hopeResult : 4
             * hopeTime : 2020-12-16 00:00:00
             * notes : null
             * updateTime : 2020-12-15 15:31:57
             * happenTime : 2020-12-16 00:00:00
             * status : 5
             * processId : 307501
             * imgs : null
             * urgeTimes : 0
             */

            private String complainId;
            private String customerId;
            private String complaintTypeId;
            private String complaintTypeName;
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
            private String processId;
            private String imgs;
            private int urgeTimes;

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

            public String getComplaintTypeName() {
                return complaintTypeName;
            }

            public void setComplaintTypeName(String complaintTypeName) {
                this.complaintTypeName = complaintTypeName;
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

            public String getProcessId() {
                return processId;
            }

            public void setProcessId(String processId) {
                this.processId = processId;
            }

            public String getImgs() {
                return imgs;
            }

            public void setImgs(String imgs) {
                this.imgs = imgs;
            }

            public int getUrgeTimes() {
                return urgeTimes;
            }

            public void setUrgeTimes(int urgeTimes) {
                this.urgeTimes = urgeTimes;
            }
        }

        public static class OrderBean {
            /**
             * workOrderId : 0e0d5fa1dfa828f7d6586412cfbc9908
             * workOrderType : 1
             * relationId : d84aeaf388ba475a7809b6ecffdfcbf5
             * orderStatus : 4
             * creator : null
             * createTime : 2020-12-15 14:25:02
             * priority : null
             * executor : f7e725ffbe9d96f452327e7fc5910915
             * notes : null
             * endTime : null
             * floor : null
             * updateTime : 2020-12-15 15:01:13
             * relationTableName : t_complaint
             * contactNum : null
             * processId : 307501
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
            private String processId;

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

            public String getProcessId() {
                return processId;
            }

            public void setProcessId(String processId) {
                this.processId = processId;
            }
        }
    }
}
