package cn.intellif.springtestall.beanfactorytest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryUtils implements BeanFactoryPostProcessor {

    private static DefaultListableBeanFactory factory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        factory = (DefaultListableBeanFactory) beanFactory;
    }

    public static DefaultListableBeanFactory getFactory(){
        return factory;
    }
}
