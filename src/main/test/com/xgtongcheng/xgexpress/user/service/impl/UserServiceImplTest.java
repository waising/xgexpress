package com.xgtongcheng.xgexpress.user.service.impl;

import com.xgtongcheng.xgexpress.user.service.UserService;
import groovy.ui.SystemOutputInterceptor;
import org.apache.poi.util.SystemOutLogger;
import org.h2.constant.SysProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

    private UserService userService;
    @org.junit.Before
    public void setUp() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring-context.xml"
                ,"classpath:mybatis/user/UserDao.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetUser() throws Exception {
        System.out.println(userService.getUser().getName());
    }
}