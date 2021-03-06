package cn.intellif.bucheng.yin.springfeignconsumer.failback;

import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider2;
import org.springframework.stereotype.Component;

@Component
public class Provider2Impl implements IProvider2 {
    @Override
    public String userSave() {
        throw new RuntimeException("回滚开始.....");
    }

    @Override
    public String userSave2() {
        throw new RuntimeException("回滚开始......");
    }
}
