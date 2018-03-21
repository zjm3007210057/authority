package com.authority.service;

import com.alibaba.fastjson.JSON;
import com.authority.common.RequestHolder;
import com.authority.ex.BizException;
import com.authority.mapper.SysUserMapper;
import com.authority.model.db.SysUser;
import com.authority.model.dto.UserDO;
import com.authority.model.info.PageInfo;
import com.authority.param.PageParam;
import com.authority.util.BeanValidator;
import com.authority.util.MD5Util;
import com.authority.util.ObjectUtils;
import com.authority.util.PasswordUtil;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户服务
 * Created by zjm on 18/01/2018.
 */
@Service
public class SysUserService {

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(SysUserService.class);

    /**
     * 用户数据库操作mapper
     */
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 新增用户
     * @param userDO
     */
    public void save(UserDO userDO){
        BeanValidator.check(userDO);
        if(checkPhoneExist(userDO.getPhoneNo(), userDO.getId())){
            throw new BizException("手机号已经被使用");
        }
        if(checkEmailExist(userDO.getMail(), userDO.getId())){
            throw new BizException("邮箱已经被使用");
        }
        String password = PasswordUtil.randomPassword();
        log.info("用户信息为： {}" + JSON.toJSONString(userDO) + "：明文密码为：" + password);
        System.out.println("用户信息为： {}" + JSON.toJSONString(userDO) + "：明文密码为：" + password);
        password = MD5Util.encrypt(password);
        SysUser sysUser = convert(userDO);
        sysUser.setPassword(password);
        sysUser.setOperateIp("127.0.0.1");
        sysUser.setOperator(RequestHolder.getSysUser().getName());
        sysUser.setOperateTime(new Date());
        //todo sendEmail notify user password
        userMapper.insert(sysUser);
    }

    /**
     * 更新用户
     * @param userDO
     */
    public void update(UserDO userDO){
        BeanValidator.check(userDO);
        if(checkPhoneExist(userDO.getPhoneNo(), userDO.getId())){
            throw new BizException("手机号已经被使用");
        }
        if(checkEmailExist(userDO.getMail(), userDO.getId())){
            throw new BizException("邮箱已经被使用");
        }
        SysUser beforUser = userMapper.findById(userDO.getId());
        Preconditions.checkNotNull(beforUser, "待更新的用户不存在");
        SysUser newUser = convert(userDO);
        newUser.setOperateIp("127.0.0.1");
        newUser.setOperator(RequestHolder.getSysUser().getName());
        newUser.setOperateTime(new Date());
        userMapper.update(newUser);
    }

    /**
     * 根据关键值查询
     * @param keyword 关键字，可以为邮箱、用户名或者手机号
     * @return
     */
    public SysUser findByKeyword(String keyword){
        return userMapper.findByKeyword(keyword);
    }

    /**
     * 用户领域模型转数据模型
     * @param userDO
     * @return
     */
    private SysUser convert(UserDO userDO) {
        if(ObjectUtils.isNull(userDO)){
            return null;
        }
        SysUser sysUser = new SysUser();
        sysUser.setDeptId(userDO.getDeptId());
        sysUser.setId(userDO.getId());
        sysUser.setMail(userDO.getMail());
        sysUser.setPhoneNo(userDO.getPhoneNo());
        sysUser.setStatus(userDO.getStatus());
        sysUser.setRemark(userDO.getRemark());
        sysUser.setPhoneNo(userDO.getPhoneNo());
        return sysUser;
    }

    /**
     * 验证手机号是否存在
     * @param phoneNo 手机号
     * @param userId 用户id
     * @return
     */
    private boolean checkPhoneExist(String phoneNo, int userId){
        return userMapper.countByPhoneNo(phoneNo, userId) > 0;
    }

    /**
     * 验证邮箱是否存在
     * @param email 邮箱
     * @param userId 用户id
     * @return
     */
    private boolean checkEmailExist(String email, int userId){
        return userMapper.countByMail(email, userId) > 0;
    }

    /**
     * 根据部门ID分页查询用户
     * @param deptId 部门ID
     * @param pageParam 分页参数
     * @return
     */
    public PageInfo<SysUser> getPageByDeptId(int deptId, PageParam pageParam){
        BeanValidator.check(pageParam);
        int count = userMapper.countByDeptId(deptId);
        if(count > 0){
            int start = (pageParam.getCurrentPage() - 1) * pageParam.getPageSize();
            int totalPage = count % pageParam.getPageSize() == 0 ? count / pageParam.getPageSize() : count / pageParam.getPageSize() + 1;
            List<SysUser> list = userMapper.getPageByDeptId(deptId, start, pageParam.getPageSize());
            PageInfo pageInfo = new PageInfo(pageParam.getCurrentPage(), pageParam.getPageSize());
            pageInfo.setOffset(start);
            pageInfo.setTotalNum(count);
            pageInfo.setTotalPage(totalPage);
            pageInfo.setData(list);
            return pageInfo;
        }
        return new PageInfo<SysUser>();
    }

}
