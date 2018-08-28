package cn.intellif.springtestall;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController implements InitializingBean{
    @Value("${spring.application.name}")
    private String test;

    @Value("${spring.application.name}")
    private String  test2;
    @Autowired
    private TestBean testBean;
    @Autowired
    private TestBean2 testBean2;

    @RequestMapping("/test")
    public Object test(){
        System.out.println(testBean.getValue()+":"+test2+":"+test+":"+test2);
        return test;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ApolloCache.changeValue("spring.application.name", "test-lalala"+new Random().nextInt(1000));
                    int port =  8080 + new Random().nextInt(10);
                    ApolloCache.changeValue("server.port",port);
                    System.out.println("》》》》》》》》》》》》》》》》》》》》》》当前端口为:"+port);
                }
            }
        });
        thread.start();

    }
}
