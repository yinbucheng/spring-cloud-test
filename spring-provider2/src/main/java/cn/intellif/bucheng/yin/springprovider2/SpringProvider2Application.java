package cn.intellif.bucheng.yin.springprovider2;

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
@MapperScan(basePackages = "cn.intellif.bucheng.yin.springprovider2.mapper")
@EnableIntellifTransaction
public class SpringProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProvider2Application.class, args);
	}
}
