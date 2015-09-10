package com.xgtongcheng.xgexpress.express.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.express.entity.ExpressProcess;

import java.util.List;

/**
 * Created by WWX on 2015/9/2.
 */
@MyBatisDao
public interface ExpressProcessDao {
    public ExpressProcess getByExpId(String expId);

    public void add(ExpressProcess expressProcess);

    public String getByExpIdState(String expId,String State);

    public List<ExpressProcess> getProcesses(String expId,String bgnDate,String endDate);

    public List<ExpressProcess> getProcessesByExpId(String expId);
}
