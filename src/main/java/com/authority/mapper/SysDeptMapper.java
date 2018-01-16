package com.authority.mapper;

import com.authority.model.db.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据level获取子部门list
     * @param level
     * @return
     */
    List<SysDept> getChildDeptListByLevel(String level);

    /**
     * 批量更新部门列表
     * @param list
     */
    void batchUpdateLevel(List<SysDept> list);

    /**
     * 根据名称和parentId查询记录数
     * @param parentId 父级部门id
     * @param name 部门name
     * @param id id
     * @return
     */
    int countByNameAndParentId(@Param("parentId")int parentId, @Param("name") String name, @Param("id") Integer id);
}
