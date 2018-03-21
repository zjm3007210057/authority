package com.authority.common;

import com.authority.model.db.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 将各个线程request信息分别放置在各线程方便存取且为线程安全
 * Created by zjm on 21/03/2018.
 */
public class RequestHolder {

    /**
     * 单个线程用户信息
     */
    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();

    /**
     * 单个线程的http请求
     */
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    /**
     * 将用户信息添加到自己的线程当中
     * @param sysUser
     */
    public static void add(SysUser sysUser){
        userHolder.set(sysUser);
    }

    /**
     * 将http请求添加到自己的线程当中
     * @param request
     */
    public static void add(HttpServletRequest request){
        requestHolder.set(request);
    }

    /**
     * 获取单独线程的用户信息
     * @return
     */
    public static SysUser getSysUser(){
        return userHolder.get();
    }

    /**
     * 获取单独线程的http请求
     * @return
     */
    public static HttpServletRequest getHttpServletRequest(){
        return requestHolder.get();
    }

    /**
     * 每个线程结束后做移除，以免一直占用内存最后导致内存溢出
     */
    public static void remove(){
        userHolder.remove();
        requestHolder.remove();
    }
}
