package cn.intellif.bucheng.yin.springzipkinprovider2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("hellow")
    public Object hellow(){
        return "hellow boy";
    }
}


