package cn.intellif.springprovider3.failback;


import cn.intellif.springprovider3.provider.IProvider;
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
