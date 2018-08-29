package cn.intellif.springtestall.test;

import org.springframework.stereotype.Component;

@Component
public class TestBean2 {

    private TestBean3 testBean;

    public TestBean3 getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBean3 testBean) {
        this.testBean = testBean;
    }
}
