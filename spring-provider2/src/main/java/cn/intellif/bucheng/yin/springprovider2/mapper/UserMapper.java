package cn.intellif.bucheng.yin.springprovider2.mapper;

import cn.intellif.bucheng.yin.springprovider2.entity.UserEntity;

public interface UserMapper {
    void save(UserEntity entity);
    void delete(Long id);
}
