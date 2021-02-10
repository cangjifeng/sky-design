package org.jerfan.design.pattern.proxy.server;


/**
 *
 * @author 08011390
 * @since 2021/2/9
 */
public class ManBuyHouseService implements BuyHouse {


    @Override
    public Object buyerHouse(String name) {
        String who=null==name?"无名氏":name;
        System.out.println("ManBuyHouseService#buyerHouse,"+who+"买房了......");
        return who +"买房成功";
    }
}
