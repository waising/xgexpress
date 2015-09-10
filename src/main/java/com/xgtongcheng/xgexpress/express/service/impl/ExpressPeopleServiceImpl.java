package com.xgtongcheng.xgexpress.express.service.impl;

import com.xgtongcheng.xgexpress.express.dao.ExpressPeopleDao;
import com.xgtongcheng.xgexpress.express.entity.ExpressPeople;
import com.xgtongcheng.xgexpress.express.service.ExpressPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WWX on 2015/9/2.
 */
@Service
public class ExpressPeopleServiceImpl implements ExpressPeopleService{

    @Autowired
    ExpressPeopleDao expressPeopleDao;

    public ExpressPeople get(String id) {
        return expressPeopleDao.get(id);
    }

    public void add(ExpressPeople expressPeople) {
        expressPeopleDao.add(expressPeople);
    }
}
