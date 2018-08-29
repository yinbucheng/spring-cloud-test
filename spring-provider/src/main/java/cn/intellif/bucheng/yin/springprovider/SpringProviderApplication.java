package cn.intellif.bucheng.yin.springprovider;

import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoverClient2
public class SpringProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}
}
