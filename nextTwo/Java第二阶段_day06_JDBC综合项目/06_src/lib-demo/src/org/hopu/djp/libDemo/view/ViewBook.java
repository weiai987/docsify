package org.hopu.djp.libDemo.view;

import org.hopu.djp.libDemo.entity.Book;
import org.hopu.djp.libDemo.service.IBookService;
import org.hopu.djp.libDemo.service.impl.BookServiceImpl;
import org.hopu.djp.libDemo.utils.TextHelper;

import java.util.List;

public class ViewBook extends ViewParent {

    private static final IBookService service = new BookServiceImpl();

    public static void viewBookList() {
        List<Book> bookList = service.getBooks();
        StringBuffer str = new StringBuffer();
        str.append(TextHelper.infoHead + "图书编号\t图书名称\t图书价格\t现有数量\n");
        for(Book b : bookList) {
            str.append(TextHelper.infoHead + b.getBookId() + "\t\t" + b.getBookName() + "\t\t"
                    + b.getBookPrice() + "\t\t" + b.getBookNum() + "\n");
        }
        out.printf(str.toString());
    }
}
