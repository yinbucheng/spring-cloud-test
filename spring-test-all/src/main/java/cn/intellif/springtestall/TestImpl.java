package cn.intellif.springtestall;

public class TestImpl implements Test {
    private String name;

    public TestImpl(String name){
        this.name=name;
    }
    @Override
    public String test() {
        return name+" invoke test method";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String setName() {
        return null;
    }

    public static void main(String[] args) {
        String test="\n";
        System.out.println(test.getBytes()[0]);
    }
}
