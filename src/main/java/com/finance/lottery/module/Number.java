package com.finance.lottery.module;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: lottery
 * @description:
 * @author: siming.wang
 * @create: 2018-09-08 22:44
 **/

public class Number implements Serializable{
    private static final long serialVersionUID = 1L;

    private String openDateTime;
    private String issue;
    private List<Integer> openNum;
    private List<Integer> sumArr;
    private List<Integer> dtArr;
    private List<String> formArr;
    private List<String> mimcryArr;
    private List<Integer> compareArr;
    private String sumType;
    private String wuxing;

    public String getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(String openDateTime) {
        this.openDateTime = openDateTime;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public List<Integer> getOpenNum() {
        return openNum;
    }

    public void setOpenNum(List<Integer> openNum) {
        this.openNum = openNum;
    }

    public List<Integer> getSumArr() {
        return sumArr;
    }

    public void setSumArr(List<Integer> sumArr) {
        this.sumArr = sumArr;
    }

    public List<Integer> getDtArr() {
        return dtArr;
    }

    public void setDtArr(List<Integer> dtArr) {
        this.dtArr = dtArr;
    }

    public List<String> getFormArr() {
        return formArr;
    }

    public void setFormArr(List<String> formArr) {
        this.formArr = formArr;
    }

    public List<String> getMimcryArr() {
        return mimcryArr;
    }

    public void setMimcryArr(List<String> mimcryArr) {
        this.mimcryArr = mimcryArr;
    }

    public List<Integer> getCompareArr() {
        return compareArr;
    }

    public void setCompareArr(List<Integer> compareArr) {
        this.compareArr = compareArr;
    }

    public String getSumType() {
        return sumType;
    }

    public void setSumType(String sumType) {
        this.sumType = sumType;
    }

    public String getWuxing() {
        return wuxing;
    }

    public void setWuxing(String wuxing) {
        this.wuxing = wuxing;
    }
}