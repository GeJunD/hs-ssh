package com.hs.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogController {
    Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/log")
    public String log(){
        logger.debug("debug日志");
        logger.info("info日志");
        logger.warn("warn日志");
        logger.error("error日志");
        return "log";
    }
}
