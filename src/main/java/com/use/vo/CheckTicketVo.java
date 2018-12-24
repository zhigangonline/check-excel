package com.use.vo;

import com.use.annotation.PropertyName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString()
@Data
public class CheckTicketVo implements Serializable {


    private static final long serialVersionUID = 4307462721041562826L;
    @PropertyName(name = "city_name", order = 0)
    private String cityName;

    @PropertyName(name = "film_name", order = 1)
    private String filmName;

    @PropertyName(name = "cinema_name", order = 2)
    private String cinemaName;

    @PropertyName(name = "cinema_address", order = 3)
    private String cinemaAddress;

    @PropertyName(name = "date", order = 4)
    private Date date;

    @PropertyName(name = "starttime", order = 5)
    private String startTime;

    @PropertyName(name = "price", order = 6)
    private String price;

    @PropertyName(name = "seat", order = 7)
    private String seat;

    @PropertyName(name = "field_id", order = 8)
    private String fieldId;

    @PropertyName(name = "qr_code_content", order = 9)
    private String qrCodeContent;

    @PropertyName(name = "screening_hall", order = 10)
    private String screeningHall;

    @PropertyName(name = "language_version", order = 11)
    private String languageVersion;

    @PropertyName(name = "betch_id", order = 12)
    private String betchId;
}

