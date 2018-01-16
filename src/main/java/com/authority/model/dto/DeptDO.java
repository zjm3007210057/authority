package com.authority.model.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zjm on 08/01/2018.
 */
public class DeptDO {

    /**
     * id
     */
    private int id;

    /**
     * 名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Length(max = 15, min = 2, message = "部门名称需要在2到15个字符之间")
    private String name;

    /**
     * 父级id
     */
    private int parentId;

    /**
     * 部门在当前层级下的顺序，由小到大，默认为0
     */
    private int seq;

    /**
     * 说明
     */
    private String remark;

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
}
