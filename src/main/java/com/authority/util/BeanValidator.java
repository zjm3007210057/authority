package com.authority.util;

import com.authority.ex.BizException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * 校验工具类
 * Created by zjm on 20/12/2017.
 */
public class BeanValidator {

    /**
     * validator工厂
     */
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    /**
     * 校验
     * @param t 校验参数
     * @param groups 校验的类
     * @param <T> 校验不通过map，key为有问题的字段，value表示错误信息
     * @return
     */
    public static <T> Map<String, String> validate(T t, Class... groups){
        Validator validator = validatorFactory.getValidator();
        Set validateResult = validator.validate(t, groups);
        if(validateResult.isEmpty()){
            return Collections.emptyMap();
        }else {
            LinkedHashMap errors = Maps.newLinkedHashMap();
            Iterator iterator = validateResult.iterator();
            while(iterator.hasNext()){
                ConstraintViolation violation = (ConstraintViolation)iterator.next();
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }

    /**
     * 校验List
     * @param collection
     * @return
     */
    public static Map<String, String> validateList(Collection<?> collection){
        Preconditions.checkNotNull(collection);
        Iterator iterator = collection.iterator();
        Map errors;
        do{
            if(!iterator.hasNext()){
                return Collections.EMPTY_MAP;
            }
            Object object = iterator.next();
            errors = validate(object, new Class[0]);
        }while(errors.isEmpty());

        return errors;
    }

    /**
     * 校验任何对象
     * @param first
     * @param objects
     * @return
     */
    public static Map<String, String> validateObject(Object first, Object... objects){
        if(objects != null && objects.length >0){
            return validateList(Lists.asList(first, objects));
        }else {
            return validate(first, new Class[0]);
        }
    }

    /**
     * 校验参数
     * @param param 参数
     * @throws BizException
     */
    public static void check(Object param) throws BizException{
        Map<String, String> map = BeanValidator.validateObject(param);
        if(MapUtils.isNotEmpty(map)){
            throw new BizException(map.toString());
        }
    }
}
