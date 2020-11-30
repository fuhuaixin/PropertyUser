package com.fhx.propertyuser.bean;

import java.util.List;

public class ContactsBranchBean  {

    private int isShow; //0 未展开 1 展开
    private String title;

    public List<MsgBean> msgBeanList ;

    public ContactsBranchBean(int isShow, String title) {
        this.isShow = isShow;
        this.title = title;
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



    public List<MsgBean> getMsgBeanList() {
        return msgBeanList;
    }

    public void setMsgBeanList(List<MsgBean> msgBeanList) {
        this.msgBeanList = msgBeanList;
    }

    public static class MsgBean{
        private int isShow; //0 未展开 1 展开
        private String title;
        private String id;

        public MsgBean(int isShow, String title, String id) {
            this.isShow = isShow;
            this.title = title;
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }
    }
}
