package com.xgtongcheng.xgexpress.user.dao;

import com.xgtongcheng.xgexpress.common.annotation.MyBatisDao;
import com.xgtongcheng.xgexpress.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
@Repository
@MyBatisDao
public interface UserDao{
    public List<User> getUser();
}
