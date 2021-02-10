package org.jerfan.design.pattern.proxy.stic;

import org.jerfan.design.pattern.proxy.server.BuyHouse;

/**
 *
 * 静态代理<br>
 *     实现要代理对象的接口，并持有一个代理对象的实现，在构造方法中接受一个代理对象的实例
 * @author 08011390
 * @since 2021/2/10
 */
public class StaticBuyHouseProxyHandler implements BuyHouse {

    private BuyHouse target;


    public StaticBuyHouseProxyHandler(BuyHouse target){
        this.target = target;
    }

    @Override
    public Object buyerHouse(String name) {
        // 做一些增强的功能
        System.out.println("StaticBuyHouseProxyHandler#buyerHouse,前置增强");
        Object rs =target.buyerHouse(name);
        System.out.println("StaticBuyHouseProxyHandler#buyerHouse,后置增强");

        return rs;
    }
}
