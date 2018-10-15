package cn.intellif.bucheng.yin.springprovider.provider;


import cn.intellif.bucheng.yin.springprovider.failback.Provider3Impl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-provider3",fallback = Provider3Impl.class)
public interface IProvider3 {
    @GetMapping("/book/save")
    String bookSave();

    @GetMapping("/book/save2")
    String bookSave2();
}
