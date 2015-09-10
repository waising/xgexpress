package com.xgtongcheng.xgexpress.employee.service.impl;

import com.xgtongcheng.xgexpress.employee.dao.EmployeeDao;
import com.xgtongcheng.xgexpress.employee.entity.Employee;
import com.xgtongcheng.xgexpress.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by WWX on 2015/9/1.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    public Employee get(String id) {
        return employeeDao.get(id);
    }

    public List<Employee> getEmployees(String departId) {
        return employeeDao.getEmployees(departId);
    }

    public Employee check(String jobno,String pwd) {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("jobno",jobno);
        map.put("pwd",pwd);
        return employeeDao.check(map);
    }
}
