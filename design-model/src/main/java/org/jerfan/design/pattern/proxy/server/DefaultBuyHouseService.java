package org.jerfan.design.pattern.proxy.server;


/**
 * BuyHouse的一个实现，中介帮操作买房
 * @author 08011390
 * @since 2021/2/9
 */
public class DefaultBuyHouseService implements BuyHouse {

    @Override
    public Object buyerHouse(String name) {
        String who ="中介帮"+name;
        System.out.println(who+"买房了☆☆☆☆☆☆☆☆☆☆☆☆");
        return who+"买房成功";
    }
}
