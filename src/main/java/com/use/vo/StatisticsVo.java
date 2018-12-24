package com.use.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class StatisticsVo {
    // 日期
    private Date date;
    // 电影
    private String filmName;
    // 座位
    private String seat;
    // 场次id
    private String filedId;
    // 影院
    private String cinemaName;
    // 影厅
    private String screeningHall;
    // 语言
    private String languageVersion;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 张数
    private String ticketNum;
    // 座位
    private String seat1;
    // 票码
    private String code;
    // 备注
    private String memo;
    // 备注信息
    private String memoInfo;

}
