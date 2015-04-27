package com.xgtongcheng.xgexpress.user.dao;

import com.xgtongcheng.xgexpress.user.entity.User;
import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
@Repository
public interface UserDao extends MyBatisDao{
    public List<User> getUser();
}
