package cn.intellif.bucheng.yin.springzipkinprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringZipkinProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZipkinProviderApplication.class, args);
	}
}
