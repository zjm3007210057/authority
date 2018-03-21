package com.authority.mapper;

import com.authority.model.db.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zjm on 23/12/2017.
 */
@Mapper
public interface SysUserMapper {

    /**
     * 插入数据
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 更新数据
     * @param sysUser
     * @return
     */
    int update(SysUser sysUser);

    /**
     * 根据id列表删除
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysUser findById(int id);

    /**
     * 查询所有记录
     * @return
     */
    List<SysUser> findAll();

    /**
     * 根据关键值查询
     * @param keyword 关键字，可以为邮箱、用户名或者手机号
     * @return
     */
    SysUser findByKeyword(String keyword);

    /**
     * 根据邮箱查询记录，更新的时候会传入id
     * @param mail 邮箱
     * @param id 主键
     * @return
     */
    int countByMail(@Param(value = "mail")String mail, @Param(value = "id")int id);

    /**
     * 根据手机号查询记录，更新的时候会传入id
     * @param phoneNo 手机号
     * @param id 主键
     * @return
     */
    int countByPhoneNo(@Param(value = "phoneNo")String phoneNo, @Param(value = "id")int id);

    /**
     * 根据部门ID查询记录数
     * @param deptId 部门ID
     * @return
     */
    int countByDeptId(@Param("deptId") int deptId);

    /**
     * 分解部门ID查询特定的记录
     * @param deptId 部门ID
     * @param start 查询起始下标
     * @param pageSize 查询的总量
     * @return
     */
    List<SysUser> getPageByDeptId(@Param("deptId") int deptId, @Param("start") int start, @Param("pageSize") int pageSize);
}
