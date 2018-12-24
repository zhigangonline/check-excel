package com.use.po;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "mpw_cinema_business_buy")
public class MpwCinemaBusinessBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "field_id")
    //日期
    private String fieldId;
    //创建时间
    private Timestamp createtime;
    //批次id
    @Column(name = "batch_id")
    private String batchId;
    //结束时间
    private Time endtime;
    //开始时间
    private Time starttime;
    //语言版本
    @Column(name = "language_version")
    private String languageVersion;
    //影院id
    @Column(name = "cinema_id")
    private String cinemaId;
    //python已买选座位数
    @Column(name = "buy_num")
    private Integer buyNum;
    private Integer cacheTag;
    //价格（元）
    private Double price;
    //本场次花费的金额
    @Column(name = "buy_money")
    private Double buyMoney;
    //片名id
    @Column(name = "film_id")
    private String filmId;
    //更新时间
    private Timestamp updatetime;
    //备用字段
    @Column(name = "cinema_business_remark1")
    private String cinemaBusinessRemark1;
    //网站id（数据来源）
    @Column(name = "website_id")
    private String websiteId;
    //备用字段
    @Column(name = "cinema_business_remark2")
    private String cinemaBusinessRemark2;
    //放映厅
    @Column(name = "screening_hall")
    private String screeningHall;

}