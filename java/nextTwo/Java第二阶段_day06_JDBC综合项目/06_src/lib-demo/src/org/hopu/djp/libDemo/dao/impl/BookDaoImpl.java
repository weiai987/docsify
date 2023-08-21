package org.hopu.djp.libDemo.dao.impl;

import org.hopu.djp.libDemo.dao.IBookDao;
import org.hopu.djp.libDemo.entity.BaseEntity;
import org.hopu.djp.libDemo.entity.Book;
import org.hopu.djp.libDemo.utils.DruidHelper;
import org.hopu.djp.libDemo.utils.PstmtHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    private String getAllField() {
        StringBuffer result = new StringBuffer("book_name,");
        result.append("book_number,");
        result.append("book_price,");
        return result.toString();
    }

    @Override
    public int addOne(Book book, int oprId) {
        int result = 0;
        StringBuffer sql = new StringBuffer("insert into lib_book(");
        sql.append(this.getAllField()).append(BaseEntity.getBaseField());
        sql.append(") values (");
        for(int i=0; i<9; i++) {
            sql.append("?");
            if(i < 8)
                sql.append(",");
        }
        sql.append(")");

        Connection conn = DruidHelper.getConnection();
        List<Object> paramList = new ArrayList<Object>();
        paramList.add(book.getBookName());
        paramList.add(book.getBookNum());
        paramList.add(book.getBookPrice());

        paramList.add(LocalDateTime.now());
        paramList.add(oprId);
        paramList.add(null);
        paramList.add(null);
        paramList.add(Boolean.TRUE);
        paramList.add(Boolean.FALSE);

        PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
        try {
            if(pstmt != null)
                result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidHelper.close(pstmt, conn);
        }
        return result;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = null;
        StringBuffer sql = new StringBuffer("select * from lib_book where delete_flag=?");
        Connection conn = DruidHelper.getConnection();
        if(conn != null) {
            List<Object> paramList = new ArrayList<Object>();
            paramList.add(0);

            PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
            ResultSet rs = null;
            if(pstmt != null) {
                try {
                    rs = pstmt.executeQuery();
                    if(rs != null) {
                        result = new ArrayList<Book>();
                        while(rs.next()) {
                            result.add(this.toBook(rs));
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    DruidHelper.close(rs, pstmt, conn);
                }
            }
        }
        return result;
    }

    @Override
    public Book findById(int bookId) {
        StringBuffer sql = new StringBuffer("select * from lib_book where book_id=?");
        Connection conn = DruidHelper.getConnection();
        if(conn != null) {
            List<Object> paramList = new ArrayList<Object>();
            paramList.add(bookId);

            PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
            ResultSet rs = null;
            if(pstmt != null) {
                try {
                    rs = pstmt.executeQuery();
                    if(rs != null) {
                        if(rs.next()) {
                            return this.toBook(rs);
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    DruidHelper.close(rs, pstmt, conn);
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> findList(Book book) {
        List<Book> result = null;
        StringBuffer sql = new StringBuffer("select * from lib_book where delete_flag=? ");
        Connection conn = DruidHelper.getConnection();
        if(conn != null) {
            List<Object> paramList = new ArrayList<Object>();
            paramList.add(0);
            // 添加名称查询条件
            if(book != null) {
                if(book.getBookName() != null) {
                    sql.append("and book_name like concat(concat('%',?),'%')");
                    paramList.add(book.getBookName());
                }
            }

            PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
            ResultSet rs = null;
            if(pstmt != null) {
                try {
                    rs = pstmt.executeQuery();
                    if(rs != null) {
                        result = new ArrayList<Book>();
                        while(rs.next()) {
                            result.add(this.toBook(rs));
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    DruidHelper.close(rs, pstmt, conn);
                }
            }
        }
        return result;
    }

    @Override
    public int editOne(Book book, int oprId) {
        int result = 0;
        StringBuffer sql = new StringBuffer("update lib_book set ");
        List<Object> paramList = new ArrayList<Object>();

        if(book != null) {
            sql.append(" book_name=?");
            paramList.add(book.getBookName());

            sql.append(", book_number=?");
            paramList.add(book.getBookNum());

            sql.append(", book_price=?");
            paramList.add(book.getBookPrice());

            sql.append(", update_opr=?");
            paramList.add(oprId);

            sql.append(", update_time=?");
            paramList.add(LocalDateTime.now());

            sql.append(" where book_id=?");
            paramList.add(book.getBookId());
        }

        Connection conn = DruidHelper.getConnection();
        if(conn != null) {
            PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
            try {
                if(pstmt != null)
                    result = pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DruidHelper.close(pstmt, conn);
            }
        }
        return result;
    }

    @Override
    public int delOneById(int bookId, int oprId) {
        int result = 0;
        StringBuffer sql = new StringBuffer("update lib_book set delete_flag=?,");
        sql.append(" update_opr=?, update_time=? where book_id=?");
        List<Object> paramList = new ArrayList<Object>();
        paramList.add(1);
        paramList.add(oprId);
        paramList.add(LocalDateTime.now());
        paramList.add(bookId);

        Connection conn = DruidHelper.getConnection();
        if(conn != null) {
            PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
            try {
                if(pstmt != null)
                    result = pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DruidHelper.close(pstmt, conn);
            }
        }
        return result;
    }

    @Override
//    boolean值为true，启用；否则为禁用
    public int enableById(int bookId, Boolean b, int oprId) {
        int result = 0;
        StringBuffer sql = new StringBuffer("update lib_book set enable_flag=?,");
        sql.append(" update_opr=?, update_time=? where book_id=?");
        List<Object> paramList = new ArrayList<Object>();
        paramList.add(b);
        paramList.add(oprId);
        paramList.add(LocalDateTime.now());
        paramList.add(bookId);

        Connection conn = DruidHelper.getConnection();
        if(conn != null) {
            PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
            try {
                if(pstmt != null)
                    result = pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DruidHelper.close(pstmt, conn);
            }
        }
        return result;
    }

    @Override
    public Book toBook(ResultSet rs) {
        if(rs == null) {
            return null;
        }
        Book book = new Book();
        try {
            // 处理业务字段
            book.setBookId(rs.getInt("book_id"));
            book.setBookName(rs.getString("book_name"));
            book.setBookNum(rs.getInt("book_number"));
            book.setBookPrice(rs.getDouble("book_price"));

            // 处理基础字段
            Timestamp cd = rs.getTimestamp("create_time");
            if(cd != null) {
                book.setCreateTime(cd.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            }
            book.setCreateOpr(rs.getInt("create_opr"));

            Timestamp ud = rs.getTimestamp("update_time");
            if(ud != null) {
                book.setUpdateTime(ud.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            }
            book.setUpdateOpr(rs.getInt("update_opr"));

            book.setEnableFlag(rs.getBoolean("enable_flag"));
            book.setDeleteFlag(rs.getBoolean("delete_flag"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }
}
