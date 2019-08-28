package org.jerfan.design.api;

import org.jerfan.design.bean.OrderBean;

public interface DubboOrderService {

    OrderBean orderCreate(OrderBean orderBean);
}
