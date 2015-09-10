package com.xgtongcheng.xgexpress.express.service.impl;

import com.xgtongcheng.xgexpress.express.dao.ExpressDao;
import com.xgtongcheng.xgexpress.express.entity.Express;
import com.xgtongcheng.xgexpress.express.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WWX on 2015/9/2.
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    ExpressDao expressDao;

    public Express get(String id) {
        return expressDao.get(id);
    }

    public List<Express> getExpresses() {
        return expressDao.getExpresses();
    }

    public void add(Express express) {
        expressDao.add(express);
    }

    public String getExpressId(String no) {
        return expressDao.getExpressId(no);
    }
}
