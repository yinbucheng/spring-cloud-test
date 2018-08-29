package cn.intellif.springtestall.aoptest2;

import cn.intellif.springtestall.beanfactorytest.TestBean;
import cn.intellif.springtestall.test.Test;
import cn.intellif.springtestall.test.TestImpl;

public class TestMain {
    public static void main(String[] args) {
        Test test = new TestImpl("nice");
        GDKProxyTest proxy1 = new GDKProxyTest(test);
        Test test1 = proxy1.getProxy(Test.class);
        TestBean testBean = new TestBean();
        CglibTest cglibTest = new CglibTest(testBean);
        TestBean test2 = cglibTest.getProxy(TestBean.class);
        System.out.println(test1.test()+":"+test2.getAddress());
        System.out.println(test1.getClass().getName()+" : "+test2.getClass().getName());
        System.out.println(test1.getClass().getPackage());
        System.out.println(test2.getClass().getPackage());
    }
}
