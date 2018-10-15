package cn.intellif.bucheng.yin.springprovider2.provider;


import cn.intellif.bucheng.yin.springprovider2.failback.Provider2Impl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-provider2",fallback = Provider2Impl.class)
public interface IProvider2 {
    @GetMapping("/user/save")
    String userSave();

    @GetMapping("/user/save")
    String userSave2();
}
