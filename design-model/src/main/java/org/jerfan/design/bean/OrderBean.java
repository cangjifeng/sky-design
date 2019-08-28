package org.jerfan.design.bean;

/**
 * @author jerfan.cang
 * @date 2019/8/28  10:06
 */
public class OrderBean {

    private String orderNo;

    private String orderType;

    private String orderStatus;


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
