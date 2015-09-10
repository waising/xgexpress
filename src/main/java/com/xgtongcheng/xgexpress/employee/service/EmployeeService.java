package com.xgtongcheng.xgexpress.employee.service;

import com.xgtongcheng.xgexpress.employee.entity.Employee;

import java.util.List;

/**
 * Created by WWX on 2015/9/1.
 */
public interface EmployeeService {
    public Employee get(String id);
    public Employee check(String jobno,String pwd);

    public List<Employee> getEmployees(String departId);

}
