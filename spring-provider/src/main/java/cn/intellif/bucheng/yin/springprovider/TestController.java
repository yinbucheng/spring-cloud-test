package cn.intellif.bucheng.yin.springprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hi")
    public Object hi(String word) {
         int a = 1/0;
        return "hi i come from provider : "+word;
    }
}
