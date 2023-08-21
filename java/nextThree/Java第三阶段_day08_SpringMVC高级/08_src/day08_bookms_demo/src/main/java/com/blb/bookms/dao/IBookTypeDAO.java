package com.blb.bookms.dao;

import com.blb.bookms.entity.BookType;
import com.blb.bookms.entity.BookTypeTreeNode;

import java.util.List;

public interface IBookTypeDAO {

    List<BookTypeTreeNode> selectAllBookType();

    /**
     * 按id查书籍类型
     * @param typeId
     * @return
     */
    BookType selectBookTypeById(int typeId);
}
