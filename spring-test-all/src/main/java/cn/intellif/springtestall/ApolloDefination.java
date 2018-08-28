package cn.intellif.springtestall;

import java.lang.reflect.Field;

public class ApolloDefination {
    //实例对象
    private Object target;
    //作用到的属性字段
    private Field field;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }


    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
