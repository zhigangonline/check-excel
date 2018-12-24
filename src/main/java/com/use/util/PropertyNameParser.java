package com.use.util;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.use.annotation.PropertyName;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author mazg
 */
public class PropertyNameParser {
    public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     *
     */
    /**
     *
     * @param t 目标类
     * @param v 参数类
     * @return
     */
    public static <T,V> T getBean(T t,Object[] v){
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            PropertyName annotation = field.getAnnotation(PropertyName.class);
            if (annotation != null){
                try {
                    if (Optional.fromNullable(ReflectionUtils.findField(t.getClass(), field.getName())).isPresent()){
                        if (Optional.fromNullable(v[annotation.order()]).isPresent()){
                            String property = v[annotation.order()].toString();
                            if (!Strings.isNullOrEmpty(property)){
                                ConvertUtils.register(new DateLocaleConverter(), Date.class);
                                BeanUtils.setProperty(t, field.getName(), convert(TypeToken.of(annotation.type()),property));
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
        return t;
    }

    /**
     *
     * @param t 类型
     * @param value 值
     * @return
     */
    private static <T>  Object convert(TypeToken<T> t, String value) {
        if (t.getClass().isAssignableFrom(Date.class)) {
            try {
                return DateUtils.parseDate(value, STANDARD_DATE_FORMAT);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (t.isSupertypeOf(Integer.class)) {
            return Integer.parseInt(value);
        } else if (t.isSupertypeOf(Double.class)){
            return Double.valueOf(value);
        } else if (t.isSupertypeOf(Long.class)) {
            return Long.parseLong(value);
        } else if (t.isSupertypeOf(Boolean.class)) {
            return Boolean.parseBoolean(value);
        } else if (t.isSupertypeOf(BigInteger.class)) {
            return BigInteger.valueOf(Long.parseLong(value));
        } else if (t.isSupertypeOf(BigDecimal.class)) {
            return BigDecimal.valueOf(Double.valueOf(value));
        }
        return value;
    }
}
