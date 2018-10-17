package cn.intellif.springprovider3.provider;


import cn.intellif.springprovider3.failback.Provider2Impl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-provider2",fallback = Provider2Impl.class)
public interface IProvider2 {
    @GetMapping("/user/save")
    String userSave();

    @GetMapping("/user/save")
    String userSave2();
}
