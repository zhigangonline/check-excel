package com.use.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassInfoUtil {
    public static String getClassAndMethod(String param){
        String info = new StringBuilder(Thread.currentThread().getStackTrace()[2].getClassName())
                .append("#")
                .append(Thread.currentThread().getStackTrace()[2].getMethodName())
                .append(":::::::::::===============::::::::::::")
                .append(param)
                .append("\n")
                .toString();
        log.info(info);
        return info;
    }
}
