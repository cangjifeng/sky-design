package org.jerfan.design.api;

import org.jerfan.design.bean.OrderBean;

/**
 * 目标抽象类
 * 老业务的接口
 * @author jerfan.cang
 * @date 2019/8/28  10:06
 */
public interface DubboOrderService {

    /**
     * 创建订单
     * @param orderBean OrderBean
     * @return OrderBean
     */
    OrderBean orderCreate(OrderBean orderBean);
}
