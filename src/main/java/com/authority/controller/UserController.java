package com.authority.controller;

import com.authority.model.db.SysUser;
import com.authority.service.SysUserService;
import com.authority.util.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户自己做相关操作的controller
 * Created by zjm on 22/01/2018.
 */
@Controller
public class UserController {

    @Autowired
    private SysUserService userService;

    /**
     * 用户登录
     * @param req
     * @param res
     */
    @RequestMapping("/login.page")
    public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String ret = req.getParameter("ret");
        StringBuilder errorMsg = new StringBuilder();
        SysUser user = userService.findByKeyword(username);
        if(StringUtils.isBlank(username)){
            errorMsg.append("用户名不能为空;");
        }else if(StringUtils.isBlank(password)){
            errorMsg.append("密码不能为空;");
        }else if(ObjectUtils.isNull(user)){
            errorMsg.append("查不到指定的用户;");
        }else if(!StringUtils.equals(user.getPassword(), password)){
            errorMsg.append("用户名或者密码不对;");
        }else if(user.getStatus() != 1){
            errorMsg.append("用户已冻结，请联系管理员；");
        }else{
            req.getSession().setAttribute("user", user);
            if(StringUtils.isNotBlank(ret)){
                res.sendRedirect(ret);
            }else {
                res.sendRedirect("/admin/index.page");
            }
        }
        if(StringUtils.isNotBlank(ret)){
            req.setAttribute("ret", ret);
        }
        req.setAttribute("error", errorMsg.toString());
        req.setAttribute("username", username);
        String path = "signin.jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }

    /**
     * 退出登录，直接把session失效即可
     */
    @RequestMapping("/logout.page")
    public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        req.getSession().invalidate();
        String path = "signin.jsp";
        res.sendRedirect(path);
    }
}
