package com.use.vo;


public enum ResultEnum {
    Success(200,"请求成功",null),
    Fail(500,"请求失败",null ),
    Type_Error(510,  "请求设备类型错误！",null),
    Bind_ThirdPlatform_Exist(511, "该第三方账号已经绑定！",null),

    Repeat(501,"重复数据",null ),

    NoVaildUser(512, "不是有效的用户token!" ,null),
    NoLogin(502,"用户未登入!请登录!",null ),
    NotAdmin(503,"该登录用户不是管理员!请使用管理员登录!" ,null),
    ErrorParams(504, "参数错误！" ,null),
    PhoneNumberExists(505, "手机号已经存在！",null ),
    PhoneNumberNotExists(505, "手机号不存在！" ,null),

    Logined(520,  "用户已登入!",null),
    Login_VerifyCode_Error(521,  "验证码过期或失效!",null),
    Login_Type_Error(522,  "用户登录类型错误！",null),

    ScoreNoMore(533, "积分数不够!",null),
    User_Exchange_ScoreToMoney_Error(534,  "积分兑换金额的比例有误；%s积分可以兑换%s元!",null),
    User_Exchange_ScoreToTicket_Error(535, "积分兑换票权的比例有误；%s积分可以兑换%s票权!",null),

    Exchange_Ticket_Error(601, "您兑换电影票数应该大于1张！",null),
    Exchange_User_Film(602, "您已经兑换了该电影的影票！不能再次兑换！",null),
    Exchange_User_Film_App(622, "超过兑换总张数上限：4张！不能兑换该电影的影票！",null),
    Exchange_H5_Already(612, "您在微信端已经兑换过当日的该电影票！",null),
    Exchange_Ticket_None(603, "该场已经无电影票可以兑换！",null),
    Exchange_Ticket_NoMore(604, "该场电影票只有%s张票可以兑换！",null),
    Exchange_Ticket_Less(605, "您只有%s票权可以兑换！",null),

    Exchange_Code_Error(610, "兑换码有误，或已经兑换！",null),
    Exchange_Code_Get_Already(611, "你已经领取兑换码！",null),
    Exchange_Code_NoMore(612, "兑换码已经领完！",null),
    Exchange_Code_Expire(613, "兑换码已经过期或还没到使用日期！",null),

    Exchange_Partner_UserInfo_Error(620, "获取合作方用户信息有误！",null),
    Exchange_TuoChi_UserInfo_Error(621, "您不是拓词的用户！",null),
    Exchange_Partner_Error(623, "用户伪造！",null),

    Exchange_PublishType_Error(630, "您兑换电影票所在的平台有误！",null),

    Find_No_Cinema(700, "附近没有影院！",null),

    Drawout_Money_Less(800, "您没有足够的金额提现！",null),
    Drawout_Week_Error(801, "只有周三周五才可以提现！",null),

    Task_Id_Error(900,"任务Id不存在！",null),
    ;


    private Integer status;
    private String message;
    private String datas;

    ResultEnum(Integer status, String message, String datas) {
        this.status = status;
        this.message = message;
        this.datas=datas;
    }



    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
