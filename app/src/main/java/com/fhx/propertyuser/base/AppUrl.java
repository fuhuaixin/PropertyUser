package com.fhx.propertyuser.base;

public class AppUrl {

//    public static final String BASEURL = "http://192.168.10.50:8083/"; //测试(测试环境)
    public static final String BASEURL = "http://192.168.10.241:8083/"; //测试(测试环境)

    //通知公告 资讯 baseUrl
    public static final String NEWSTITLEURL = "http://192.168.10.50:8055/smartbuilding_light/#/newsshow?id=";

    //注册
    public static final String Register = BASEURL + "people/register";
    //用户端App登录
    public static final String Login = BASEURL + "people/appUser";
    //修改密码
    public static final String ChangePassWord = BASEURL + "people/modifyPwd";

    //用户验证手机号是否已经注册过
    public static final String CheckExist = BASEURL + "customer/checkExist";

    //报修类型列表查询接口
    public static final String RepairType = BASEURL + "repairType/list";
    //添加报修信息
    public static final String RepairAdd = BASEURL + "repair/add";
    //删除报修信息
    public static final String RepairDel = BASEURL + "repair/del";
    //报修列表查询接口
    public static final String RepairList = BASEURL + "repair/list";
    //根据id获得报修及工单处理详情
    public static final String RepairDetail = BASEURL + "repair/detail";
    //撤回报修接口
    public static final String RepairCancel = BASEURL + "repair/cancel";

    //提交评价
    public static final String EvaluteSubmit = BASEURL + "evalute/submit";
    //查询评价
    public static final String EvaluteGet = BASEURL + "evalute/getDetailByOriginId";

    //投诉类型列表查询接口
    public static final String ComplaintType = BASEURL + "complaintType/list";
    //添加投诉信息
    public static final String ComplaintAdd = BASEURL + "complaint/add";
    //删除投诉信息
    public static final String ComplaintDel = BASEURL + "complaint/del";
    //投诉列表查询接口
    public static final String ComplaintList = BASEURL + "complaint/list";
    //根据id获得投诉及工单处理详情
    public static final String ComplaintDetail = BASEURL + "complaint/detail";

    //催办
    public static final String OrderUrge = BASEURL + "order/urge";

    //APP添加车辆信息
    public static final String CarAdd = BASEURL + "car/add";
    //修改车辆信息
    public static final String CarEdit = BASEURL + "car/edit";
    //删除车辆信息
    public static final String CarDel = BASEURL + "car/del";
    //车辆列表分页查询接口
    public static final String CarList = BASEURL + "car/list";
    //根据车辆id获得详情
    public static final String CarDetail = BASEURL + "car/detail";

    //添加访客信息
    public static final String VisitorAdd = BASEURL + "visit/add";
    //添加访客信息
    public static final String Visitorlist = BASEURL + "visit/list";

    //部门父子结构整理
    public static final String DeptTree = BASEURL + "dept/treeList";

    //根据部门id获得员工列表
    public static final String EmployeeFindDept = BASEURL + "employee/findListByDeptId";
    //根据id员工详情
    public static final String EmployeeDetail = BASEURL + "employee/detail";

    //添加人员认证信息
    public static final String AuditAdd = BASEURL + "audit/add";
    //重新添加人员认证信息
    public static final String AuditReAdd = BASEURL + "audit/readd";
    //获得所有人员认证信息
    public static final String AuditList = BASEURL + "audit/list";
    //根据手机号查询认证状态
    public static final String AuditResult = BASEURL + "audit/getResult";

    //通知公告列表 查询接口   用户端通知公告: userAnnounce   用户端楼宇资讯: userNews
    public static final String NewsList = BASEURL + "news/list";

    //消息通知列表查询接口
    public static final String MessageList = BASEURL + "messages/list";
    //消息已读  { name: '报修', code: 'repaire' },
    //                    { name: '投诉', code: 'complain' },
    //                    { name: '新闻', code: 'news' }
    //点击跳转对应的详情页
    public static final String MessageRead = BASEURL + "messages/readed";


    //图片上传功能
    public static final String ImageUpLoad = BASEURL + "news/upload";

}
