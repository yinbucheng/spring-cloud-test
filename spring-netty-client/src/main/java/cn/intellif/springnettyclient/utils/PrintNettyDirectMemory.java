package cn.intellif.springnettyclient.utils;

import io.netty.util.internal.PlatformDependent;

import java.lang.reflect.Field;

public class PrintNettyDirectMemory {

    public static String printDirectMemory(){
        try {
            Class clazz = PlatformDependent.class;
            Field field = clazz.getDeclaredField("DIRECT_MEMORY_COUNTER");
            field.setAccessible(true);
            return field.get(null)+"";
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void startPrintLog(){
        String content = printDirectMemory();
        System.out.println("netty使用直接内存大小为:"+content);
    }
}
