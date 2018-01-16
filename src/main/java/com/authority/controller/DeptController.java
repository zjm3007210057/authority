package com.authority.controller;

import com.authority.common.BaseResponse;
import com.authority.model.dto.DeptDO;
import com.authority.model.dto.DeptLevelDO;
import com.authority.service.DeptService;
import com.authority.service.SysTreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 部门controller
 * Created by zjm on 08/01/2018.
 */
@RestController
@RequestMapping("/sys/dept")
public class DeptController {

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    /**
     * 部门服务类
     */
    @Autowired
    private DeptService deptService;

    /**
     * 树处理服务
     */
    @Autowired
    private SysTreeService sysTreeService;

    @RequestMapping("/dept.page")
    public ModelAndView page() {
        return new ModelAndView("dept");
    }

    /**
     * 部门新增
     * @param deptDO
     * @return
     */
    @RequestMapping("/save.json")
    public BaseResponse saveDept(DeptDO deptDO){
        deptService.save(deptDO);
        return BaseResponse.success();
    }

    /**
     * 获取部门树
     * @return
     */
    @RequestMapping("/tree.json")
    public BaseResponse tree(){
        List<DeptLevelDO> levelDOS = sysTreeService.deptTree();
        return new BaseResponse(levelDOS);
    }

    @RequestMapping("/update.json")
    public BaseResponse update(DeptDO deptDO){
        deptService.update(deptDO);
        return BaseResponse.success();
    }

}
