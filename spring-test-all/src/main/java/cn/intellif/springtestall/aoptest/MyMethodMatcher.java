package cn.intellif.springtestall.aoptest;


import org.springframework.aop.MethodMatcher;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class MyMethodMatcher implements MethodMatcher {


    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        if(method.getAnnotation(MethodTest.class)!=null)
           return true;
        return false;
    }

    @Override
    public boolean isRuntime() {
        return true;
    }

    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass, Object... args) {
        if(method.getAnnotation(MethodTest.class)!=null)
            return true;
        return false;
    }
}
