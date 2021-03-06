package cn.intellif.bucheng.yin.springzipkinserver;

import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableDiscoverClient2
@EnableZipkinServer
@EnableApolloConfig
public class SpringZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZipkinServerApplication.class, args);
	}
}
