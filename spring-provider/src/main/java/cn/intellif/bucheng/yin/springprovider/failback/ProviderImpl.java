package cn.intellif.bucheng.yin.springprovider.failback;


import cn.intellif.bucheng.yin.springprovider.provider.IProvider;
import org.springframework.stereotype.Component;

@Component
public class ProviderImpl implements IProvider {
    @Override
    public String roomSave() {
       throw new RuntimeException("回滚事务");
    }

    @Override
    public String roomSave2() {
        throw new RuntimeException("回滚事务");
    }
}
