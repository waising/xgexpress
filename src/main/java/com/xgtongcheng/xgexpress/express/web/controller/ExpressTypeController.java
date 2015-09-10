package com.xgtongcheng.xgexpress.express.web.controller;

import com.xgtongcheng.xgexpress.express.entity.ExpressType;
import com.xgtongcheng.xgexpress.express.service.ExpressTypeService;
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
@RequestMapping(value = "etype")
public class ExpressTypeController {
    private static final Logger logger = LoggerFactory.getLogger(ExpressTypeController.class);
    @Autowired
    ExpressTypeService expressTypeService;

    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    @ResponseBody
    public ExpressType expressType(@PathVariable(value = "id") String id){
        logger.info("expressType");
        return expressTypeService.get(id);
    }
}
