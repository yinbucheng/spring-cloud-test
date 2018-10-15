package cn.intellif.bucheng.yin.springprovider.provider;


import cn.intellif.bucheng.yin.springprovider.failback.ProviderImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-provider",fallback = ProviderImpl.class)
public interface IProvider {
    @GetMapping("/room/save")
    String roomSave();

    @GetMapping("/room/save2")
    String roomSave2();
}
