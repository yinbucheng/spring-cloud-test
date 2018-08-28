package cn.intellif.bucheng.yin.springprovider2;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableApolloConfig
public class SpringProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProvider2Application.class, args);
	}
}
