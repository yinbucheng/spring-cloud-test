package cn.intellif.bucheng.yin.springswagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Api(description = "测试")
@RequestMapping(value="/test")
public class TestController {

   private Logger logger = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value = "测试",notes = "测试用的")
    @RequestMapping("/test")
    public Object test(){
       logger.info("test: run test");
       for (int i=0;i<Integer.MAX_VALUE;i++) {
           if(i%2==0) {
               logger.error("test: error ................." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " number:" + i);
           } else{
               logger.error("test:info .........."+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " number:" + i);
           }

           try {
               Thread.sleep(4000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        return "test";
    }
}
