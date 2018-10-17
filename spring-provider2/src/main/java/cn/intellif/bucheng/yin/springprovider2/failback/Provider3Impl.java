package cn.intellif.bucheng.yin.springprovider2.failback;


import cn.intellif.bucheng.yin.springprovider2.provider.IProvider3;
import org.springframework.stereotype.Component;

@Component
public class Provider3Impl implements IProvider3 {
    @Override
    public String bookSave() {
       throw new RuntimeException("回滚事务");
    }

    @Override
    public String bookSave2() {
        throw new RuntimeException("回滚事务");
    }

    @Override
    public String delete(Long id) {
        throw new RuntimeException("回滚事务");
    }
}
