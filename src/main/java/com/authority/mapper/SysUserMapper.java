package com.authority.mapper;

import com.authority.model.db.SysUser;
import org.apache.ibatis.annotations.Mapper;

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
}
