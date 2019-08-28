package org.jerfan.design.bean;

/**
 * @author jerfan.cang
 * @date 2019/8/28  10:08
 */
public class TradeOrderBean {

    /**
     * 订单来源  cloud order server 特有的
     */
    private String orderFrom;

    private String orderNo;

    private String orderType;

    private String orderStatus;

    public TradeOrderBean(){}

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
