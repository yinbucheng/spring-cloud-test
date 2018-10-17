package cn.intellif.springprovider3.service;

import cn.intellif.springprovider3.entity.BookEntity;

public interface IBookService {
    void save(BookEntity entity);
    void delete(Long id);
}
