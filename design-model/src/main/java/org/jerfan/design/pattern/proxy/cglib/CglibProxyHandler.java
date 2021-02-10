package org.jerfan.design.pattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 08011390
 * @since 2021/2/10
 */
public class CglibProxyHandler implements MethodInterceptor {


    /**
     * 代理对象，是一个实例，不是接口
     */
    private Object target;

    public Object getInstance(final Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxyHandler#intercept,前置增强");
        Object rs = methodProxy.invoke(target,args);
        System.out.println("CglibProxyHandler#intercept,后置增强");
        return rs;
    }
}
