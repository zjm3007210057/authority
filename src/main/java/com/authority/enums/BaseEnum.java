package com.authority.enums;

/**
 * 枚举基类接口
 * Created by zjm on 19/12/2017.
 */
public interface BaseEnum<T extends BaseEnum> {

    /**
     * 获取code
     * @return
     */
    String getCode();

    /**
     * 获取描述信息
     * @return
     */
    String getDescription();
}
