package com.xgtongcheng.xgexpress.express.web.controller;

import com.xgtongcheng.xgexpress.express.entity.ExpressPeople;
import com.xgtongcheng.xgexpress.express.service.ExpressPeopleService;
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
@RequestMapping(value = "epeople")
public class ExpressPeopleController {
    private static final Logger logger = LoggerFactory.getLogger(ExpressPeopleController.class);
    @Autowired
    ExpressPeopleService expressPeopleService;

    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    @ResponseBody
    public ExpressPeople expressPeople(@PathVariable(value = "id") String id){
        logger.info("expressPeople");
        return expressPeopleService.get(id);
    }
}
