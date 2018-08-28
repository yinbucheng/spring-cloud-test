package cn.intellif.springtestall.apollo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ApolloCache {
    private static Map<String,List<ApolloDefination>> cacheMap = new HashMap<>();

    public static synchronized void register(String key,ApolloDefination bean){
       List<ApolloDefination> apolloDefinations = cacheMap.get(key);
       if(apolloDefinations==null) {
           apolloDefinations = new LinkedList<>();
           cacheMap.put(key,apolloDefinations);
       }
       apolloDefinations.add(bean);
    }

    public static void changeValue(String key,Object value){
        List<ApolloDefination> apolloDefinations = cacheMap.get(key);
        if(apolloDefinations!=null&&apolloDefinations.size()>0) {
            for (ApolloDefination apolloDefination : apolloDefinations) {
                Object target = apolloDefination.getTarget();
                try {
                    apolloDefination.getField().set(target, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
