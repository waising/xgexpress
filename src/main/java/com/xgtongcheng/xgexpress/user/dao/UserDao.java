package com.xgtongcheng.xgexpress.user.dao;

import com.xgtongcheng.xgexpress.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by WWX on 2015/04/24.
 */
@Repository
public interface UserDao{
    public User getUser();
}
