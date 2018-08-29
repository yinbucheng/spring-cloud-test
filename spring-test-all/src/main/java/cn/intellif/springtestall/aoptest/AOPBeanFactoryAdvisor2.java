package cn.intellif.springtestall.aoptest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

@Component
public class AOPBeanFactoryAdvisor2 extends AbstractBeanFactoryPointcutAdvisor {

    public AOPBeanFactoryAdvisor2(){
        setAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object target = invocation.getThis();
                Class clazz = AopUtils.getTargetClass(target);
                Class tempClass = target.getClass();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>方法invoke 2  targetClass:"+tempClass.getName()+" sourceClass:"+clazz.getName());
                return invocation.proceed();
            }
        });
    }

    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
               return new MyClassFilter();
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MyMethodMatcher();
            }
        };
    }

}
