package org.jerfan.design.pattern.template;

/**
 * 模板方法抽象
 * @author 08011390
 * @since 2021/2/9
 */
public abstract class AbstractCommitOrder {


    /**
     * 模板方法, <br>
     * 不容许重写，如果需要拓展则需要去重写 doCommit()
     * @param param {@link Object}
     */
    public final void commit(Object param){
        // 模板方法中调用具体的方法【抽象类中已经默认实现的方法和钩子函数】
        doCommit(param);

    }


    /**
     * 默认实现
     * @param param {@link Object}
     */
    protected void doCommit(Object param){
        // 已有默认实现, 子类可以继承或者重写 ...
        beforeCommitProcessor();
        System.out.println(" do commit default ");
        mustRewrite();
        afterCommitProcessor();


    }

    /**
     * 抽象方法，子类必须实现
     */
    protected  abstract void beforeCommitProcessor();

    protected void defaultBeforeCommitProcessor(){

        System.out.println("AbstractCommitOrder#defaultBeforeCommitProcessor,reduce inventory");
    }


    /**
     * 抽象方法，子类必须实现
     */
    protected abstract void afterCommitProcessor();


    protected void defaultAfterCommitProcessor(){
        System.out.println("AbstractCommitOrder#defaultAfterCommitProcessor,save the order data to DB");
    }





    protected void  mustRewrite(){
        new Error("subclass must rewrite");
    }




}
