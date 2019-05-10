package com.finance.lottery.utils.generator.util;

/**
 * @program: zeus-parent
 * @description:
 * @author: siming.wang
 * @create: 2019-05-10 15:10
 **/

public class StringUtil {


    public static String UpperFirst(String str) {
        return str.substring(0,1).toUpperCase().concat(str.substring(1));
    }
    public static String LowerFirst(String str) {
        return str.substring(0,1).toLowerCase().concat(str.substring(1));
    }
}
