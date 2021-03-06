package cn.intellif.bucheng.yin.springfeignconsumer;

import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import cn.intellif.transaction.intelliftransaction.anotation.EnableIntellifTransaction;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableApolloConfig
@EnableDiscoverClient2
@EnableIntellifTransaction
public class SpringFeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignConsumerApplication.class, args);
	}

}
