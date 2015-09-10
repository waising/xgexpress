package com.xgtongcheng.xgexpress.department.entity;

import com.xgtongcheng.xgexpress.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by WWX on 2015/9/1.
 */
@Component
public class Department implements Serializable {
    private String id;

    /**
     * 负责人
     */
    private String manager;
    /**
     * 员工
     */
    private List<Employee> employees;
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

}
