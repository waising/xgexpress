package com.xgtongcheng.xgexpress.express.service;

import com.xgtongcheng.xgexpress.express.entity.ExpressProcess;

import java.util.List;

/**
 * Created by WWX on 2015/9/2.
 */
public interface ExpressProcessService {
    public ExpressProcess getByExpId(String expId);

    public void add(ExpressProcess expressProcess);

    public String getByExpIdState(String expId,String state);

    public List<ExpressProcess> getProcesses(String expId,String bgnDate,String endDate);

    public List<ExpressProcess> getProcessesByExpId(String expId);
}
