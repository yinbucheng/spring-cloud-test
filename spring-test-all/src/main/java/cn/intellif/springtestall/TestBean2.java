package cn.intellif.springtestall;

import org.springframework.stereotype.Component;

@Component
public class TestBean2 {

    private TestBean testBean;

    public TestBean getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }
}
