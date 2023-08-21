package com.blb.bookms.service.impl;

import com.blb.bookms.dao.IBookDAO;
import com.blb.bookms.entity.Book;
import com.blb.bookms.entity.Page;
import com.blb.bookms.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDAO bookDAO;

    @Override
    public List<Book> findAllBooks() {
        return bookDAO.selectAllBooks();
    }

    @Override
    public Page<Book> findBooksPage(int current, int limit) {
        Page<Book> page = new Page<>();
        //查询总数
        int count = bookDAO.selectCount();
        //分页查数据
        List<Book> books = bookDAO.selectBooksLimit((current - 1) * limit,limit);
        page.setCount(count);
        page.setLimit(limit);
        page.setData(books);
        page.setCurrent(current);
        return page;
    }

    @Override
    public Page<Book> findBooksPage(int typeId, int current, int limit) {
        //如果为0，查询所有类型
        if(typeId == 0){
            return findBooksPage(current,limit);
        }
        //查询总数
        int count = bookDAO.selectCountType(typeId);
        //分页查数据
        List<Book> books = bookDAO.selectBooksLimitType(typeId,(current - 1) * limit,limit);
        Page<Book> page = new Page<>();
        page.setCount(count);
        page.setLimit(limit);
        page.setData(books);
        page.setCurrent(current);
        return page;
    }

    @Override
    public void saveBook(Book book) {
        //如果有id，进行更新，否则就是添加
        if(book.getId() != null && book.getId() > 0){
            bookDAO.updateBook(book);
        }else {
            bookDAO.saveBook(book);
        }
    }

    @Override
    public Book findBookById(int id) {
        return bookDAO.selectBookById(id);
    }
}
