package cn.intellif.bucheng.yin.springprovider;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoverClient2
@EnableApolloConfig
//@EnableEurekaClient
public class SpringProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}
}
