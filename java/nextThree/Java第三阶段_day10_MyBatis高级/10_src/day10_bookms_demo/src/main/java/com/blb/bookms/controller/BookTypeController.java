package com.blb.bookms.controller;

import com.blb.bookms.entity.Book;
import com.blb.bookms.entity.BookTypeTreeNode;
import com.blb.bookms.service.IBookTypeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bookType")
public class BookTypeController {

    @Autowired
    private IBookTypeService bookTypeService;

    @ResponseBody
    @GetMapping("/findBookTypes")
    public List<BookTypeTreeNode> findBookTypes() {
        //查询所有类型节点
        List<BookTypeTreeNode> allBookType = bookTypeService.findAllBookType();
        //把字符串发送给客户端
        return allBookType;
    }

    @GetMapping("/toBookSave")
    public String toBookSave(Model model) {
        //查询所有类型节点
        List<BookTypeTreeNode> allBookType = bookTypeService.findAllBookType();
        model.addAttribute("bookTypes",allBookType);
        return "book_save";
    }

    @ResponseBody
    @GetMapping("/test")
    public Boolean testBook(){
//        Book book = new Book();
//        book.setBookName("西游记");
        return false;
    }
}
