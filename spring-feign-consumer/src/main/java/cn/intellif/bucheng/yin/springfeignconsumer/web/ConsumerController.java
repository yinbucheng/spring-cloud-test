package cn.intellif.bucheng.yin.springfeignconsumer.web;

import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider;
import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider2;
import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider3;
import cn.intellif.bucheng.yin.springfeignconsumer.utils.WebUtils;
import cn.intellif.transaction.intelliftransaction.anotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private IProvider provider;
    @Autowired
    private IProvider2 provider2;
    @Autowired
    private IProvider3 provider3;

    @RequestMapping("save")
    @TxTransaction
    public Object save(){
        try {
            provider.roomSave();
            provider2.userSave();
//        int i = 1/0;
            provider3.bookSave();
            return "success";
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/test")
    public Object test(){
        return WebUtils.getRequest().toString();
    }


    @RequestMapping("/save2")
    public  Object save2(){
         provider.roomSave();
         return "success";
    }
}
