package com.xgtongcheng.xgexpress.user.service;

import com.xgtongcheng.xgexpress.user.entity.User;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
public interface UserService {
    public User get(String id);
    public List<User> getUsers();
}
