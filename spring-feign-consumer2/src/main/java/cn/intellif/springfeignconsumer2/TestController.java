package cn.intellif.springfeignconsumer2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private ITestService testService;

    @GetMapping("hi")
    public Object hi(String word){
        return testService.hi(word);
    }

}
