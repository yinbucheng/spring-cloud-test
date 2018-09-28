package cn.intellif.bucheng.yin.springfeignconsumer.web;

import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider;
import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider2;
import cn.intellif.bucheng.yin.springfeignconsumer.provider.IProvider3;
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
    public Object save(){
        provider.roomSave();
        provider2.userSave();
        provider3.bookSave();
        return "success";
    }
}
