package com.authority.mapper;

import com.authority.model.db.SysAclModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zjm on 23/12/2017.
 */
@Mapper
public interface SysAclModuleMapper {

    /**
     * 插入数据
     * @param sysAclModule
     * @return
     */
    int insert(SysAclModule sysAclModule);

    /**
     * 更新数据
     * @param sysAclModule
     * @return
     */
    int update(SysAclModule sysAclModule);

    /**
     * 根据id列表进行删除
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysAclModule findById(int id);

    /**
     * 查询所有的记录
     * @return
     */
    List<SysAclModule> findAll();
}
