package com.authority.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 部门层级领域模型
 * Created by zjm on 10/01/2018.
 */
public class DeptLevelDO {

    /**
     * 主键id
     */
    private int id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门父级id
     */
    private int parentId;

    /**
     * 部门的层级
     */
    private String level;

    /**
     * 部门在当前层级下的顺序，由小到大，默认为0
     */
    private int seq;

    /**
     * 备注
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
     * 最后一次操作员的ip
     */
    private String operateIp;

    /**
     * 部门层级list
     */
    private List<DeptLevelDO> deptList = new ArrayList<DeptLevelDO>();

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
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

    public List<DeptLevelDO> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<DeptLevelDO> deptList) {
        this.deptList = deptList;
    }
}
