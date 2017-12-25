package com.authority.mapper;

import com.authority.model.db.SysAcl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zjm on 23/12/2017.
 */
@Mapper
public interface SysAclMapper {

    /**
     * 插入数据
     * @param sysAcl
     * @return
     */
    int insert(SysAcl sysAcl);

    /**
     * 更新数据
     * @param sysAcl
     * @return
     */
    int update(SysAcl sysAcl);

    /**
     * 根据id列表删除
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);

    /**
     * 查询所有的记录
     * @return
     */
    List<SysAcl> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysAcl findById(int id);
}
