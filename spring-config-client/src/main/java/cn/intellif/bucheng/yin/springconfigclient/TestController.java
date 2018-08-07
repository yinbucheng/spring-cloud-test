package cn.intellif.bucheng.yin.springconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
//@RefreshScope
public class TestController {

    @Value("${config.version}")
    private String word;

    @RequestMapping("hi")
    public Object hi(){
        return word;
    }
}
