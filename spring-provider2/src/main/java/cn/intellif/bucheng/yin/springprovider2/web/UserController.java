package cn.intellif.bucheng.yin.springprovider2.web;

import cn.intellif.bucheng.yin.springprovider2.entity.UserEntity;
import cn.intellif.bucheng.yin.springprovider2.provider.IProvider3;
import cn.intellif.bucheng.yin.springprovider2.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;
    @Autowired
    private IProvider3 provider3;

    @RequestMapping("save")
    @Transactional
    public Object save(){
        try {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>UserController save1 invoke.....");
            UserEntity userEntity = new UserEntity();
            userEntity.setName("yinchong");
            userService.save(userEntity);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }

    @RequestMapping("/save2")
    @Transactional
    public Object save2(){
        try{
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>UserController save2 invoke.....");
            UserEntity userEntity = new UserEntity();
            userEntity.setName("yucui");
            userService.save(userEntity);
            provider3.bookSave();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }
}
