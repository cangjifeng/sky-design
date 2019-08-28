package org.jerfan.design.api;

import org.jerfan.design.bean.TradeOrderBean;

/**
 * 目标抽象类
 * 新业务
 * @author jerfan.cang
 * @date 2019/8/28  10:06
 */
public interface CloudOrderService {

    TradeOrderBean orderCreate(TradeOrderBean tradeOrderBean);

}
