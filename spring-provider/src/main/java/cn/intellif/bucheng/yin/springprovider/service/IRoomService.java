package cn.intellif.bucheng.yin.springprovider.service;

import cn.intellif.bucheng.yin.springprovider.entity.RoomEntity;

public interface IRoomService {
    void save(RoomEntity entity);
    void delete(Long id);
}
