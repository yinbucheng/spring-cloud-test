package cn.intellif.bucheng.yin.springprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoverClient2
//@EnableDiscoveryClient
public class SpringProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}
}
