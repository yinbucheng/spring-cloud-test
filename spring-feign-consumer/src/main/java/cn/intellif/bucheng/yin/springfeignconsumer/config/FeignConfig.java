package cn.intellif.bucheng.yin.springfeignconsumer.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {


    @Bean
    public Retryer feignRetryer(){
        /**
         *
         */
        return new Retryer.Default(3,SECONDS.toMillis(10),1);
    }

}
