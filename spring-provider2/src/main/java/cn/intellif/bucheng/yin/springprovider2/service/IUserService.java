package cn.intellif.bucheng.yin.springprovider2.service;

import cn.intellif.bucheng.yin.springprovider2.entity.UserEntity;

public interface IUserService {
    void save(UserEntity entity);
    void delete(Long id);
}
