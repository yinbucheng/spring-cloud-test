package cn.intellif.bucheng.yin.springribbonconsumer;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("hi")
    public Object hi(String word){
        return ribbonService.hi(word);
    }

    @GetMapping("choseProvider")
    public Object choseProvider(){
        ServiceInstance server = loadBalancer.choose("spring-provider");
        return server.getHost()+":"+server.getPort();
    }

}
