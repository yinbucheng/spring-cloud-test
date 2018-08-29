package cn.intellif.springtestall.aoptest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class AOPBeanFactoryAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    //这里添加一个链式调用方法
    public AOPBeanFactoryAdvisor(){
        setAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                return invocation.proceed();
            }
        });

    }


    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                //这里对类的判断不进行
               return new MyClassFilter();
            }

            //这里是对方法上的判断
            @Override
            public MethodMatcher getMethodMatcher() {
                return new MyMethodMatcher();
            }
        };
    }

}
