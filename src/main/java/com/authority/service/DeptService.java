package com.authority.service;

import com.authority.ex.BizException;
import com.authority.mapper.SysDeptMapper;
import com.authority.model.db.SysDept;
import com.authority.model.dto.DeptDO;
import com.authority.util.BeanValidator;
import com.authority.util.LevelUtils;
import com.authority.util.ObjectUtils;
import com.google.common.base.Preconditions;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 部门服务类
 * Created by zjm on 08/01/2018.
 */
@Service
public class DeptService {

    /**
     * 部门数据库操作mapper
     */
    @Autowired
    private SysDeptMapper deptMapper;

    /**
     * 插入数据
     * @param deptDO
     */
    public void save(DeptDO deptDO){
        BeanValidator.check(deptDO);
        if(checkExist(deptDO.getParentId(), deptDO.getName(), deptDO.getId())){
            throw new BizException("同一层级下出现相同的部门");
        }
        SysDept dept = convertToDo(deptDO);
        //todo 修改ip和操作员
        dept.setOperateIp("127.0.0.1");
        dept.setOperator("system");
        dept.setOperateTime(new Date());
        deptMapper.insert(dept);
    }

    /**
     * 验证部门是否存在
     * @param parentId 父级部门id
     * @param deptName 部门名称
     * @param deptId 部门id
     * @return
     */
    private boolean checkExist(int parentId, String deptName, Integer deptId){
        return deptMapper.countByNameAndParentId(parentId, deptName, deptId) > 0;
    }

    /**
     * 获取level
     * @param deptId
     * @return
     */
    private String getLevel(Integer deptId){
        SysDept dept = deptMapper.findById(deptId);
        if(ObjectUtils.isNull(dept)){
            return null;
        }
        return dept.getLevel();
    }

    /**
     * 部门更新
     * @param deptDO
     */
    public void update(DeptDO deptDO) {
        BeanValidator.check(deptDO);
        if(checkExist(deptDO.getParentId(), deptDO.getName(), deptDO.getId())){
            throw new BizException("同一层级下出现相同的部门");
        }
        SysDept before = deptMapper.findById(deptDO.getId());
        Preconditions.checkNotNull(before, "待更新的部门不存在");
        SysDept dept = convertToDo(deptDO);
        dept.setOperateIp("127.0.0.1");
        dept.setOperator("system");
        dept.setOperateTime(new Date());
    }

    /**
     * 更新子部门
     * @param before
     * @param after
     */
    @Transactional
    private void updateWithChild(SysDept before, SysDept after){
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if(!StringUtils.equals(after.getLevel(), before.getLevel())){
            List<SysDept> deptList = deptMapper.getChildDeptListByLevel(before.getLevel());
            if(CollectionUtils.isNotEmpty(deptList)){
                for(SysDept dept : deptList){
                    String level = dept.getLevel();
                    if(level.indexOf(oldLevelPrefix) == 0){
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                deptMapper.batchUpdateLevel(deptList);
            }
        }
        deptMapper.update(after);
    }

    /**
     * 领域模型转数据模型
     * @param deptDO
     * @return
     */
    private SysDept convertToDo(DeptDO deptDO){
        if(ObjectUtils.isNull(deptDO)){
            return null;
        }
        SysDept dept = new SysDept();
        dept.setParentId(deptDO.getParentId());
        dept.setSeq(deptDO.getSeq());
        dept.setRemark(deptDO.getRemark());
        dept.setName(deptDO.getName());
        dept.setLevel(LevelUtils.getLevel(getLevel(deptDO.getParentId()), deptDO.getParentId()));
        return dept;
    }
}
