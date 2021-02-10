package org.jerfan.design.pattern.factory;

/**
 * @author 08011390
 * @since 2021/2/9
 */
public class FactoryPattern {






    public class OrderFactory{

    }


    public enum OrderTypeEnum{}


    public abstract class AbstractOrder{

        protected String orderNo;
    }


    public class CommonOrder extends AbstractOrder{

    }



}
