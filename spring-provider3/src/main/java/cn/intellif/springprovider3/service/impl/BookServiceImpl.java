package cn.intellif.springprovider3.service.impl;

import cn.intellif.springprovider3.entity.BookEntity;
import cn.intellif.springprovider3.mapper.BookMapper;
import cn.intellif.springprovider3.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Transactional
    @Override
    public void save(BookEntity entity) {
        bookMapper.save(entity);
    }
}
