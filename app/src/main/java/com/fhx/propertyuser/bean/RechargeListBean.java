package com.fhx.propertyuser.bean;

public class RechargeListBean  {
    private String title;
    private int Image;

    public RechargeListBean(String title, int image) {
        this.title = title;
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
