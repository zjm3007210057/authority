package com.authority.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 级别工具类
 * Created by zjm on 22/12/2017.
 */
public class LevelUtils {

    /**
     * 点分隔符
     */
    public static final String SEPARATOR = ".";

    /**
     * root级别，最上一级
     */
    public static final String ROOT = "0";

    /**
     * 获取级别，比如：
     * 0
     * 0.1
     * 0.1.1
     * 0.2
     * 0.2.1
     * 0.2.1.1
     * @param parentLevel
     * @param parentId
     * @return
     */
    public static String getLevel(String parentLevel, int parentId){
        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
