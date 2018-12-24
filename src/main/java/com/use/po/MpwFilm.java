package com.use.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@ToString
@Data
@Entity
@Table(name = "mpw_film")
public class MpwFilm implements Serializable {

    private static final long serialVersionUID = -4305392126074647280L;

    /** 电影id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    /** 其他网站上的电影id*/
    @Column(name = "film_id_self")
    private String filmIdSelf;

    /** 电影来源网站id（在字典表中）*/
    @Column(name = "web_source")
    private String webSource;

    /** 电影名称*/
    @Column(name = "film_name")
    private String filmName;

    /** 电影主角*/
    @Column(name = "film_lead")
    private String filmLead;

    /** 影片介绍*/
    @Column(name = "film_introduction")
    private String filmIntroduction;

    /** 电影时长*/
    @Column(name = "length_of_time")
    private String lengthOfTime;

    /** 电影类型:0热映1即将上映*/
    @Column(name = "film_type")
    private String filmType;

    /** 评分*/
    @Column(name = "film_score")
    private String filmScore;

    /** 电影票房*/
    @Column(name = "film_box_office")
    private String filmBoxOffice;

    /** 备用*/
    @Column(name = "film_remark1")
    private String filmRemark1;

    /** 备用*/
    @Column(name = "film_remark2")
    private String filmRemark2;

    /** 主图地址*/
    @Column(name = "film_photo")
    private String filmPhoto;

    /** 预告片地址*/
    private String prevue;

    /** 创建时间*/
    private Date createtime;

    /** 更新时间*/
    private Date updatetime;

}
