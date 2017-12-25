package com.authority.mapper;

import com.authority.model.db.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zjm on 23/12/2017.
 */
@Mapper
public interface SysLogMapper {

    /**
     * 插入记录
     * @param sysLog
     * @return
     */
    int insert(SysLog sysLog);

    /**
     * 根据id查询记录
     * @param id
     * @return
     */
    SysLog findById(int id);

    /**
     * 查询所有记录
     * @return
     */
    List<SysLog> findAll();
}
