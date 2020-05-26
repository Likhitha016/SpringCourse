package SpringAOPDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LuvAopExpressions {
    //pointcut usage
    @Pointcut("execution(* SpringAOPDemo.DAO.*.*(..))")
    private void forReusingPoincut(){
    }

    // create pointcut for getter methods
    @Pointcut("execution(* SpringAOPDemo.DAO.*.get*(..))")
    private void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* SpringAOPDemo.DAO.*.set*(..))")
    private void setter() {}


    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forReusingPoincut() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
