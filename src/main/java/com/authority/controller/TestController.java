package com.authority.controller;

import com.authority.common.BaseResponse;
import com.authority.ex.PermissionException;
import com.authority.param.TestVo;
import com.authority.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by zjm on 13/12/2017.
 */
@RestController
@RequestMapping("")
public class TestController {

    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/hello.json", method = RequestMethod.GET)
    public BaseResponse hello(){
        throw new PermissionException("test exception");
//        return new BaseResponse("hello, privilege");
    }

    @RequestMapping(value = "/valid.json", method = RequestMethod.GET)
    public BaseResponse validate(TestVo vo){
//        BeanValidator.check(vo);
        return new BaseResponse("test validate");
    }

}
