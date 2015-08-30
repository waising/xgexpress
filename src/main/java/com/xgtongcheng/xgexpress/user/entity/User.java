package com.xgtongcheng.xgexpress.user.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by WWX on 2015/04/24.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -4415990281535582814L;

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String name;
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
