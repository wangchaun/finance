package com.finance.lottery.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.finance.lottery.module.BJPK10;
import com.finance.lottery.module.Number;
import com.finance.lottery.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.math.BigDecimal;
import java.util.*;

/**
 * @program: lottery
 * @description:
 * @author: siming.wang
 * @create: 2018-09-08 22:18
 **/

public class Crawler {


    private final static String cpBjpk10Url =
            "https://www.cp999789.com/data/bjpk10/lotteryList/";

    private static List<BigDecimal> probabilitys = new ArrayList<>();

    private static Map<Integer,BigDecimal> qishuMap = new HashMap<>();
//    private static Map<String,Map<Integer,BigDecimal>> qishuDailyMap = new HashMap<>();


    public static void main(String[] args){

        List<String> getUrls = new ArrayList<>();
        getUrls.add("2018-08-01.json");
        getUrls.add("2018-08-02.json");
        getUrls.add("2018-08-03.json");
        getUrls.add("2018-08-04.json");
        getUrls.add("2018-08-05.json");
        getUrls.add("2018-08-06.json");
        getUrls.add("2018-08-07.json");
        getUrls.add("2018-08-08.json");
        getUrls.add("2018-08-09.json");
        getUrls.add("2018-08-10.json");
        getUrls.add("2018-08-11.json");
        getUrls.add("2018-08-12.json");
        getUrls.add("2018-08-13.json");
        getUrls.add("2018-08-14.json");
        getUrls.add("2018-08-15.json");
        getUrls.add("2018-08-16.json");
        getUrls.add("2018-08-17.json");
        getUrls.add("2018-08-18.json");
        getUrls.add("2018-08-19.json");
        getUrls.add("2018-08-20.json");
        getUrls.add("2018-08-21.json");
        getUrls.add("2018-08-22.json");
        getUrls.add("2018-08-23.json");
        getUrls.add("2018-08-24.json");
        getUrls.add("2018-08-25.json");
        getUrls.add("2018-08-26.json");
        getUrls.add("2018-08-27.json");
        getUrls.add("2018-08-28.json");
        getUrls.add("2018-08-29.json");
        getUrls.add("2018-08-30.json");
        getUrls.add("2018-09-01.json");
        getUrls.add("2018-09-02.json");
        getUrls.add("2018-09-03.json");
        getUrls.add("2018-09-04.json");
        getUrls.add("2018-09-05.json");
        getUrls.add("2018-09-06.json");
        getUrls.add("2018-09-07.json");
        getUrls.add("2018-09-08.json");

        for (String getUrl : getUrls){
            System.out.println("----------开始分析"+getUrl.replace(".json", "")+"的数据----------");
            Map<Integer,BigDecimal> qishuDM = new HashMap<>();
            findPrice(getUrl,qishuDM);
//            qishuDailyMap.put(getUrl.replace(".json", ""), qishuDM);
             System.out.println();
            for (Map.Entry<Integer,BigDecimal> entry :qishuDM.entrySet()){
                System.out.println(entry.getKey() + " cishu : " + entry.getValue());
                System.out.println();

            }
            System.out.println(getUrl.replace(".json", "") + "----------price analysize end----------");
            System.out.println( "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
            qishuDM.clear();
        }


        System.out.println("一共统计了：" + probabilitys.size()+ "天");
        System.out.println(probabilitys);

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal b : probabilitys){
            sum = sum.add(b);
        }
        System.out.println("平均概率为: " + sum.divide(new BigDecimal(probabilitys.size()), 4,BigDecimal.ROUND_HALF_UP) + "%");


        for (Map.Entry<Integer,BigDecimal> entry :qishuMap.entrySet()){
            System.out.println(entry.getKey() + " 期次数 : " + entry.getValue());
            System.out.println();

        }

//        for (Map.Entry<String,Map<Integer, BigDecimal>> entry :qishuDailyMap.entrySet()){
//            System.out.println(entry.getKey());
//            for (Map.Entry<Integer,BigDecimal> entry1 :entry.getValue().entrySet()){
//                System.out.println(entry1.getKey() + " cishu : " + entry1.getValue());
//                System.out.println();
//
//            }
//            System.out.println();
//
//        }


    }

    public static void findPrice(String getUrl, Map<Integer, BigDecimal> qishuDM){

        String response = HttpUtils.doGet(cpBjpk10Url + getUrl);
//        response = response.substring(1,response.length()-1);
        JSONArray object = JSON.parseArray(response);
        List<Number> bjpk10 = JSON.parseArray(response, Number.class);

        Collections.reverse(bjpk10);

        BigDecimal pullInTimes = BigDecimal.ZERO;
        BigDecimal prizeTimes = BigDecimal.ZERO;

        for(int i=0; i<10; i++){
            List<BigDecimal> bigDecimals = findAllPrice(qishuDM, bjpk10, pullInTimes, prizeTimes, i);
            pullInTimes = bigDecimals.get(0);
            prizeTimes = bigDecimals.get(1);
        }

        if (pullInTimes.compareTo(BigDecimal.ZERO) != 0){
            BigDecimal probability = prizeTimes.divide(pullInTimes, 4 ,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            System.out.println("总购买(135680)次数 : "  + pullInTimes);
            System.out.println("中奖次数 : " + prizeTimes);
            System.out.println(getUrl.replace(".json", "") + "的中奖概率 : " + probability + "%");
            probabilitys.add(probability);
        }

    }

    private static List<BigDecimal> findAllPrice(Map<Integer, BigDecimal> qishuDM, List<Number> bjpk10, BigDecimal pullInTimes, BigDecimal prizeTimes, int doubleIndex){

        int qishu = 0;
        boolean findDoubleOneFlag = false;
        for(int i=0; i<bjpk10.size()-1; i++){
            if(findDoubleOneFlag){
                qishu ++;

                if (qishu <= 14 && (bjpk10.get(i).getOpenNum().get(doubleIndex).equals(1)
                        || bjpk10.get(i).getOpenNum().get(doubleIndex).equals(3)
                        || bjpk10.get(i).getOpenNum().get(doubleIndex).equals(5)
                        || bjpk10.get(i).getOpenNum().get(doubleIndex).equals(6)
                        || bjpk10.get(i).getOpenNum().get(doubleIndex).equals(8)
                        || bjpk10.get(i).getOpenNum().get(doubleIndex).equals(10))
                        ){
                    pullInTimes = pullInTimes.add(BigDecimal.ONE);
                    prizeTimes = prizeTimes.add(BigDecimal.ONE);
                    findDoubleOneFlag = false;
//                    System.out.println(bjpk10.get(i).getOpenDateTime() + ": 中奖啦");

                    if(qishuMap.containsKey(qishu)){
                        qishuMap.put(qishu, qishuMap.get(qishu).add(BigDecimal.ONE));
                    }else {
                        qishuMap.put(qishu, BigDecimal.ONE);
                    }

                    if(qishuDM.containsKey(qishu)){
                        qishuDM.put(qishu, qishuDM.get(qishu).add(BigDecimal.ONE));
                    }else {
                        qishuDM.put(qishu, BigDecimal.ONE);
                    }

                    qishu = 0;
                }
                if(qishu > 14){
                    qishu = 0;
                    findDoubleOneFlag = false;
                    pullInTimes = pullInTimes.add(BigDecimal.ONE);
                    if(qishuMap.containsKey(15)){
                        qishuMap.put(15, qishuMap.get(15).add(BigDecimal.ONE));
                    }else {
                        qishuMap.put(15, BigDecimal.ONE);
                    }

                    if(qishuDM.containsKey(qishu)){
                        qishuDM.put(15, qishuDM.get(15).add(BigDecimal.ONE));
                    }else {
                        qishuDM.put(15, BigDecimal.ONE);
                    }
                }

            }
            if (!findDoubleOneFlag) {
                if (bjpk10.get(i).getOpenNum().get(doubleIndex).equals(
                        bjpk10.get(i + 1).getOpenNum().get(doubleIndex))) {
//                    System.out.println(bjpk10.get(i+1).getOpenDateTime() + "第" + (doubleIndex+1) + "名，出现重复名次："+ bjpk10.get(i + 1).getOpenNum().get(doubleIndex));
//                    System.out.println(bjpk10.get(i+1).getOpenDateTime() + ": 下次开奖开始购买135680" );
                    findDoubleOneFlag = true;
                    i++;
                }
            }

        }

        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals.add(pullInTimes);
        bigDecimals.add(prizeTimes);

        return bigDecimals;
    }
}