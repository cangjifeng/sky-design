package org.jerfan.design.impl;

import org.jerfan.design.api.CloudOrderService;
import org.jerfan.design.bean.TradeOrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jerfan.cang
 * @date 2019/8/28  10:28
 */
@Service(value = "cloudOrderService")
public class CloudOrderServiceImpl implements CloudOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudOrderServiceImpl.class);
    @Override
    public TradeOrderBean orderCreate(TradeOrderBean tradeOrderBean) {
        LOGGER.info(" cloud order server");
        tradeOrderBean.setOrderFrom("2");
        tradeOrderBean.setOrderStatus("11");
        return tradeOrderBean;
    }
}
