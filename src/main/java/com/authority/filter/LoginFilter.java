package com.authority.filter;

import com.authority.common.RequestHolder;
import com.authority.model.db.SysUser;
import com.authority.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截用户登录，将用户信息和请求添加到ThreadLocal方便以后使用
 * Created by zjm on 21/03/2018.
 */
public class LoginFilter implements Filter{

    /**
     * 日志记录
     */
    private final static Logger log = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * @see Filter#init(FilterConfig)
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        SysUser user = (SysUser)req.getSession().getAttribute("user");
        if(ObjectUtils.isNull(user)){
            String path = "/signin.jsp";
            res.sendRedirect(path);
            return;
        }
        //将用户信息和http请求添加到ThreadLocal
        RequestHolder.add(user);
        RequestHolder.add(req);
        //继续执行逻辑
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {

    }
}
