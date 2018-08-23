package cn.intellif.bucheng.yin.springzipkinprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hi")
    public Object hi(){
        String content = "i am forezp ";
        content+=restTemplate.getForObject("http://spring-zipkin-provider2/test/hellow",String.class);
        int i =1/0;
        return content;
    }
}
