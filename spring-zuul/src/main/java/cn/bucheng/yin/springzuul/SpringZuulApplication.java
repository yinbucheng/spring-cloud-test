package cn.bucheng.yin.springzuul;

//import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import cn.intellif.springdiscoverclient.EnableDiscoverClient2;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
@EnableDiscoverClient2
@EnableApolloConfig
public class SpringZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApplication.class, args);
	}
}
