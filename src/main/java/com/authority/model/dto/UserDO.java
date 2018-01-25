package com.authority.model.dto;

import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户领域模型
 * Created by zjm on 18/01/2018.
 */
@ToString
public class UserDO {

    /**
     * 主键id
     */
    private int id;

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名不能为空")
    @Length(min = 1, max = 20, message = "用户名长度需要大于1并小于20")
    private String name;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String phoneNo;

    /**
     * 邮箱
     */
    private String mail;

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
}
