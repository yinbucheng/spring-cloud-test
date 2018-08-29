package cn.intellif.springtestall.aoptest2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GDKProxyTest implements InvocationHandler{

    private Object target;

    public GDKProxyTest(Object target){
        this.target =target;
    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(GDKProxyTest.class.getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
