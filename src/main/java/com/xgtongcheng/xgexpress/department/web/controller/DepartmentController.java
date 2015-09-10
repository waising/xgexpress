package com.xgtongcheng.xgexpress.department.web.controller;

import com.xgtongcheng.xgexpress.department.entity.Department;
import com.xgtongcheng.xgexpress.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WWX on 2015/9/1.
 */
@Controller
@RequestMapping(value = "depart")
public class DepartmentController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    @ResponseBody
    public Department get(@PathVariable(value = "id") String id) {
        logger.info("get");
        Department d = departmentService.get(id);
        return d;
    }
}
