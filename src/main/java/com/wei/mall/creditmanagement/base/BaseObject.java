package com.wei.mall.creditmanagement.base;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;
import com.wei.mall.creditmanagement.config.SpringContext;

public abstract class BaseObject {
    public static Mapper getMapper(){
        DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = SpringContext.getBean(DozerBeanMapperFactoryBean.class);
        return dozerBeanMapperFactoryBean.getObject();
    }
}
