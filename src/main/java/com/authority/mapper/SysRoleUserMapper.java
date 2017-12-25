package com.authority.mapper;

import com.authority.model.db.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zjm on 23/12/2017.
 */
@Mapper
public interface SysRoleUserMapper {

    /**
     * 插入数据
     * @param sysRoleUser
     * @return
     */
    int insert(SysRoleUser sysRoleUser);

    /**
     * 更新数据
     * @param sysRoleUser
     * @return
     */
    int update(SysRoleUser sysRoleUser);

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
    SysRoleUser findById(int id);

    /**
     * 查询所有记录
     * @return
     */
    List<SysRoleUser> findAll();
}
