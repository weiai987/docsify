package org.hopu.djp.libDemo.service;

import org.hopu.djp.libDemo.entity.Book;

import java.util.List;
import java.util.Map;

public interface IBookService {
    //显示书籍列表
    public List<Book> getBooks();
}
