package com.blb.bookms.entity;


import java.util.List;

public class BookType {

  private long id;
  private String type;

  //书籍的集合
  private List<Book> books;

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
