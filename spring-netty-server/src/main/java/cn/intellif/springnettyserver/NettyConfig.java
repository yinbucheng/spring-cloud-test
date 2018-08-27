package cn.intellif.springnettyserver;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.netty.config")
public class NettyConfig {
    private int port = 8090;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
