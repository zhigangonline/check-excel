package com.use.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Data
@Entity
@Table(name = "mpw_cinema")
public class MpwCinema implements Serializable {

    private static final long serialVersionUID = 2630877375932479129L;
    /** 影院id（我们自己设定）*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long cinemaId;

    /** 来自其他网站影院id*/
    @Column(name = "cinema_id_source")
    private String cinemaIdSource;

    /** 电影院名称*/
    @Column(name = "cinema_name")
    private String cinemaName;

    /** 猫眼年度排名*/
    @Column(name = "cinema_rank")
    private Long cinemaRank;

    /** 票房（万）*/
    @Column(name = "box_office")
    private String boxOffice;

    /** 年*/
    private String year;


    /** 数据来源*/
    @Column(name = "web_source")
    private String webSource;

    /** 是否国内网站：1国内0国外*/
    private String domestic;

    /** 影院电话*/
    @Column(name = "cinema_tel")
    private String cinemaTel;


    /** 经纬度定位*/
    @Column(name = "cinema_latitude_longitude")
    private String cinemaLatitudeLongitude;

    /** 影院地址*/
    @Column(name = "cinema_address")
    private String cinemaAddress;

    /** 备用*/
    @Column(name = "cinema_remark1")
    private String cinemaRemark1;

}
