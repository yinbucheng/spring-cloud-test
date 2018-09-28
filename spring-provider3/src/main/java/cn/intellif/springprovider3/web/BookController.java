package cn.intellif.springprovider3.web;

import cn.intellif.springprovider3.entity.BookEntity;
import cn.intellif.springprovider3.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping("save")
    public Object save(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("hahaha");
        bookService.save(bookEntity);
        return "success";
    }
}
