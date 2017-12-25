package com.authority.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用户数据库模型
 * Created by zjm on 15/12/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysUser {

    /**
     * 主键id
     */
    private int id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门id
     */
    private int deptId;

    /**
     * 状态，1表示正常，2表示冻结，3表示删除
     */
    private int status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 最后一次操作者的ip
     */
    private String operateIp;

    /**
     * 最后一次的更新时间
     */
    private Date operateTime;

    //get and set methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
