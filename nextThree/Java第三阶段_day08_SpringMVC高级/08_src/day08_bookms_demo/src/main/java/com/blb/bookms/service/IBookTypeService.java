package com.blb.bookms.service;

import com.blb.bookms.entity.BookTypeTreeNode;

import java.util.List;

public interface IBookTypeService {

    List<BookTypeTreeNode> findAllBookType();
}
