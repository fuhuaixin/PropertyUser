package com.fhx.propertyuser.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.fhx.propertyuser.base.BaseBean;

public class BuildInformBean extends BaseBean implements MultiItemEntity {

    public static final int IMG = 1;
    public static final int ITEM = 2;
    private int itemType;

    private String title;
    private String msg;
    private String time;





    public BuildInformBean(int itemType,String title, String msg, String time) {
        this.title = title;
        this.msg = msg;
        this.time = time;
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public int getItemType() {
        return itemType;
    }
}
