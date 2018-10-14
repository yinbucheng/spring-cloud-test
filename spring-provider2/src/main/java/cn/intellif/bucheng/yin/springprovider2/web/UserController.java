package cn.intellif.bucheng.yin.springprovider2.web;

import cn.intellif.bucheng.yin.springprovider2.entity.UserEntity;
import cn.intellif.bucheng.yin.springprovider2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("save")
    @Transactional
    public Object save(){
        try {
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
            UserEntity userEntity = new UserEntity();
            userEntity.setName("yucui");
            userService.save(userEntity);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }
}
