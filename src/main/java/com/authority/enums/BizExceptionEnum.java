package com.authority.enums;

/**
 * Created by zjm on 19/12/2017.
 */
public enum BizExceptionEnum implements BaseEnum<BizExceptionEnum> {

    /**
     * 权限异常
     */
    PERMISSION_EROOR("000010", "权限异常"),

    ;

    /**
     * code
     */
    private String code;

    /**
     * 描述
     */
    private String description;

    /**
     * 构造函数
     * @param code
     * @param description
     */
    BizExceptionEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据code获取enum
     * @param code
     * @return
     */
    public BizExceptionEnum getByCode(String code){
        for(BizExceptionEnum bz : BizExceptionEnum.values()){
            if(bz.getCode().equals(code)){
                return bz;
            }
        }
        return null;
    }

    /**
     * @see BaseEnum#getCode()
     * @return
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @see BaseEnum#getDescription()
     * @return
     */
    public String getDescription() {
        return this.description;
    }
}
