package com.example.feng.demo.controller;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.feng.demo.controller.bean.People;

@RestController
public class LoggerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello")
    public String hello(People people) {

        logger.info("LoggerController.hello param: " + JSON.toJSONString(people));
        logger.info("current thread: " + MDC.get("traceId"));
        logger.info("people's name: " + people.getName() + ", age: " + people.getAge());

        return "Hello " + people.getName();
    }

}
