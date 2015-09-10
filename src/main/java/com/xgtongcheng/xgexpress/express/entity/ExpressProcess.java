package com.xgtongcheng.xgexpress.express.entity;

import org.springframework.stereotype.Component;

/**
 * Created by WWX on 2015/9/2.
 */
@Component
public class ExpressProcess {
    private String id;

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    private String expressId;
    /**
     * 快件状态（收件，分发，签收）
     */
    private String state;

    /**
     * 签收时间
     */
    private String signTime;

    /**
     * 签收状态（正常，异常）
     */
    private String signState;

    /**
     * 异常原因
     */
    private String abnormal;

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState;
    }

}
