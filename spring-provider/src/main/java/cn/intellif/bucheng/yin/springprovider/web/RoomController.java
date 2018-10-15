package cn.intellif.bucheng.yin.springprovider.web;

import cn.intellif.bucheng.yin.springprovider.entity.RoomEntity;
import cn.intellif.bucheng.yin.springprovider.provider.IProvider2;
import cn.intellif.bucheng.yin.springprovider.service.IRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IRoomService roomService;
    @Autowired
    private IProvider2 provider2;

    @RequestMapping("save")
    public Object save(){
        try {
            RoomEntity entity = new RoomEntity();
            entity.setName("test");
            roomService.save(entity);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }

    @RequestMapping("/save2")
    @Transactional
    public Object save2(){
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>RoomController save2 invoke......");
           RoomEntity entity = new RoomEntity();
           entity.setName("yucui");
           roomService.save(entity);
           provider2.userSave2();
        return "success";
    }

    @RequestMapping("delete")
    public Object delete(Long id){
        roomService.delete(id);
        provider2.delete(id);
        return "success";
    }
}
