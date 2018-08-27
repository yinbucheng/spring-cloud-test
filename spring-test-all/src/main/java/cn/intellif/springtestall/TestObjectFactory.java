package cn.intellif.springtestall;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestObjectFactory implements ObjectFactory<Test> {
    static List<Test> datas = new ArrayList<>(4);
    static {
        datas.add(new TestImpl("nice1"));
        datas.add( new TestImpl("good2"));
        datas.add(new TestImpl("hello3"));
        datas.add(new TestImpl("byte4"));
    }
    @Override
    public Test getObject() throws BeansException {
        return (Test) Proxy.newProxyInstance(TestObjectFactory.class.getClassLoader(), new Class[]{Test.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(datas.get(new Random().nextInt(4)),args);
            }
        });
    }
}
