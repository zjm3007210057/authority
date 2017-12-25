package com.authority.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 角色数据库模型
 * Created by zjm on 15/12/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysRole {

    /**
     * 主键id
     */
    private int id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色类型，1：管理员角色，2：其他
     */
    private int type;

    /**
     * 状态，1表示可用，2表示冻结
     */
    private int status;

    /**
     * 说明
     */
    private String remark;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    private String operateIp;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }
}
