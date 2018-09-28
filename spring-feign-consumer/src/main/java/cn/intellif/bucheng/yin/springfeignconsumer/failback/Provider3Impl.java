package cn.intellif.bucheng.yin.springfeignconsumer.failback;

import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider3;
import org.springframework.stereotype.Component;

@Component
public class Provider3Impl implements IProvider3 {
    @Override
    public String bookSave() {
        return "book save fail";
    }
}
