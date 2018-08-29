package cn.intellif.springfeignconsumer2;

import org.springframework.stereotype.Component;

@Component
public class ITestServiceImpl implements ITestService {
    @Override
    public String hi(String word) {
        return "server error get word: "+word;
    }
}
