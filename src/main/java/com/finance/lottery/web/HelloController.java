package com.finance.lottery.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: lottery
 * @description:
 * @author: siming.wang
 * @create: 2018-09-08 21:24
 **/


@Controller
@RequestMapping("hello")
public class HelloController {


    @RequestMapping(value = "wsm",method = {RequestMethod.GET})
    @ResponseBody
    public String hello(){
        return "hello,wsm";
    }
}
