package cn.intellif.springtestall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private Test test;

    @RequestMapping("/test")
    public Object test(){
        return test.test();
    }
}
