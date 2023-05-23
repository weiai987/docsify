package com.blb.bookms.controller;

import com.blb.bookms.entity.Book;
import com.blb.bookms.entity.Page;
import com.blb.bookms.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 书籍控制器
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/findAllBooks")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "book";
    }

    @GetMapping("/findPage")
    public String findPage(String curr, String typeId, Model model) {
        int current = 1;
        if(curr != null){
            current = Integer.parseInt(curr);
        }
        int tId = 0;
        if(typeId != null){
            tId = Integer.parseInt(typeId);
        }
        Page<Book> page = bookService.findBooksPage(tId,current, Page.LIMIT);
        model.addAttribute("page",page);
        return "book";
    }

    @RequestMapping("/saveBook")
    public String saveBook(Book book, @RequestParam(value = "pic",required = false)CommonsMultipartFile file){
        //保存文件的路径
        String dir = "C:\\tomcat\\apache-tomcat-8.0.33\\webapps\\images\\";
        if(file != null){
            //获得原始文件名
            String filename = file.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            //创建新文件名
            filename = UUID.randomUUID().toString().replace("-","") + suffix;
            //保存文件名
            book.setBookImage(filename);
            //创建文件对象
            File imgFile = new File(dir+filename);
            //保存上传文件到服务器磁盘上
            try {
                file.transferTo(imgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("book:"+book);
        if(book.getState() == null){
            book.setState(0);
        }
        bookService.saveBook(book);
        return "redirect:/pages/index";
    }

    @GetMapping("/findBook")
    public String findBookById(int id,Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        //转发到查询类型方法
        return "forward:/bookType/toBookSave";
    }
}
