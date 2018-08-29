package cn.intellif.springfeignconsumer2;

import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableApolloConfig
@EnableFeignClients
@EnableDiscoverClient2
public class SpringFeignConsumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignConsumer2Application.class, args);
	}
}
