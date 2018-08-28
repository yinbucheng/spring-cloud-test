package cn.intellif.springtestall.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Primary
public class TestFactoryBean implements FactoryBean<Test> {

    static List<Test> datas = new ArrayList<>(4);
    static {
        datas.add(new TestImpl("nice1"));
        datas.add( new TestImpl("good2"));
        datas.add(new TestImpl("hello3"));
        datas.add(new TestImpl("byte4"));
    }

    @Nullable
    @Override
    public Test getObject() throws Exception {
        return (Test) Proxy.newProxyInstance(TestObjectFactory.class.getClassLoader(), new Class[]{Test.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(datas.get(new Random().nextInt(4)),args);
            }
        });
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Test.class;
    }
}
