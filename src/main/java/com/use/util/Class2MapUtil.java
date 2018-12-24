package com.use.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;

import java.util.Map;

public class Class2MapUtil{
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    public static <T> Map<String,String> convertMap(T t){
        String json = gson.toJson(new TypeToken<T>() {
        }.getType());
        return gson.fromJson(json, new TypeToken<Map<String, String>>() {
        }.getType());
    }

    public static <T> T convertBean(Map<String,String> map,Class<T> clazz) {
        String json = gson.toJson(map, new TypeToken<Map<String, String>>() {
        }.getType());
        return gson.fromJson(json,clazz);
    }
}
