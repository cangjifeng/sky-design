package org.jerfan.design.adaptor;

import org.jerfan.design.api.CloudOrderService;
import org.jerfan.design.api.DubboOrderService;
import org.jerfan.design.bean.OrderBean;
import org.jerfan.design.bean.TradeOrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象适配模式，采用组合方式实现
 * @author jerfan.cang
 * @date 2019/8/28  11:27
 */
@Service(value = "instanceOrderAdapter")
public class InstanceOrderAdapter implements CloudOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceOrderAdapter.class);

    @Resource
    private DubboOrderService dubboOrderService;

    /**
     * 适配器模式-对象适配
     * @param tradeOrderBean TradeOrderBean
     * @return TradeOrderBean
     */
    @Override
    public TradeOrderBean orderCreate(TradeOrderBean tradeOrderBean) {
        LOGGER.info("instance adapter order create");
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo(tradeOrderBean.getOrderNo());
        orderBean.setOrderStatus(tradeOrderBean.getOrderStatus());
        orderBean.setOrderType(tradeOrderBean.getOrderType());
        orderBean=dubboOrderService.orderCreate(orderBean);

        tradeOrderBean.setOrderType(orderBean.getOrderType());
        tradeOrderBean.setOrderStatus(orderBean.getOrderStatus());
        return tradeOrderBean;
    }
}
