package com.use.po;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@ToString
@Data
@Entity
@Table(name = "mpw_seatinfo")
public class MpwSeatinfo implements Serializable {

    private static final long serialVersionUID = -7000947255220715690L;
    /** 记录python返回的每张二维码的信息*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 批次id*/
    @Column(name = "batch_id")
    private String batchId;

    /** 座位信息*/
    private String seat;

    /** 二维码的内容*/
    @Column(name = "qr_code_content")
    private String qrCodeContent;

    /** 二维码名称*/
    @Column(name = "qr_code_name")
    private String qrCodeName;

    /** 存储位置*/
    @Column(name = "qr_path")
    private String qrPath;


    /** 场次id*/
    @Column(name = "field_id")
    private String fieldId;

    /** 0已兑换1未兑换*/
    private Integer exchange;

    /** 影票验证码*/
    @Column(name = "v_code")
    private String vCode;

    /** 猫眼订单号（不能重复）*/
    @Column(name = "order_id")
    private String orderId;

    /** 手机号*/
    @Column(name = "phone_number")
    private String phoneNumber;

    /** 用户id （未被兑换的时候 为 0 兑换后存储 用户id）*/
    @Column(name = "user_id")
    private Long userId;

    /** 使用票权兑换的个数  兑换几张变为几*/
    @Column(name = "ticket_rights")
    private Integer ticketRights;

    /** 使用第三方积分兑换的个数*/
    private Integer score;

    /** 观影结束标志 1--已经结束 0--未结束*/
    private Integer endTag;

    /** 可兑换票的个数*/
    @Column(name = "seat_num")
    private Integer seatNum;

    /** 备用*/
    @Column(name = "seat_remark1")
    private String seatRemark1;

    /** 备用*/
    @Column(name = "seat_remark2")
    private String seatRemark2;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** h5端购买票标志 1为H5端标志*/
    private Integer h5Tag;

    /** 电影id*/
    @Column(name = "film_id")
    private Long filmId;

    /** 兑换影票订单*/
    private String orderCode;

}
