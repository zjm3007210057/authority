package com.authority.mapper;

import com.authority.model.db.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zjm on 23/12/2017.
 */
@Mapper
public interface SysRoleMapper {

    /**
     * 插入数据
     * @param sysRole
     * @return
     */
    int insert(SysRole sysRole);

    /**
     * 更新数据
     * @param sysRole
     * @return
     */
    int update(SysRole sysRole);

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
    SysRole findById(int id);

    /**
     * 查询所有记录
     * @return
     */
    List<SysRole> findAll();
}
