package com.xgtongcheng.xgexpress.express.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.express.entity.Express;

import java.util.List;

/**
 * Created by WWX on 2015/9/2.
 */
@MyBatisDao
public interface ExpressDao {
    public Express get(String id);

    public List<Express> getExpresses();

    public void add(Express express);

    public String getExpressId(String no);
}
