package com.fhx.propertyuser.bean;

public class HomeCenterBean  {

    private String title;
    private int  image;

    private int ifNew;

    public HomeCenterBean(String title, int image, int ifNew) {
        this.title = title;
        this.image = image;
        this.ifNew = ifNew;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getIfNew() {
        return ifNew;
    }

    public void setIfNew(int ifNew) {
        this.ifNew = ifNew;
    }
}
