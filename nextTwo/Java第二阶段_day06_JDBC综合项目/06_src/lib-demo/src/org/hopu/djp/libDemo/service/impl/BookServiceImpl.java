package org.hopu.djp.libDemo.service.impl;

import org.hopu.djp.libDemo.dao.IBookDao;
import org.hopu.djp.libDemo.dao.IUserDao;
import org.hopu.djp.libDemo.dao.impl.BookDaoImpl;
import org.hopu.djp.libDemo.dao.impl.UserDaoImpl;
import org.hopu.djp.libDemo.entity.Book;
import org.hopu.djp.libDemo.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private static final IBookDao bookDao = new BookDaoImpl();
    private static final IUserDao userDao = new UserDaoImpl();

    @Override
    public List<Book> getBooks() {
        return bookDao.findList(null);
    }
}
