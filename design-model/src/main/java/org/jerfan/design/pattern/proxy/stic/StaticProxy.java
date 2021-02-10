package org.jerfan.design.pattern.proxy.stic;

import org.jerfan.design.pattern.proxy.server.BuyHouse;
import org.jerfan.design.pattern.proxy.server.ManBuyHouseService;

/**
 * @author 08011390
 * @since 2021/2/10
 */
public class StaticProxy {


    public static void main(String[] args) {
        BuyHouse target = new ManBuyHouseService();

        StaticBuyHouseProxyHandler proxy = new StaticBuyHouseProxyHandler(target);

        Object rs = proxy.buyerHouse("bill");

        System.out.println("rs"+rs);
        System.out.println("the end");
    }
}
