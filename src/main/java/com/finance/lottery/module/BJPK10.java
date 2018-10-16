package com.finance.lottery.module;

import java.io.Serializable;
import java.util.List;

/**
 * @program: lottery
 * @description:
 * @author: siming.wang
 * @create: 2018-09-08 23:04
 **/

public class BJPK10 implements Serializable{


    private static final long serialVersionUID = 1L;
    private List<Number> numbers;

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }
}
