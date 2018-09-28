package cn.intellif.bucheng.yin.springfeignconsumer.config;

import cn.intellif.bucheng.yin.springfeignconsumer.utils.WebUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigHeader implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("logId",WebUtils.getLogId());
    }
}
