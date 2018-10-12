package cn.intellif.bucheng.yin.springprovider;

import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import cn.intellif.transaction.intelliftransaction.anotation.EnableIntellifTransaction;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoverClient2
@MapperScan(basePackages = "cn.intellif.bucheng.yin.springprovider.mapper")
@EnableIntellifTransaction
public class SpringProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}
}
