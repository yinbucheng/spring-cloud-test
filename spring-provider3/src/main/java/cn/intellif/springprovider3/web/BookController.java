package cn.intellif.springprovider3.web;

import cn.intellif.springprovider3.entity.BookEntity;
import cn.intellif.springprovider3.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IBookService bookService;

    @RequestMapping("save")
    public Object save(){
        logger.info(">>>>>>>>>>>>>>>>>>>>>>BookController save1 invoke");
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("hahaha");
        bookService.save(bookEntity);
        return "success";
    }

    @RequestMapping("/save2")
    @Transactional
    public Object save2(){
        try{
            logger.info(">>>>>>>>>>>>>>>>>>>>>>BookController save2 invoke");
            BookEntity bookEntity = new BookEntity();
            bookEntity.setName("yucui");
            bookService.save(bookEntity);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }
}
