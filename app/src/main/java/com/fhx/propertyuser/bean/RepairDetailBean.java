package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

import java.util.List;

public class RepairDetailBean extends BaseBean {


    /**
     * success : true
     * data : {"orderDetails":[{"empId":"56cfac326b91efeeacee30a46ddb3df2","phone":"15515554312","empName":"客户代表","taskName":"工单录入","startTime":"2020-12-08 15:21:28","empNo":"No-00001","endTime":"2020-12-08 15:21:28"},{"empId":"f7e725ffbe9d96f452327e7fc5910912","phone":"187371354","empName":"客服","taskName":"工单派发","startTime":"2020-12-08 15:21:28","empNo":"NO-0000044","endTime":"2020-12-08 15:23:28"},{"empId":"f7e725ffbe9d96f452327e7fc5910915","phone":"18737144555","empName":"部门员工","taskName":"工程师提交工单","startTime":"2020-12-08 15:23:28","empNo":"NO-0000047","endTime":"2020-12-08 16:30:01"},{"empId":"f7e725ffbe9d96f452327e7fc5910912","phone":"187371354","empName":"客服","taskName":"客服复核工单","startTime":"2020-12-08 16:30:01","empNo":"NO-0000044","endTime":null}],"evaluteInfo":null,"self":{"repairId":"9c6198c8f85ab9cff110661f81d55f0f","createTime":"2020-12-08 15:21:29","customerId":"d52e58e375d5146b1271de9bd93fd306","repairTypeId":"05a8922d99024d7ddc879220089225dc","repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":"111111","reserveTime":"2020-12-02 00:00:00","notes":"111","updatetime":"2020-12-08 16:30:00","floor":null,"customerName":"wo ","content":"这个处理中","status":"3","originType":"1","processId":"242501","imgs":null,"urgeTimes":0,"dealPerson":null},"dealPerson":{"employeeId":"f7e725ffbe9d96f452327e7fc5910915","employeeName":"部门员工","employeeNo":"NO-0000047","sex":"1","phone":"18737144555","phoneBackup":"16608831825","mail":"1621700974@qq.com","birthday":"1980-09-02","nation":"汉族","dutyName":"员工","deptId":"23f31ddf735875d51b7987fe34aac187","deptName":null,"address":null,"inDate":"2019-08-02 12:32:45","outDate":null,"status":"1","systemEnable":"1","notes":"这里是备注","createTime":null,"updateTime":"2020-11-03 16:32:08"},"order":{"workOrderId":"c89d61b3e40e02a99ef6f558a0228ffb","workOrderType":"0","relationId":"9c6198c8f85ab9cff110661f81d55f0f","orderStatus":"3","creator":null,"createTime":"2020-12-08 15:21:29","priority":null,"executor":"f7e725ffbe9d96f452327e7fc5910915","notes":null,"endTime":null,"floor":null,"updateTime":"2020-12-08 16:30:02","relationTableName":"t_repair","contactNum":null,"processId":"242501"}}
     */

    private boolean success;
    private DataBean data;
    private String  msg;

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
         * orderDetails : [{"empId":"56cfac326b91efeeacee30a46ddb3df2","phone":"15515554312","empName":"客户代表","taskName":"工单录入","startTime":"2020-12-08 15:21:28","empNo":"No-00001","endTime":"2020-12-08 15:21:28"},{"empId":"f7e725ffbe9d96f452327e7fc5910912","phone":"187371354","empName":"客服","taskName":"工单派发","startTime":"2020-12-08 15:21:28","empNo":"NO-0000044","endTime":"2020-12-08 15:23:28"},{"empId":"f7e725ffbe9d96f452327e7fc5910915","phone":"18737144555","empName":"部门员工","taskName":"工程师提交工单","startTime":"2020-12-08 15:23:28","empNo":"NO-0000047","endTime":"2020-12-08 16:30:01"},{"empId":"f7e725ffbe9d96f452327e7fc5910912","phone":"187371354","empName":"客服","taskName":"客服复核工单","startTime":"2020-12-08 16:30:01","empNo":"NO-0000044","endTime":null}]
         * evaluteInfo : null
         * self : {"repairId":"9c6198c8f85ab9cff110661f81d55f0f","createTime":"2020-12-08 15:21:29","customerId":"d52e58e375d5146b1271de9bd93fd306","repairTypeId":"05a8922d99024d7ddc879220089225dc","repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":"111111","reserveTime":"2020-12-02 00:00:00","notes":"111","updatetime":"2020-12-08 16:30:00","floor":null,"customerName":"wo ","content":"这个处理中","status":"3","originType":"1","processId":"242501","imgs":null,"urgeTimes":0,"dealPerson":null}
         * dealPerson : {"employeeId":"f7e725ffbe9d96f452327e7fc5910915","employeeName":"部门员工","employeeNo":"NO-0000047","sex":"1","phone":"18737144555","phoneBackup":"16608831825","mail":"1621700974@qq.com","birthday":"1980-09-02","nation":"汉族","dutyName":"员工","deptId":"23f31ddf735875d51b7987fe34aac187","deptName":null,"address":null,"inDate":"2019-08-02 12:32:45","outDate":null,"status":"1","systemEnable":"1","notes":"这里是备注","createTime":null,"updateTime":"2020-11-03 16:32:08"}
         * order : {"workOrderId":"c89d61b3e40e02a99ef6f558a0228ffb","workOrderType":"0","relationId":"9c6198c8f85ab9cff110661f81d55f0f","orderStatus":"3","creator":null,"createTime":"2020-12-08 15:21:29","priority":null,"executor":"f7e725ffbe9d96f452327e7fc5910915","notes":null,"endTime":null,"floor":null,"updateTime":"2020-12-08 16:30:02","relationTableName":"t_repair","contactNum":null,"processId":"242501"}
         */

        private String evaluteInfo;
        private SelfBean self;
        private DealPersonBean dealPerson;
        private OrderBean order;
        private List<OrderDetailsBean> orderDetails;

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

        public DealPersonBean getDealPerson() {
            return dealPerson;
        }

        public void setDealPerson(DealPersonBean dealPerson) {
            this.dealPerson = dealPerson;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<OrderDetailsBean> getOrderDetails() {
            return orderDetails;
        }

        public void setOrderDetails(List<OrderDetailsBean> orderDetails) {
            this.orderDetails = orderDetails;
        }

        public static class SelfBean {
            /**
             * repairId : 9c6198c8f85ab9cff110661f81d55f0f
             * createTime : 2020-12-08 15:21:29
             * customerId : d52e58e375d5146b1271de9bd93fd306
             * repairTypeId : 05a8922d99024d7ddc879220089225dc
             * repairTypeName : null
             * spaceId : null
             * spaceNo : null
             * customerPhone : 111111
             * reserveTime : 2020-12-02 00:00:00
             * notes : 111
             * updatetime : 2020-12-08 16:30:00
             * floor : null
             * customerName : wo
             * content : 这个处理中
             * status : 3
             * originType : 1
             * processId : 242501
             * imgs : null
             * urgeTimes : 0
             * dealPerson : null
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
            private String processId;
            private String  imgs;
            private int urgeTimes;
            private String dealPerson;

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

            public String getDealPerson() {
                return dealPerson;
            }

            public void setDealPerson(String dealPerson) {
                this.dealPerson = dealPerson;
            }
        }

        public static class DealPersonBean {
            /**
             * employeeId : f7e725ffbe9d96f452327e7fc5910915
             * employeeName : 部门员工
             * employeeNo : NO-0000047
             * sex : 1
             * phone : 18737144555
             * phoneBackup : 16608831825
             * mail : 1621700974@qq.com
             * birthday : 1980-09-02
             * nation : 汉族
             * dutyName : 员工
             * deptId : 23f31ddf735875d51b7987fe34aac187
             * deptName : null
             * address : null
             * inDate : 2019-08-02 12:32:45
             * outDate : null
             * status : 1
             * systemEnable : 1
             * notes : 这里是备注
             * createTime : null
             * updateTime : 2020-11-03 16:32:08
             */

            private String employeeId;
            private String employeeName;
            private String employeeNo;
            private String sex;
            private String phone;
            private String phoneBackup;
            private String mail;
            private String birthday;
            private String nation;
            private String dutyName;
            private String deptId;
            private String deptName;
            private String address;
            private String inDate;
            private String outDate;
            private String status;
            private String systemEnable;
            private String notes;
            private String createTime;
            private String updateTime;

            public String getEmployeeId() {
                return employeeId;
            }

            public void setEmployeeId(String employeeId) {
                this.employeeId = employeeId;
            }

            public String getEmployeeName() {
                return employeeName;
            }

            public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
            }

            public String getEmployeeNo() {
                return employeeNo;
            }

            public void setEmployeeNo(String employeeNo) {
                this.employeeNo = employeeNo;
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

            public String getPhoneBackup() {
                return phoneBackup;
            }

            public void setPhoneBackup(String phoneBackup) {
                this.phoneBackup = phoneBackup;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getDutyName() {
                return dutyName;
            }

            public void setDutyName(String dutyName) {
                this.dutyName = dutyName;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getInDate() {
                return inDate;
            }

            public void setInDate(String inDate) {
                this.inDate = inDate;
            }

            public String getOutDate() {
                return outDate;
            }

            public void setOutDate(String outDate) {
                this.outDate = outDate;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSystemEnable() {
                return systemEnable;
            }

            public void setSystemEnable(String systemEnable) {
                this.systemEnable = systemEnable;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class OrderBean {
            /**
             * workOrderId : c89d61b3e40e02a99ef6f558a0228ffb
             * workOrderType : 0
             * relationId : 9c6198c8f85ab9cff110661f81d55f0f
             * orderStatus : 3
             * creator : null
             * createTime : 2020-12-08 15:21:29
             * priority : null
             * executor : f7e725ffbe9d96f452327e7fc5910915
             * notes : null
             * endTime : null
             * floor : null
             * updateTime : 2020-12-08 16:30:02
             * relationTableName : t_repair
             * contactNum : null
             * processId : 242501
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

        public static class OrderDetailsBean {
            /**
             * empId : 56cfac326b91efeeacee30a46ddb3df2
             * phone : 15515554312
             * empName : 客户代表
             * taskName : 工单录入
             * startTime : 2020-12-08 15:21:28
             * empNo : No-00001
             * endTime : 2020-12-08 15:21:28
             */

            private String empId;
            private String phone;
            private String empName;
            private String taskName;
            private String startTime;
            private String empNo;
            private String endTime;

            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEmpName() {
                return empName;
            }

            public void setEmpName(String empName) {
                this.empName = empName;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEmpNo() {
                return empNo;
            }

            public void setEmpNo(String empNo) {
                this.empNo = empNo;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }
        }
    }
}
