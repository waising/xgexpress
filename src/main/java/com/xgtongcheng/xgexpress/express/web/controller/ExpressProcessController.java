package com.xgtongcheng.xgexpress.express.web.controller;

import com.xgtongcheng.xgexpress.express.entity.ExpressProcess;
import com.xgtongcheng.xgexpress.express.service.ExpressProcessService;
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
@RequestMapping(value = "eprocess")
public class ExpressProcessController {
    private static final Logger logger = LoggerFactory.getLogger(ExpressProcessController.class);

    @Autowired
    ExpressProcessService expressProcessService;

    @RequestMapping(value = "/{expId}",method={RequestMethod.GET})
    @ResponseBody
    public ExpressProcess expressProcess(@PathVariable(value = "expId") String expId){
        logger.info("expressProcess");
        return expressProcessService.getByExpId(expId);
    }
}
