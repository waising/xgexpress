package com.xgtongcheng.xgexpress.user.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xgtongcheng.xgexpress.user.entity.User;
import com.xgtongcheng.xgexpress.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by WWX on 2015/04/24.
 */
@Controller
@RequestMapping(value = "aaa")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @RequestMapping(value = "/sss")
    public String index(ModelMap map){
        List<User> list = userService.getUser();
        System.out.println(list.size());
        logger.info("111111111111111111111111111111111111");
        map.addAttribute("user",list.get(0));
        return "index";
    }

    @RequestMapping(value = "/list")
    public String users(ModelMap map,int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.getUser();
        System.out.println(list.size());
        logger.info("Total:"+((Page)list).getTotal());
        map.addAttribute("user",list.get(0));
        return "index";
    }
}
