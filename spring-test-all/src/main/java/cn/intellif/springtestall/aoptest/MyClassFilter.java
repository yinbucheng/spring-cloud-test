package cn.intellif.springtestall.aoptest;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public class MyClassFilter implements ClassFilter {
    @Override
    public boolean matches(Class<?> clazz) {
//        if(clazz.getAnnotation(Configuration.class)!=null||clazz.getAnnotation(Component.class)!=null||clazz.getAnnotation(Service.class)!=null||clazz.getAnnotation(Controller.class)!=null||clazz.getAnnotation(RestController.class)!=null)
//          return true;
//        return false;
        if(clazz.getPackage().getName().startsWith("org")||clazz.getPackage().getName().startsWith("com.sun"))
           return false;
        System.out.println(">>>>>>>>>>>>>>>>>>>>:"+clazz.getPackage().getName());
        return true;
    }
}
