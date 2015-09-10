package com.xgtongcheng.xgexpress.express.entity;

import org.springframework.stereotype.Component;

/**
 * Created by WWX on 2015/9/2.
 */
@Component
public class ExpressType {
    private String id;
    /**
     * 类型 （普通，电商件，加急件，签收回单）
     */
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
