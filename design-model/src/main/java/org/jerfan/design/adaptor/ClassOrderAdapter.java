package org.jerfan.design.adaptor;

import org.jerfan.design.api.CloudOrderService;
import org.jerfan.design.bean.OrderBean;
import org.jerfan.design.bean.TradeOrderBean;
import org.jerfan.design.impl.DubboOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * 类适配模式，通过集成模式实现
 * 使用场景：OrderController，原先是使用CloudOrderService 想要使用DubboOrderService的行为，但是又不想活在不能改变其代码
 * ClassOrderAdapter 直接继承DubboOrderServiceImpl，同时重写CloudOrderService的方法(在重新方法内部调用DubboOrderService的行为)
 * @author jerfan.cang
 * @date 2019/8/28  10:31
 */
@Service(value = "classOrderAdapter")
public class ClassOrderAdapter extends DubboOrderServiceImpl implements CloudOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassOrderAdapter.class);

    /**
     * 适配器模式-类适配（类适配模式的缺点返回值类型必须是 CloudOrderService 接口中的类型）
     * 目的是准备使用 cloud order create 接口去创建订单，但是 cloud order create 接口不能兼容
     * @param tradeOrderBean TradeOrderBean
     * @return TradeOrderBean
     */
    @Override
    public TradeOrderBean orderCreate(TradeOrderBean tradeOrderBean) {
        LOGGER.info("class adapter model --  order server");

        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo(tradeOrderBean.getOrderNo());
        orderBean.setOrderStatus(tradeOrderBean.getOrderType());
        orderBean.setOrderType(tradeOrderBean.getOrderType());
        orderBean = super.orderCreate(orderBean);
        tradeOrderBean.setOrderStatus(orderBean.getOrderStatus());
        tradeOrderBean.setOrderType(orderBean.getOrderType());
        return tradeOrderBean;
    }

    /**
     * 把这个接口
     * @param orderBean OrderBean
     * @return OrderBean
     */
    public OrderBean adapterOrderCreate(OrderBean orderBean){
        TradeOrderBean tradeOrderBean = new TradeOrderBean();
        tradeOrderBean.setOrderNo(orderBean.getOrderNo());
        tradeOrderBean.setOrderStatus(orderBean.getOrderStatus());
        tradeOrderBean.setOrderType(orderBean.getOrderType());
        tradeOrderBean=this.orderCreate(tradeOrderBean);
        orderBean.setOrderNo(tradeOrderBean.getOrderNo());
        orderBean.setOrderStatus(tradeOrderBean.getOrderType());
        orderBean.setOrderType(tradeOrderBean.getOrderType());
        return orderBean;
    }

}
