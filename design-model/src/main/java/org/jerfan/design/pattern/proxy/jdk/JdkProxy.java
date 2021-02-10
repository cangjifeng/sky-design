package org.jerfan.design.pattern.proxy.jdk;

import org.jerfan.design.pattern.proxy.server.BuyHouse;
import org.jerfan.design.pattern.proxy.server.DefaultBuyHouseService;
import org.jerfan.design.pattern.proxy.server.ManBuyHouseService;

import java.lang.reflect.Proxy;

/**
 * jdk 代理演示调用
 * @author 08011390
 * @since 2021/2/9
 */
public class JdkProxy {

    public static void main(String[] args) {


        BuyHouse manBuyHouseService = new ManBuyHouseService();
        BuyHouse proxy = (BuyHouse)Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class}, new JDKProxyHandler(manBuyHouseService)
        );
        System.out.println("get proxy object ...");

        Object rs = proxy.buyerHouse("linux");
        System.out.println("                         "+rs);
        System.out.println("---------------------------");
        BuyHouse DefaultBuyHouseService = new DefaultBuyHouseService();

        proxy = (BuyHouse)Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class}, new JDKProxyHandler(DefaultBuyHouseService)
        );
        rs = proxy.buyerHouse("lg");
        System.out.println("                         "+rs);

        System.out.println(".........  end");
    }
}
