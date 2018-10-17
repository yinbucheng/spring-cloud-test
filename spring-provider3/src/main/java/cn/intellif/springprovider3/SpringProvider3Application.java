package cn.intellif.springprovider3;

import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import cn.intellif.transaction.intelliftransaction.anotation.EnableIntellifTransaction;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoverClient2
@EnableApolloConfig
@EnableFeignClients
@EnableIntellifTransaction
@MapperScan(basePackages = "cn.intellif.springprovider3.mapper")
public class SpringProvider3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProvider3Application.class, args);
	}
}
