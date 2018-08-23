package cn.intellif.bucheng.yin.springfeignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-provider")
public interface ITestService {
    @GetMapping("/test/hi")
    String hi(@RequestParam("word") String word);
}
