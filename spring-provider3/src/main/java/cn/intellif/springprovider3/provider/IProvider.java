package cn.intellif.springprovider3.provider;


import cn.intellif.springprovider3.failback.ProviderImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-provider",fallback = ProviderImpl.class)
public interface IProvider {
    @GetMapping("/room/save")
    String roomSave();

    @GetMapping("/room/save2")
    String roomSave2();
}
