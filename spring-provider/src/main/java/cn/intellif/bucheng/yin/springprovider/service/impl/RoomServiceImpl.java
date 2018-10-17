package cn.intellif.bucheng.yin.springprovider.service.impl;

import cn.intellif.bucheng.yin.springprovider.entity.RoomEntity;
import cn.intellif.bucheng.yin.springprovider.mapper.RoomMapper;
import cn.intellif.bucheng.yin.springprovider.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Transactional
    @Override
    public void save(RoomEntity entity) {
        roomMapper.save(entity);
    }

    @Transactional
    public void delete(Long id){
          roomMapper.delete(id);
    }

}
