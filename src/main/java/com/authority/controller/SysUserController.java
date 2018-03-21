package com.authority.controller;

import com.authority.common.BaseResponse;
import com.authority.model.db.SysUser;
import com.authority.model.dto.UserDO;
import com.authority.model.info.PageInfo;
import com.authority.param.PageParam;
import com.authority.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户controller
 * Created by zjm on 18/01/2018.
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户新增
     * @param userDO
     * @return
     */
    @RequestMapping("/save.json")
    @ResponseBody
    public BaseResponse saveUser(UserDO userDO){
        sysUserService.save(userDO);
        return BaseResponse.success();
    }

    /**
     * 用户更新
     * @param userDO
     * @return
     */
    @RequestMapping("/update.json")
    @ResponseBody
    public BaseResponse updateUser(UserDO userDO){
        sysUserService.update(userDO);
        return BaseResponse.success();
    }

    @RequestMapping("/user.page")
    public ModelAndView page() {
        return new ModelAndView("user");
    }

    @RequestMapping("page.json")
    @ResponseBody
    public BaseResponse pageJson(@RequestParam("deptId") int depId, PageParam pageParam){
        PageInfo<SysUser> pageInfo = sysUserService.getPageByDeptId(depId, pageParam);
        return new BaseResponse(pageInfo);
    }
}
