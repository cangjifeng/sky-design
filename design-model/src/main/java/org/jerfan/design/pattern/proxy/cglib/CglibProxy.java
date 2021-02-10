package org.jerfan.design.pattern.proxy.cglib;

import org.jerfan.design.pattern.proxy.server.BuyHouse;
import org.jerfan.design.pattern.proxy.server.DefaultBuyHouseService;

/**
 * @author 08011390
 * @since 2021/2/10
 */
public class CglibProxy {


    public static void main(String[] args) {
        BuyHouse target = new DefaultBuyHouseService();

        Object r =target.buyerHouse("pre-zuul");
        System.out.println("r:"+r);

        CglibProxyHandler proxy = new CglibProxyHandler();

        DefaultBuyHouseService defaultBuyHouseService =(DefaultBuyHouseService)proxy.getInstance(target);

        Object rs =defaultBuyHouseService.buyerHouse("zuul");

        System.out.println("rs:"+rs);
        System.out.println("the end");
    }
}
