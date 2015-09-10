package com.xgtongcheng.xgexpress.express.service.impl;

import com.xgtongcheng.xgexpress.express.dao.ExpressProcessDao;
import com.xgtongcheng.xgexpress.express.entity.ExpressProcess;
import com.xgtongcheng.xgexpress.express.service.ExpressProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WWX on 2015/9/2.
 */
@Service
public class ExpressProcessServiceImpl implements ExpressProcessService {

    @Autowired
    ExpressProcessDao expressProcessDao;

    public ExpressProcess getByExpId(String expId) {
        return expressProcessDao.getByExpId(expId);
    }

    public void add(ExpressProcess expressProcess) {
        expressProcessDao.add(expressProcess);
    }

    public String getByExpIdState(String expId, String state) {
        return expressProcessDao.getByExpIdState(expId,state);
    }

    public List<ExpressProcess> getProcesses(String expId, String bgnDate, String endDate) {
        return expressProcessDao.getProcesses(expId,bgnDate,endDate);
    }

    public List<ExpressProcess> getProcessesByExpId(String expId) {
        return expressProcessDao.getProcessesByExpId(expId);
    }
}
