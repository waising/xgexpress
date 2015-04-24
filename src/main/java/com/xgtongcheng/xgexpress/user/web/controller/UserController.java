package com.xgtongcheng.xgexpress.user.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WWX on 2015/04/24.
 */
@Controller
@RequestMapping(value = "aaa")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/sss")
    public String index(){
        logger.info("111111111111111111111111111111111111");
        return "index";
    }
}
