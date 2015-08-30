package com.xgtongcheng.xgexpress.user.service.impl;

import com.xgtongcheng.xgexpress.user.dao.UserDao;
import com.xgtongcheng.xgexpress.user.entity.User;
import com.xgtongcheng.xgexpress.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(){}

    public User getUser(String id){
        return userDao.getUser(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
