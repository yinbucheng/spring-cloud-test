package cn.intellif.bucheng.yin.springprovider2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hi")
    public Object hi(String word){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>LogId:"+WebUtils.getLogId());
        return "hi i come from provider2 : "+word;
    }
}
