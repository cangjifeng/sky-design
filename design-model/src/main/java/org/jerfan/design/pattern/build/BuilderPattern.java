package org.jerfan.design.pattern.build;

import java.math.BigDecimal;

/**
 * @author 08011390
 * @since 2021/2/9
 */
public class BuilderPattern {


    public static void main(String[] args) {

        TradeObject oj = new TradeObject("s","b");
        OrderBean o = new OrderBean.OrderBeanBuilder(oj,"x")
                .address("nj",
                        "182")
                .getObject();

        System.out.println();
    }


    /**
     * 复杂对象中的其中一个属性 address
     */
    public static class ReceiptAddress{
        private String address;
        private String phone;

        public ReceiptAddress(String address,String phone){
            this.address = address;
            this.phone=phone;
        }
    }


    /**
     * 复杂对象中的其中一个属性 Trade object
     */
    public  static class TradeObject {
        private String sellerCode;
        private String buyerCode;

        public TradeObject(String sellerCode, String buyerCode) {
            this.sellerCode = sellerCode;
            this.buyerCode = buyerCode;
        }
    }


    /**
     * 要构建的复杂对象
     */
    public static  class OrderBean{




        protected TradeObject tradeObject;

        protected String orderNo;

        protected ReceiptAddress address;

        protected BigDecimal amount;

        protected String orderType;

        public OrderBean(TradeObject tradeObject, String orderNo ){
            this.tradeObject = tradeObject;
            this.orderNo = orderNo;
        }

        public void buildAddress(ReceiptAddress address){
            this.address = address;
        }


        /**
         * 复杂对象的构建器 builder
         */
        public static class OrderBeanBuilder {


            private  OrderBean order;

            public OrderBeanBuilder(TradeObject tradeObject, String orderNo){
                order = new OrderBean(tradeObject,orderNo);
            }

            public OrderBeanBuilder address(String address, String phone ){
                order.buildAddress(new ReceiptAddress(address,phone));
                return this;
            }

            public OrderBeanBuilder amount(BigDecimal amount){
                this.order.amount = amount;
                return this;
            }

            public OrderBean getObject(){
                return order;
            }


        }



    }











}
