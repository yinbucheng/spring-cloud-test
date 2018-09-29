package cn.intellif.bucheng.yin.springprovider.web;

import cn.intellif.bucheng.yin.springprovider.entity.RoomEntity;
import cn.intellif.bucheng.yin.springprovider.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @RequestMapping("save")
    public Object save(){
        try {
            RoomEntity entity = new RoomEntity();
            entity.setName("test"+System.currentTimeMillis());
            roomService.save(entity);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }
}
