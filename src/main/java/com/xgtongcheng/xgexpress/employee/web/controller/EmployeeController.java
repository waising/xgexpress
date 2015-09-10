package com.xgtongcheng.xgexpress.employee.web.controller;

import com.xgtongcheng.xgexpress.employee.entity.Employee;
import com.xgtongcheng.xgexpress.employee.service.EmployeeService;
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
@RequestMapping(value = "employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    /**
     * ȡemployee
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}" ,method={RequestMethod.GET})
    @ResponseBody
    public Employee get(@PathVariable(value = "id") String id) {
        logger.info("get");
        return employeeService.get(id);
    }

    @RequestMapping(value = "/check" ,method={RequestMethod.GET})
    @ResponseBody
    public Employee check(String jobno,String pwd) {
        logger.info("check");
        return employeeService.check(jobno,pwd);
    }

}
