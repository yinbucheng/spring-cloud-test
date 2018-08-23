package cn.intellif.bucheng.yin.springprovider;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.zookeeper.ZookeeperAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryClientConfiguration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistryAutoConfiguration;
import org.springframework.cloud.zookeeper.support.CuratorServiceDiscoveryAutoConfiguration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class DiscoverBeanRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        String type ="ZOOKEEPER";
        if(type.equals("EUREKA")){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>注册EUREKA");
            registerEureka(beanDefinitionRegistry);
        }else if(type.equals("ZOOKEEPER")){
            System.out.println(">>>>>>>>>>>>>>>>>注册ZOOKEEPER");
            registerZookeeper(beanDefinitionRegistry);
        }
    }

    private void registerEureka(BeanDefinitionRegistry registry){
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,EurekaClientAutoConfiguration.class.getName(),EurekaClientAutoConfiguration.class);
    }

    private void registerZookeeper(BeanDefinitionRegistry registry){
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,ZookeeperDiscoveryAutoConfiguration.class.getName(),ZookeeperDiscoveryAutoConfiguration.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,ZookeeperDiscoveryClientConfiguration.class.getName(),ZookeeperDiscoveryClientConfiguration.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,CuratorServiceDiscoveryAutoConfiguration.class.getName(),CuratorServiceDiscoveryAutoConfiguration.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,ZookeeperServiceRegistryAutoConfiguration.class.getName(),ZookeeperServiceRegistryAutoConfiguration.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,ZookeeperAutoConfiguration.class.getName(),ZookeeperAutoConfiguration.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry,ZookeeperAutoServiceRegistrationAutoConfiguration.class.getName(),ZookeeperAutoServiceRegistrationAutoConfiguration.class);
    }
}
