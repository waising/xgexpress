package com.xgtongcheng.xgexpress.user.web.controller;

import com.xgtongcheng.xgexpress.user.dao.UserDao;
import com.xgtongcheng.xgexpress.user.entity.User;
import com.xgtongcheng.xgexpress.user.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public String users(ModelMap map){
        List<User> list = userService.getUsers();
        System.out.println(list.size());
        logger.info("111111111111111111111111111111111111");
        map.addAttribute("users",list);
        return "index";
    }

    @RequestMapping(value = "/{id}")
    public String user(ModelMap map,@PathVariable(value="id") String id){
        User user = userService.getUser(id);
        map.addAttribute("user",user);
        return "index";
    }
}
