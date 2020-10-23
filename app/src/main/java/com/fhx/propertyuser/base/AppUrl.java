package com.fhx.propertyuser.base;

public class AppUrl {

    public static final String BASEURL = "http://192.168.10.50:8083/"; //测试(测试环境)
//    public static final String BASEURL = "http://192.168.10.127:8083/"; //测试(测试环境)

    //注册
    public static final String Register = BASEURL + "customer/register";
    //用户端App登录
    public static final String Login = BASEURL + "customer/appUser";
    //用户验证手机号是否已经注册过
    public static final String CheckExist = BASEURL + "customer/checkExist";
    //报修类型列表查询接口
    public static final String RepairType = BASEURL + "repairType/list";
    //添加报修信息
    public static final String RepairAdd = BASEURL + "repair/add";
    //报修列表查询接口
    public static final String RepairList = BASEURL + "repair/list";
    //撤回报修接口
    public static final String RepairCancel = BASEURL + "repair/cancel";
    //投诉类型列表查询接口
    public static final String ComplaintType = BASEURL + "complaintType/list";
    //添加投诉信息
    public static final String ComplaintAdd = BASEURL + "complaint/add";



}
