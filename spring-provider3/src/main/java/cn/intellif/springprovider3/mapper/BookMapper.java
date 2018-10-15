package cn.intellif.springprovider3.mapper;

import cn.intellif.springprovider3.entity.BookEntity;

public interface BookMapper {
    void save(BookEntity entity);
    void delete(Long id);
}
