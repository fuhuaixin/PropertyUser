package com.fhx.propertyuser.bean;

import java.util.List;

public class ContactsBranchBean  {

    private int isShow; //0 未展开 1 展开
    private String title;
    private int total;

    public List<MsgBean> msgBeanList ;

    public ContactsBranchBean(int isShow, String title, int total,List<MsgBean> msgBeanList) {
        this.isShow = isShow;
        this.title = title;
        this.total = total;
        this.msgBeanList = msgBeanList;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MsgBean> getMsgBeanList() {
        return msgBeanList;
    }

    public void setMsgBeanList(List<MsgBean> msgBeanList) {
        this.msgBeanList = msgBeanList;
    }

    public static class MsgBean{
        private String name;
        private String job;
        private String phone;

        public MsgBean(String name, String job, String phone) {
            this.name = name;
            this.job = job;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
