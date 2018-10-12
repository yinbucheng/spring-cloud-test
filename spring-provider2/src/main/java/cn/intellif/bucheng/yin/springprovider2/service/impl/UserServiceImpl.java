package cn.intellif.bucheng.yin.springprovider2.service.impl;

import cn.intellif.bucheng.yin.springprovider2.entity.UserEntity;
import cn.intellif.bucheng.yin.springprovider2.mapper.UserMapper;
import cn.intellif.bucheng.yin.springprovider2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void save(UserEntity entity) {
        int i = 1/0;
        userMapper.save(entity);
    }
}
