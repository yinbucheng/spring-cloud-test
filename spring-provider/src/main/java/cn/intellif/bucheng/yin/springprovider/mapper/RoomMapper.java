package cn.intellif.bucheng.yin.springprovider.mapper;

import cn.intellif.bucheng.yin.springprovider.entity.RoomEntity;

public interface RoomMapper {
    void save(RoomEntity entity);
    void delete(Long id);
}
