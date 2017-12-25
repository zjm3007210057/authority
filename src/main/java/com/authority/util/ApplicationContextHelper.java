package com.authority.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by zjm on 22/12/2017.
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    /**
     * spring 上下文
     */
    private static ApplicationContext applicationContext;

    /**
     * @see ApplicationContextAware#setApplicationContext(ApplicationContext)
     * @param context
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /**
     * 获取spring上下文里面的bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        if(ObjectUtils.isNull(applicationContext)){
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    /**
     * 获取spring上下文里面Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz){
        if(ObjectUtils.isNull(applicationContext)){
            return null;
        }
        return applicationContext.getBean(name, clazz);
    }
}
