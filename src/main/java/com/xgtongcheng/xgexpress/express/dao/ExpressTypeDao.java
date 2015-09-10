package com.xgtongcheng.xgexpress.express.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.express.entity.ExpressType;

/**
 * Created by WWX on 2015/9/2.
 */
@MyBatisDao
public interface ExpressTypeDao {
    public ExpressType get(String id);
    public void add(ExpressType expressType);
}
