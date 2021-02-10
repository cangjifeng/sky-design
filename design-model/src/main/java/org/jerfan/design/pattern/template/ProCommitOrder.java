package org.jerfan.design.pattern.template;

import org.springframework.stereotype.Service;

/**
 * @author 08011390
 * @since 2021/2/9
 */
@Service(value = "proCommit")
public class ProCommitOrder extends AbstractCommitOrder{

    /**
     * 实现父类的 beforeCommitProcessor
     */
    @Override
    protected void beforeCommitProcessor() {
        System.out.println("ProCommitOrder.beforeCommitProcessor, reduce inventory of Promotion .");
    }

    /**
     * 实现父类的  afterCommitProcessor
     */
    @Override
    protected void afterCommitProcessor() {
        defaultAfterCommitProcessor();
    }

    /**
     * 重写父类的 mustRewrite
     */
    @Override
    protected void mustRewrite() {

        System.out.println("ProCommitOrder.mustRewrite, ... over");
    }
}
