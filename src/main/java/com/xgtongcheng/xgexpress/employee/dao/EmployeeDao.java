package com.xgtongcheng.xgexpress.employee.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.employee.entity.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Created by WWX on 2015/9/1.
 */
@MyBatisDao
public interface EmployeeDao {
    public Employee get(String id);

    public List<Employee> getEmployees(String departId);

    public Employee check(HashMap<String,String> map);
}
