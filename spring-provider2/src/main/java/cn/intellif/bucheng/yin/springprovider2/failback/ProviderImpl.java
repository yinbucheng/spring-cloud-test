package cn.intellif.bucheng.yin.springprovider2.failback;


import cn.intellif.bucheng.yin.springprovider2.provider.IProvider;
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

    @Override
    public String delete(Long id) {
        throw new RuntimeException("回滚事务");
    }
}
