package com.xgtongcheng.xgexpress.user.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.user.entity.User;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
@MyBatisDao
public interface UserDao {
    public User getUser(String id);
    public List<User> getUsers();
}
