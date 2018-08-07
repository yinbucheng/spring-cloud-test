package cn.intellif.bucheng.yin.springribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")
    public Object hi(String word){
        return restTemplate.getForObject("http://spring-provider/test/hi?word="+word,String.class);
    }

    public String hiError(String word){
        return "server has broken :word "+word;
    }
}
