package com.finance.lottery.utils.generator.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: perseus
 * @description: 驼峰，下划线互转
 * @author: siming.wang
 * @create: 2019-04-03 13:54
 **/

public class CamelUnderUtil {

    //驼峰转下划线，abcAbcaBc->abc_abca_bc
    public static String underline(String name) {
        StringBuilder result = new StringBuilder();
        if ((name != null) && (name.length() > 0)) {
            result.append(name.substring(0, 1).toLowerCase());
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                if (!("_".equals(s)) && (s.equals(s.toUpperCase())) && (!Character.isDigit(s.charAt(0)))) {
                    result.append("_");
                }
                result.append(s.toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 将下划线风格替换为驼峰风格
     *
     * @param inputString
     * @return
     */
    public static String camelHump(String inputString) {
        StringBuilder sb = new StringBuilder();

        if(!inputString.contains("_")){
            return inputString;
        }

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    public static HashMap<String, Object> converMapKeys(Map<String, Object> paramMap){
        HashMap<String, Object> paramMapReturn = new HashMap<>();

        Iterator<String> it = paramMap.keySet().iterator();
        while (it.hasNext()){
            String key =  it.next();
            if("pageNumber".equals(key) || "pageSize".equals(key) || "sessionId".equals(key)){
                continue;
            }
            paramMapReturn.put(CamelUnderUtil.underline(key), paramMap.get(key));
        }

        return paramMapReturn;
    }



    public static void main(String[] args){
        String name = "user_no";
        String email = "is_email";


        System.out.println("underline = " + underline(name));
        System.out.println("underline = " + underline(email));

        System.out.println("camel = " + camelHump(name));
        System.out.println("camel = " + camelHump(email));


    }



}
