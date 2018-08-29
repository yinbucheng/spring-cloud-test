package cn.intellif.springtestall;

import cn.intellif.springtestall.aoptest.MethodTest;
import cn.intellif.springtestall.apollo.ApolloCache;
import cn.intellif.springtestall.beanfactorytest.BeanFactoryUtils;
import cn.intellif.springtestall.beanfactorytest.TestBean;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
   private TestBean testBean;

    @RequestMapping("/test")
    @MethodTest
    public Object test(){
        String[] names = BeanFactoryUtils.getFactory().getBeanDefinitionNames();
        System.out.println("count1:"+names.length);
        Map<String,Object> data = BeanFactoryUtils.getFactory().getBeansOfType(Object.class);
        System.out.println("count2:"+data.size());
       int count =  BeanFactoryUtils.getFactory().getBeanDefinitionCount();
        System.out.println("count3:"+count);
       int size =  BeanFactoryUtils.getFactory().getBeansOfType(Advisor.class)==null?0:BeanFactoryUtils.getFactory().getBeansOfType(Advisor.class).size();
        System.out.println("count4:"+size);
        return testBean;
    }




    @RequestMapping("/changeName")
    public Object changeAppliationName(String value){
        ApolloCache.changeValue("spring.application.name",value);
        return "{\"code\":200,\"msg\":\"修改name成功\"}";
    }

    @RequestMapping("/changePort")
    public Object changePort(Integer port){
        ApolloCache.changeValue("server.port",port);
        return "{\"code\":200,\"msg\":\"修改端口成功\"}";
    }
}
