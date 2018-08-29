package cn.intellif.springtestall.test;

import cn.intellif.springtestall.test.Test;

public class TestImpl implements Test {
    private String name;

    public TestImpl(){

    }

    public TestImpl(String name){
        this.name=name;
    }
    @Override
    public String test() {
        return name+" invoke test method";
    }

    @Override
    public String getName() {
        return name;
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
