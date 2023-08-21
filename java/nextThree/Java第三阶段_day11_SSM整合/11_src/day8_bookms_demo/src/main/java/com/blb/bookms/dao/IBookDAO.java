package com.blb.bookms.dao;

import com.blb.bookms.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookDAO {

    /**
     * 查询所有书
     * @return
     */
    List<Book> selectAllBooks();

    /**
     * 查询总数
     *
     * @return
     */
    int selectCount();

    /**
     * limit分页查询
     *
     * @param start
     * @param length
     * @return
     */
    List<Book> selectBooksLimit(@Param("start") int start, @Param("length") int length);

    /**
     * 按类型查询总数
     *
     * @return
     */
    int selectCountType(int typeId);

    /**
     * 按类型实现limit分页查询
     *
     * @param start
     * @param length
     * @return
     */
    List<Book> selectBooksLimitType(@Param("typeId") int typeId, @Param("start") int start, @Param("length") int length);

    /**
     * 保存书籍
     *
     * @param book
     */
    void saveBook(Book book);

    /**
     * 根据id查询书籍
     *
     * @param id
     * @return
     */
    Book selectBookById(int id);

    /**
     * 更新书籍
     *
     * @param book
     */
    void updateBook(Book book);

    /**
     * 按book的属性多条件查询
     *
     * @param book
     * @return
     */
    List<Book> selectBooksByBook(Book book);

    /**
     * 按多本书籍名称查询书籍
     * @param bookNames
     * @return
     */
    List<Book> selectBooksByBookNameList(@Param("bookNames") List<String> bookNames);

    /**
     * 查询
     * @param typeId
     * @return
     */
    List<Book> selectBooksByTypeId(int typeId);
}