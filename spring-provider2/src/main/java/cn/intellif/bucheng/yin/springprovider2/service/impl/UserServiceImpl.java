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


    @Override
    public void save(UserEntity entity) {
        userMapper.save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
