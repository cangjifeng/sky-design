package org.jerfan.design.pattern.template;

import org.springframework.stereotype.Service;

/**
 * @author 08011390
 * @since 2021/2/9
 */
@Service(value = "commonCommit")
public class CommonCommitOrder extends AbstractCommitOrder{

    /**
     * 实现父类的 beforeCommitProcessor
     */
    @Override
    protected void beforeCommitProcessor() {
        defaultBeforeCommitProcessor();
        System.out.println("CommonCommitOrder#beforeCommitProcessor,non-other work about inventory");
    }

    /**
     * 实现父类的 afterCommitProcessor
     */
    @Override
    protected void afterCommitProcessor() {
        defaultAfterCommitProcessor();
    }

    /**
     * 重写父类的 mustRewrite 逻辑
     */
    @Override
    protected void mustRewrite() {
        System.out.println("CommonCommitOrder#mustRewrite,do non");
    }
}
