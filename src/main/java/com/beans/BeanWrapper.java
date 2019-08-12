package com.beans;

import com.core.FactoryBean;
/**
 * Created by Tom on 2018/4/21.
 */
public class BeanWrapper extends FactoryBean {




    private Object wrapperInstance;
    //原始的通过反射new出来，要把包装起来，存下来
    private Object originalInstance;

    public BeanWrapper(Object instance){
        //从这里开始，我们要把动态的代码添加进来了
        this.originalInstance = instance;
    }

    public Object getWrappedInstance(){
        return this.wrapperInstance;
    }


    // 返回代理以后的Class
    // 可能会是这个 $Proxy0
    public Class<?> getWrappedClass(){
        return this.wrapperInstance.getClass();
    }


    public Object getOriginalInstance() {
        return originalInstance;
    }
}
