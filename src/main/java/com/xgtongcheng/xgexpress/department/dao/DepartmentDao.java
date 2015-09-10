package com.xgtongcheng.xgexpress.department.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.department.entity.Department;

/**
 * Created by WWX on 2015/9/1.
 */
@MyBatisDao
public interface DepartmentDao {
    public Department get(String id);
}
