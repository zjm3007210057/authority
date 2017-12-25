package com.authority.mapper;

import com.authority.model.db.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zjm on 22/12/2017.
 */
@Mapper
public interface SysDeptMapper {

    /**
     * 插入数据
     * @param sysDept
     * @return
     */
    int insert(SysDept sysDept);

    /**
     * 更新
     * @param sysDept
     * @return
     */
    int update(SysDept sysDept);

    /**
     * 根据id列表删除
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    SysDept findById(int id);

    /**
     * 查询所有的部门
     * @return
     */
    List<SysDept> findAll();

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    SysDept findByName(String name);
}
