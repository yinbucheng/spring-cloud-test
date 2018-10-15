package cn.intellif.bucheng.yin.springfeignconsumer.provider;

import cn.intellif.bucheng.yin.springfeignconsumer.failback.ProviderImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-provider",fallback = ProviderImpl.class)
public interface IProvider {
    @GetMapping("/room/save")
    String roomSave();

    @GetMapping("/room/save2")
    String roomSave2();

    @GetMapping("/room/delete")
    String delete(@RequestParam("id") Long id);
}
