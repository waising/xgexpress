package com.xgtongcheng.xgexpress.employee.entity;

import org.springframework.stereotype.Component;

/**
 * Created by WWX on 2015/9/1.
 */
@Component
public class Employee {

    private String id;

    /**
     * π§∫≈
     */
    private String jobNo;

    /**
     * –’√˚
     */
    private String name;

    /**
     * √‹¬Î
     */
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
