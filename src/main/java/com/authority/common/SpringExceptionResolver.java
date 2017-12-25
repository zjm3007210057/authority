package com.authority.common;

import com.authority.enums.BizExceptionEnum;
import com.authority.ex.BizException;
import com.authority.ex.PermissionException;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 * Created by zjm on 19/12/2017.
 */
public class SpringExceptionResolver implements HandlerExceptionResolver {

    /**
     * 日志记录
     */
    private Logger log = LoggerFactory.getLogger(SpringExceptionResolver.class);

    /**
     * @see HandlerExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)
     * 处理异常
     * @param request
     * @param response
     * @param handler
     * @param e
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        String url = request.getRequestURI().toString();
        ModelAndView mv;

        //根据后缀判断请求属于json请求还是页面请求，.json, .page
        if(url.endsWith(".json")){
            if(e instanceof PermissionException || e instanceof BizException){
                BaseResponse result = new BaseResponse(BizExceptionEnum.PERMISSION_EROOR.getCode(), BizExceptionEnum.PERMISSION_EROOR.getDescription());
                mv = new ModelAndView("jsonView", result.toMap());
            }else{
                log.error("unknown json exception, url: " + url, e);
                BaseResponse result = BaseResponse.systemError();
                mv = new ModelAndView("jsonView", result.toMap());
            }
        }else if(url.endsWith(".page")) {
            log.error("unknown page exception, url: " + url, e);
            BaseResponse result = BaseResponse.systemError();
            mv = new ModelAndView("exception", result.toMap());
        }else {
            log.error("unknown json exception, url: " + url, e);
            BaseResponse result = BaseResponse.systemError();
            mv = new ModelAndView("jsonView", result.toMap());
        }
        return mv;
    }

}
