package com.blb.bookms.service;

import com.blb.bookms.entity.Book;
import com.blb.bookms.entity.Page;

import java.util.List;

public interface IBookService {

    List<Book> findAllBooks();

    /**
     * 分页查询
     * @param current 当前页数
     * @param limit 每页条数
     * @return
     */
    Page<Book> findBooksPage(int current, int limit);

    /**
     * 按类型分页
     * @param typeId
     * @param current
     * @param limit
     * @return
     */
    Page<Book> findBooksPage(int typeId, int current, int limit);

    /**
     * 添加或更新书籍
     * @param book
     */
    void saveBook(Book book);

    /**
     * 按id查询书籍
     * @param id
     * @return
     */
    Book findBookById(int id);
}
