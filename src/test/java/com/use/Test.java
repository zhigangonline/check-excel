
package com.use;


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        List<String> stringList = new ArrayList<>();
        int i = 10;
        System.out.println(i +(i >> 1));
        System.out.println(i << 1);
        Map<String, Integer> map = new HashMap<>();
        map.put("String", 0);
    }
}
