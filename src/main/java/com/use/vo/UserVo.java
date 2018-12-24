package com.use.vo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserVo {
    public static final String Table = "t_user";

    private String name;
    private String address;
    private Integer age;


}
