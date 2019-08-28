package org.jerfan.design.impl;

import org.jerfan.design.api.DubboOrderService;
import org.jerfan.design.bean.OrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jerfan.cang
 * @date 2019/8/28  10:24
 */
@Service(value = "dubboOrderService")
public class DubboOrderServiceImpl implements DubboOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboOrderServiceImpl.class);
    @Override
    public OrderBean orderCreate(OrderBean orderBean) {
        LOGGER.info("dubbo order server handle business ");
        // business handle
        orderBean.setOrderStatus("10");
        return orderBean;
    }
}
