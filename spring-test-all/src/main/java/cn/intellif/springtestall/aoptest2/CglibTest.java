package cn.intellif.springtestall.aoptest2;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest implements MethodInterceptor {

    private Object target;

    private Enhancer enhancer = new Enhancer();

    public CglibTest(Object target){
        this.target =target;
    }

    public <T> T getProxy(Class<T> clazz){
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return method.invoke(target,objects);
    }
}
