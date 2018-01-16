package com.authority.service;

import com.authority.mapper.SysDeptMapper;
import com.authority.model.db.SysDept;
import com.authority.model.dto.DeptLevelDO;
import com.authority.util.LevelUtils;
import com.authority.util.ObjectUtils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 计算树的服务
 * Created by zjm on 10/01/2018.
 */
@Service
public class SysTreeService {

    @Autowired
    private SysDeptMapper deptMapper;

    /**
     * 生成部门树
     * @return
     */
    public List<DeptLevelDO> deptTree(){
        List<SysDept> list = deptMapper.findAll();
        List<DeptLevelDO> deptLevelDOS = assembleList(list);
        return deptListToTree(deptLevelDOS);
    }

    /**
     * 生成树形结构
     * @param deptLevelDOS
     * @return
     */
    private List<DeptLevelDO> deptListToTree(List<DeptLevelDO> deptLevelDOS){
        if(CollectionUtils.isEmpty(deptLevelDOS)){
            return Collections.EMPTY_LIST;
        }
        Multimap<String, DeptLevelDO> levelDOMultiMap = ArrayListMultimap.create();
        List<DeptLevelDO> rootList = Lists.newArrayList();
        for(DeptLevelDO deptLevelDO : deptLevelDOS){
            levelDOMultiMap.put(deptLevelDO.getLevel(), deptLevelDO);
            if(LevelUtils.ROOT.equals(deptLevelDO.getLevel())){
                rootList.add(deptLevelDO);
            }
        }
        //按照seq从小到大排序
        Collections.sort(rootList, new Comparator<DeptLevelDO>() {
            public int compare(DeptLevelDO o1, DeptLevelDO o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });
        //递归生成树
        transformDeptTree(deptLevelDOS, LevelUtils.ROOT, levelDOMultiMap);
        return rootList;
    }

    /**
     * 递归生成树，转换成层级树形结构
     * @param deptLevelDOS
     * @param level
     * @param map
     */
    private void transformDeptTree(List<DeptLevelDO> deptLevelDOS, String level, Multimap<String, DeptLevelDO> map){
        if(CollectionUtils.isNotEmpty(deptLevelDOS)){
            for(DeptLevelDO deptLevelDO : deptLevelDOS){
                //处理当前层级的数据
                String nextLevel = LevelUtils.getLevel(level, deptLevelDO.getId());
                //处理下一层
                List<DeptLevelDO> tempDeptList = (List<DeptLevelDO>)map.get(nextLevel);
                if(CollectionUtils.isNotEmpty(tempDeptList)){
                    //排序
                    Collections.sort(tempDeptList, new Comparator<DeptLevelDO>() {
                        public int compare(DeptLevelDO o1, DeptLevelDO o2) {
                            return o1.getSeq() - o2.getSeq();
                        }
                    });
                    deptLevelDO.setDeptList(tempDeptList);
                    transformDeptTree(tempDeptList, nextLevel, map);
                }
            }
        }
    }

    /**
     * 数据模型list转领域模型list
     * @param list
     * @return
     */
    private List<DeptLevelDO> assembleList(List<SysDept> list){
        if(CollectionUtils.isNotEmpty(list)){
            List<DeptLevelDO> res = new ArrayList<DeptLevelDO>(list.size());
            for(SysDept sysDept : list){
                res.add(convertToDo(sysDept));
            }
            return res;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * 数据模型转领域模型
     * @param sysDept
     * @return
     */
    private DeptLevelDO convertToDo(SysDept sysDept){
        if(ObjectUtils.isNull(sysDept)){
            return null;
        }
        DeptLevelDO deptLevelDO = new DeptLevelDO();
        deptLevelDO.setId(sysDept.getId());
        deptLevelDO.setLevel(sysDept.getLevel());
        deptLevelDO.setName(sysDept.getName());
        deptLevelDO.setOperateIp(sysDept.getOperateIp());
        deptLevelDO.setOperateTime(sysDept.getOperateTime());
        deptLevelDO.setOperator(sysDept.getOperator());
        deptLevelDO.setParentId(sysDept.getParentId());
        deptLevelDO.setSeq(sysDept.getSeq());
        deptLevelDO.setRemark(sysDept.getRemark());
        return deptLevelDO;
    }

}
