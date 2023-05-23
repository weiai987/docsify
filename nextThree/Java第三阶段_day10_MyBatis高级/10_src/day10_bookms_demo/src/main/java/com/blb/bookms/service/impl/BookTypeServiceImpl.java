package com.blb.bookms.service.impl;

import com.blb.bookms.dao.IBookTypeDAO;
import com.blb.bookms.entity.BookTypeTreeNode;
import com.blb.bookms.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements IBookTypeService {

    @Autowired
    private IBookTypeDAO bookTypeDAO;

    @Override
    public List<BookTypeTreeNode> findAllBookType() {
        return bookTypeDAO.selectAllBookType();
    }
}
