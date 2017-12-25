package com.authority.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 角色权限关系数据库模型
 * Created by zjm on 15/12/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysRoleAcl {

    /**
     * 主键id
     */
    private int id;

    /**
     * 角色id
     */
    private int roleId;

    /**
     * 权限id
     */
    private int aclId;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 最后一次更新者的ip
     */
    private String operateIp;

    /**
     * 最后一次更新的时间
     */
    private Date operateTime;

    //get and set methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAclId() {
        return aclId;
    }

    public void setAclId(int aclId) {
        this.aclId = aclId;
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
