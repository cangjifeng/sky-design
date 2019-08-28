package org.jerfan.design.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.jerfan.design.adaptor.ClassOrderAdapter;
import org.jerfan.design.adaptor.InstanceOrderAdapter;
import org.jerfan.design.api.CloudOrderService;
import org.jerfan.design.api.DubboOrderService;
import org.jerfan.design.bean.OrderBean;
import org.jerfan.design.bean.TradeOrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jerfan.cang
 * @date 2019/8/28  10:43
 */
@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private ClassOrderAdapter classOrderAdapter;

    @Resource
    private InstanceOrderAdapter instanceOrderAdapter;

    @Resource
    private DubboOrderService dubboOrderService;

    @Resource
    private CloudOrderService cloudOrderService;

    /**
     * 模拟类适配器使用，
     * 使用者：OrderController ，想要使用 dubboOrderService 接口中的的行为
     * 但是OrderController 又不能直接调用dubboOrderService，调用CloudOrderService
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/adapter-class/order/create",method = RequestMethod.GET)
    public OrderBean classAdapterCreateOrder(){

        LOGGER.info("adapter-class order create controller");
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo("adapter-class-2019-08-10-001");
        orderBean= classOrderAdapter.adapterOrderCreate(orderBean);
        return orderBean;
    }

    @ResponseBody
    @RequestMapping(value = "/adapter-instance/order/create",method = RequestMethod.GET)
    public TradeOrderBean instanceAdapterCreateOrder(){

        LOGGER.info("adapter-instance order create controller");
        TradeOrderBean tradeOrderBean = new TradeOrderBean();
        tradeOrderBean.setOrderNo("adapter-instance-2019-08-10-002");
        tradeOrderBean= instanceOrderAdapter.orderCreate(tradeOrderBean);
        return tradeOrderBean;
    }

    /**
     * 模拟云原生 订单创建 调用的是 cloud order
     * 但是上层没有进行告知，入参异常是OrderBean 回参依然是OrderBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cloud/order/create",method = RequestMethod.GET)
    public TradeOrderBean cloudCreateOrder(){

        LOGGER.info("cloud  order create controller");
        TradeOrderBean tradeOrderBean = new TradeOrderBean();
        tradeOrderBean.setOrderNo("cloud-2019-08-10-003");
        tradeOrderBean= cloudOrderService.orderCreate(tradeOrderBean);
        return tradeOrderBean;
    }

    /**
     * 模拟老中台创建订单接口 调用的是 dubbo order
     * 入参为 OrderBean 返回值为 OrderBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/dubbo/order/create",method = RequestMethod.GET)
    public OrderBean dubboCreateOrder(){

        LOGGER.info("dubbo order create controller");
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo("dubbo-2019-08-10-004");
        orderBean= dubboOrderService.orderCreate(orderBean);
        return orderBean;
    }
}
