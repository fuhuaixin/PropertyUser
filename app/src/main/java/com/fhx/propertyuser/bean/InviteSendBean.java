package com.fhx.propertyuser.bean;

import com.fhx.propertyuser.base.BaseBean;

public class InviteSendBean extends BaseBean {

    private String inviteName;
    private String phone;
    private String time;
    private String reason;

    public InviteSendBean(String inviteName, String phone, String time, String reason) {
        this.inviteName = inviteName;
        this.phone = phone;
        this.time = time;
        this.reason = reason;
    }

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
