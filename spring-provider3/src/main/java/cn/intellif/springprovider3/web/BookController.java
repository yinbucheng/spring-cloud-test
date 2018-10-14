package cn.intellif.springprovider3.web;

import cn.intellif.springprovider3.entity.BookEntity;
import cn.intellif.springprovider3.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @RequestMapping("/save2")
    @Transactional
    public Object save2(){
        try{
            BookEntity bookEntity = new BookEntity();
            bookEntity.setName("yucui");
            bookService.save(bookEntity);
            int i = 1/0;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }
}
