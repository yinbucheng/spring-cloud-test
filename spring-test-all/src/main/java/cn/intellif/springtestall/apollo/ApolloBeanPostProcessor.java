package cn.intellif.springtestall.apollo;

import cn.intellif.springtestall.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

//@Component
public class ApolloBeanPostProcessor implements BeanPostProcessor,InitializingBean{
    private Map<String,Object> map = new HashMap<>();


    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      Class clazz =  bean.getClass();
     ConfigurationProperties annotation = (ConfigurationProperties) clazz.getAnnotation(ConfigurationProperties.class);
     if(annotation!=null) {
         String prefix = annotation.prefix();
         //获取当前类字段
         setApolloValue(bean, clazz, prefix);
     }
     //获取当前类上面是否存在Value注解
        saveValueApollo(bean, clazz);
        return bean;
    }

    private void saveValueApollo(Object bean, Class clazz) {
        Field[] fields =  clazz.getDeclaredFields();
        if(fields!=null&&fields.length>0){
            for(Field field:fields) {
                if (Modifier.isStatic(field.getModifiers()))
                    continue;
                if(BeanUtils.isSimpleType(field.getType())) {
                    Value value = field.getAnnotation(Value.class);
                    if (value != null) {
                        String data = value.value();
                        String key = getELValue(data);
                        field.setAccessible(true);
                        registerApolloDefination(bean, field, key);
                    }
                }
            }
        }
    }


    private String getELValue(String value){
        return value.substring(2,value.length()-1);
    }

    private void setApolloValue(Object bean, Class clazz, String prefix) {
        Field[] fields = clazz.getDeclaredFields();
        if(fields!=null&&fields.length>0){
            for(Field field:fields){
                if(Modifier.isStatic(field.getModifiers()))
                    continue;
                if(BeanUtils.isSimpleType(field.getType())) {
                    String endName = field.getName();
                    field.setAccessible(true);
                    try {
                       String key = prefix+"."+endName;
                        System.out.println("key:"+key);
                       Object value = map.get(key);
                       if(value==null)
                           continue;
                       field.set(bean,value);
                        registerApolloDefination(bean, field, key);
                    } catch (Exception e) {
                            throw new RuntimeException(e);
                    }
                }else{
                    try {
                        field.setAccessible(true);
                        Object lastValue = field.get(bean);
                        if(lastValue==null)
                            continue;
                       Class tempClass =  lastValue.getClass();
                       String tempPrefix=prefix+"."+field.getName();
                        setApolloValue(lastValue,tempClass,tempPrefix);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void registerApolloDefination(Object bean, Field field, String key) {
        ApolloDefination apolloDefination = new ApolloDefination();
        apolloDefination.setTarget(bean);
        apolloDefination.setField(field);
        ApolloCache.register(key, apolloDefination);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        map.put("server.servlet.path","/");
        map.put("server.port",9099);
    }
}
