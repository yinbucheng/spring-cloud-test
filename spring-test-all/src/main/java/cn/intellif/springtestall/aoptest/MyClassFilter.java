package cn.intellif.springtestall.aoptest;

import org.springframework.aop.ClassFilter;

public class MyClassFilter implements ClassFilter {
    @Override
    public boolean matches(Class<?> clazz) {
        //这里对类中的包为org和com.sun不进行拦截
        if(clazz.getPackage()==null||clazz.getPackage().getName().startsWith("org")||clazz.getPackage().getName().startsWith("com.sun"))
           return false;
        return true;
    }
}
