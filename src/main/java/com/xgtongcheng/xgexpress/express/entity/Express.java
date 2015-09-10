package com.xgtongcheng.xgexpress.express.entity;

import com.xgtongcheng.xgexpress.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WWX on 2015/9/2.
 */
@Component
public class Express {

    private String id;
    /**
     * 单号
     */
    private String no;
    /**
     * 始发地
     */
    private String fromPlace;
    /**
     * 费用
     */
    private double price;
    /**
     * 员工
     */
    private Employee employee;
    /**
     * 目的地
     */
    private String toPlace;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 发送人收件人信息
     */
    private ExpressPeople expressPeople;

    /**
     * 快递种类 （普通，电商件，加急件，签收回单）
     */
    private ExpressType expressType;
    /**
     * 流程
     */
    private List<ExpressProcess> expProcesses;


    public ExpressPeople getExpressPeople() {
        return expressPeople;
    }

    public void setExpressPeople(ExpressPeople expressPeople) {
        this.expressPeople = expressPeople;
    }

    public ExpressType getExpressType() {
        return expressType;
    }

    public void setExpressType(ExpressType expressType) {
        this.expressType = expressType;
    }

    public List<ExpressProcess> getExpProcesses() {
        return expProcesses;
    }

    public void setExpProcessList(List<ExpressProcess> expProcesses) {
        this.expProcesses = expProcesses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
