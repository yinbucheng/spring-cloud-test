package cn.intellif.bucheng.yin.springfeignconsumer;

import org.springframework.stereotype.Component;

@Component
public class ITestServiceImpl implements ITestService {
    @Override
    public String hi(String word) {
        return "server error get word: "+word;
    }
}
