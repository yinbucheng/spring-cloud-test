package cn.intellif.springtestall;

import cn.intellif.springtestall.apollo.ApolloCache;
import cn.intellif.springtestall.apollo.TestConfigProperties;
import cn.intellif.springtestall.test.TestBean;
import cn.intellif.springtestall.test.TestBean2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${spring.application.name}")
    private String test;

    @Value("${spring.application.name}")
    private String  test2;
    @Autowired
    private TestBean testBean;
    @Autowired
    private TestBean2 testBean2;

    @Autowired
    private ServerProperties serverProperties;
    @Autowired
    private TestConfigProperties testConfigProperties;


    @RequestMapping("/test")
    public Object test(){
        System.out.println(testBean.getValue()+":"+test2+":"+test+":"+test2+" :"+serverProperties.getPort()+" "+testConfigProperties.getAddress()+" :"+testConfigProperties.getName());
        return test;
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
