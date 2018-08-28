package cn.intellif.springtestall;

import cn.intellif.springtestall.apollo.TestConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TestConfigProperties.class)
public class SpringTestAllApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringTestAllApplication.class, args);
	}
}
