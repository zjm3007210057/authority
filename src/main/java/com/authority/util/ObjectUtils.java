package com.authority.util;

/**
 * 对象判断null工具类
 * Created by zjm on 22/12/2017.
 */
public class ObjectUtils {

    /**
     * 判断对象是否为空
     * @param object 判断的对象
     * @return
     */
    public static boolean isNull(Object object){
        if(object == null){
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否非空
     * @param object 判断的对象
     * @return
     */
    public static boolean isNotNull(Object object){
        return !isNull(object);
    }
}
