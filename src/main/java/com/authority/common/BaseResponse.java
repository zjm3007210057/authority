package com.authority.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础返回结果
 * Created by zjm on 19/12/2017.
 */
public class BaseResponse {

    //请求成功状态码
    public static final String SUCCESS_CODE = "000000";

    //系统异常状态码
    public static final String SYSTEM_ERROR = "000999";

    /**
     * 请求成功信息
     */
    public static final String SUCCESS_MSG = "请求成功";

    /**
     * 系统异常信息
     */
    public static final String SYSTEM_ERROR_MSG = "系统异常";

    /**
     * 状态码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 无参构造函数
     */
    private BaseResponse() {
        this(SUCCESS_CODE, SUCCESS_MSG);
    }

    /**
     * 构造函数
     * @param code 状态码
     * @param msg 详细信息
     */
    public BaseResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造函数
     * @param code 状态码
     * @param msg 信息
     * @param data 数据
     */
    public BaseResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     * @param data
     */
    public BaseResponse(Object data) {
        this(SUCCESS_CODE, SUCCESS_MSG);
        this.data = data;
    }

    /**
     * 请求成功
     * @return
     */
    public static BaseResponse success(){
        return new BaseResponse();
    }

    /**
     * 系统异常请求返回
     * @return
     */
    public static BaseResponse systemError(){
        return new BaseResponse(SYSTEM_ERROR, SYSTEM_ERROR_MSG);
    }

    /**
     * 将对象转成map
     * @return
     */
    public Map<String, Object> toMap() {
        Map<String, Object> res = new HashMap<String, Object>(3);
        res.put("code", code);
        res.put("msg", msg);
        res.put("data", data);
        return res;
    }

    // get and set methods

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
