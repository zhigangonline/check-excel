package com.use.vo;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BuyVo {

    private String batchId;
    private String fieldId;
    private String date;
    private String filmId;
    private String startTime1;
    private String cinemaId;
    private String screeningHall;
    private String languageVersion;
    private String startTime2;
    private String endTime;
    private String buyNum;
    private String restNum;
    private String webSiteId;
    private String buyMoney;
    private String price;
    private String cachedTag;
    private String publishType;
}
