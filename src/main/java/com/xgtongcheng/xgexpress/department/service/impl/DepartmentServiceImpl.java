package com.xgtongcheng.xgexpress.department.service.impl;

import com.xgtongcheng.xgexpress.department.dao.DepartmentDao;
import com.xgtongcheng.xgexpress.department.entity.Department;
import com.xgtongcheng.xgexpress.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WWX on 2015/9/1.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDao departmentDao;

    public Department get(String id) {
        return departmentDao.get(id);
    }
}
