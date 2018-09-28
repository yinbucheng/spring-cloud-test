package cn.intellif.bucheng.yin.springprovider.service.impl;

import cn.intellif.bucheng.yin.springprovider.entity.RoomEntity;
import cn.intellif.bucheng.yin.springprovider.mapper.RoomMapper;
import cn.intellif.bucheng.yin.springprovider.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public void save(RoomEntity entity) {
        roomMapper.save(entity);
    }
}
