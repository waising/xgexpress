package com.xgtongcheng.xgexpress.express.service;

import com.xgtongcheng.xgexpress.express.entity.ExpressPeople;

/**
 * Created by WWX on 2015/9/2.
 */
public interface ExpressPeopleService {
    public ExpressPeople get(String id);
    public void add(ExpressPeople expressPeople);
}
