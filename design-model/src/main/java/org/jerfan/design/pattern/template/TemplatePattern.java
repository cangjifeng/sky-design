package org.jerfan.design.pattern.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 08011390
 * @since 2021/2/9
 */
@Service(value = "templatePattern")
public class TemplatePattern {

    @Autowired
    private AbstractCommitOrder commonCommit;
    @Autowired
    private AbstractCommitOrder proCommit;

    public static void main(String[] args) {
        TemplatePattern tm = new TemplatePattern();
        tm.common(new Object());
        tm.pro(new Object());

        System.out.println("the end");
    }

    public TemplatePattern(){
        commonCommit = new CommonCommitOrder();
        proCommit = new ProCommitOrder();
    }



    public void common(Object obj){
        commonCommit.commit(obj);
    }


    public void pro(Object o){
        proCommit.commit(o);
    }
}
