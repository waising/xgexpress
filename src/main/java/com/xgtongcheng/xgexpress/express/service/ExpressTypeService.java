package com.xgtongcheng.xgexpress.express.service;

import com.xgtongcheng.xgexpress.express.entity.ExpressType;

/**
 * Created by WWX on 2015/9/2.
 */
public interface ExpressTypeService {
    public ExpressType get(String id);
    public void add(ExpressType expressType);
}
