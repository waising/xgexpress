package com.xgtongcheng.xgexpress.express.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.express.entity.ExpressPeople;

/**
 * Created by WWX on 2015/9/2.
 */
@MyBatisDao
public interface ExpressPeopleDao {
    public ExpressPeople get(String id);
    public void add(ExpressPeople expressPeople);
}
