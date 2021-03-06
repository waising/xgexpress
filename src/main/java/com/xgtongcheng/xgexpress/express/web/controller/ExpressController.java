package com.xgtongcheng.xgexpress.express.web.controller;

import com.xgtongcheng.xgexpress.express.entity.Express;
import com.xgtongcheng.xgexpress.express.service.ExpressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WWX on 2015/9/2.
 */
@Controller
@RequestMapping(value = "express")
public class ExpressController {
    private static final Logger logger = LoggerFactory.getLogger(ExpressController.class);
    @Autowired
    ExpressService expressService;

    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    @ResponseBody
    public Express express(@PathVariable(value = "id") String id){
        logger.info("express");
        return expressService.get(id);
    }
}
