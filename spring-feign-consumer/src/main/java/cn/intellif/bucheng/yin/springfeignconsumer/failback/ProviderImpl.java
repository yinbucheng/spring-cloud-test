package cn.intellif.bucheng.yin.springfeignconsumer.failback;

import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider;
import org.springframework.stereotype.Component;

@Component
public class ProviderImpl implements IProvider {
    @Override
    public String roomSave() {
        return "room save fail";
    }
}
