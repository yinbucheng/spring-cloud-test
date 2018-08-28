package cn.intellif.bucheng.yin.springprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hi")
    public Object hi(String word) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>服务开被调用:"+word);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "hi i come from provider : "+word;
    }
}
