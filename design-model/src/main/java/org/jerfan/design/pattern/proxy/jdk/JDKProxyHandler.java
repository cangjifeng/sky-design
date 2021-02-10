package org.jerfan.design.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类,实现 jdk的 InvocationHandler 接口，并实现 invoke 方法。
 * @author 08011390
 * @since 2021/2/9
 */
public class JDKProxyHandler implements InvocationHandler {



    private Object object;



    public JDKProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑增强: "+proxy.getClass().getName()+"#"+method.getName()+"，");
        Object rs =method.invoke(object,args);
        System.out.println("买家后做一些事情，如装修");
        return rs;
    }
}
