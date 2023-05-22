package org.hopu.djp.libDemo.test;

import org.hopu.djp.libDemo.dao.IBookDao;
import org.hopu.djp.libDemo.dao.impl.BookDaoImpl;
import org.hopu.djp.libDemo.entity.Book;

import java.util.List;

public class TestBookDao {
    public static IBookDao dao = new BookDaoImpl();
    public static void test1() {
        Book b = new Book();
        b.setBookName("三国演义");
        b.setBookNum(10);
        b.setBookPrice(12.34);
        int x = dao.addOne(b, 1);
        System.out.println("test1.result=" + x);

        b = new Book();
        b.setBookName("红楼梦");
        b.setBookNum(12);
        b.setBookPrice(23.45);
        x = dao.addOne(b, 1);
        System.out.println("test1.result=" + x);

        b = new Book();
        b.setBookName("水浒");
        b.setBookNum(14);
        b.setBookPrice(34.56);
        x = dao.addOne(b, 1);
        System.out.println("test1.result=" + x);

        b = new Book();
        b.setBookName("西游记");
        b.setBookNum(16);
        b.setBookPrice(45.67);
        x = dao.addOne(b, 1);
        System.out.println("test1.result=" + x);
    }

    public static void test2() {
        List<Book> all = dao.findAll();
        for(Book b : all) {
            System.out.println(b);
        }
        System.out.println("--------------------------");
        Book book1 = dao.findById(1);
        System.out.println("book=" + book1);
        Book book2 = dao.findById(2);
        System.out.println("book=" + book2);

    }

    public static void test3() {
        Book book = new Book();
        book.setBookName("2");
        List<Book> all = dao.findList(book);
        for(Book b : all) {
            System.out.println(b);
        }
        System.out.println("--------------------------");
    }

    public static void test4() {
        int x = dao.delOneById(4, 2);
        System.out.println("x=" + x);
    }

    public static void test5() {
        Book b = new Book();
        b.setBookId(6);
        b.setBookName("西游记12");
        b.setBookNum(161);
        b.setBookPrice(415.67);
        int x = dao.editOne(b, 1);
    }

    public static void test6() {
        int x = dao.enableById(6, true, 1);
        System.out.println("x=" + x);
    }

    public static void main(String[] args) {
        TestBookDao.test6();
    }
}
