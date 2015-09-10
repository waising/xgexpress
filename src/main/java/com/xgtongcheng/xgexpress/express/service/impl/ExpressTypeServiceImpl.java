package com.xgtongcheng.xgexpress.express.service.impl;

import com.xgtongcheng.xgexpress.express.dao.ExpressTypeDao;
import com.xgtongcheng.xgexpress.express.entity.ExpressType;
import com.xgtongcheng.xgexpress.express.service.ExpressTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WWX on 2015/9/2.
 */
@Service
public class ExpressTypeServiceImpl implements ExpressTypeService {

    @Autowired
    ExpressTypeDao expressTypeDao;
    public ExpressType get(String id) {
        return expressTypeDao.get(id);
    }

    public void add(ExpressType expressType) {
        expressTypeDao.add(expressType);
    }
}
