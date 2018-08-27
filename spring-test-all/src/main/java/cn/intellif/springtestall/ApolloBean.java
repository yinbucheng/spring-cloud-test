package cn.intellif.springtestall;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApolloBean implements BeanPostProcessor,InitializingBean {

    Map<String,Object> map = new HashMap<>();

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      Class clazz =  bean.getClass();
     ConfigurationProperties annotation = (ConfigurationProperties) clazz.getAnnotation(ConfigurationProperties.class);
     if(annotation!=null) {
         String prefix = annotation.prefix();
         //获取当前类字段
         replaceFieldValue(bean, clazz, prefix);
     }
        return bean;
    }

    private void replaceFieldValue(Object bean, Class clazz, String prefix) {
        Field[] fields = clazz.getDeclaredFields();
        if(fields!=null&&fields.length>0){
            for(Field field:fields){
                if(Modifier.isStatic(field.getModifiers()))
                    continue;
                if(BeanUtils.isSimpleType(field.getType())) {
                    String endName = field.getName();
                    String totalName = prefix + "." + endName;
                    Object temp = map.get(totalName);
                    if (temp != null) {
                        field.setAccessible(true);
                        try {
                            Object lastValue = field.get(bean);
                            System.out.println(totalName + " : last value = " + lastValue);
                            field.set(bean, temp);
                            System.out.println(totalName + ": current value =" + temp);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }else{
                    try {
                        field.setAccessible(true);
                        Object lastValue = field.get(bean);
                        if(lastValue==null)
                            continue;
                       Class tempClass =  lastValue.getClass();
                       String tempPrefix=prefix+"."+field.getName();
                       replaceFieldValue(lastValue,tempClass,tempPrefix);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        map.put("spring.application.name","spring-test2");
        map.put("server.port",8091);
        map.put("server.servlet.path","/test");
    }
}
